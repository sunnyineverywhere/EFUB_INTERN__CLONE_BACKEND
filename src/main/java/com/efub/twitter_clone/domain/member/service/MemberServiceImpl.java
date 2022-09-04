package com.efub.twitter_clone.domain.member.service;

import com.efub.twitter_clone.domain.entity.Member;
import com.efub.twitter_clone.domain.member.dto.LoginResDto;
import com.efub.twitter_clone.domain.member.dto.SignupReqDto;
import com.efub.twitter_clone.domain.member.exception.PasswordNotMatchedException;
import com.efub.twitter_clone.domain.member.exception.UserNotFoundException;
import com.efub.twitter_clone.domain.repository.MemberRepository;
import com.efub.twitter_clone.global.config.jwt.JwtProvider;
import lombok.RequiredArgsConstructor;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.http.ResponseCookie;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{
	private final MemberRepository memberRepository;
	private final PasswordEncoder passwordEncoder;

	private final JwtProvider jwtProvider;

	@Override
	public void signup(SignupReqDto signupReqDto) {
		signupReqDto.setPassword(passwordEncoder.encode(signupReqDto.getPassword()));
		memberRepository.save(signupReqDto.toEntity());
	}

	@Override
	public LoginResDto login(String email, String password) {
		Member member = memberRepository
				.findByEmail(email).orElseThrow(UserNotFoundException::new);
		checkPassword(password, member.getPassword());
		String accessToken = jwtProvider.createAccessToken(member.getEmail(), member.getRole());
		String refreshToken = jwtProvider.createRefreshToken(member.getEmail(), member.getRole());
		return new LoginResDto(accessToken, refreshToken, member.getNickname());
	}

	@Override
	public LoginResDto reIssueAccessToken(String email, String refreshToken) {
		Member member = memberRepository.findByEmail(email).orElseThrow(UserNotFoundException::new);
		jwtProvider.checkRefreshToken(email, refreshToken);
		String accessToken = jwtProvider.createAccessToken(member.getEmail(), member.getRole());
		return new LoginResDto(accessToken, refreshToken, member.getNickname());
	}

	private void checkPassword(String password, String encodedPassword) {
		boolean isSame = passwordEncoder.matches(password, encodedPassword);
		if (!isSame) {
			throw new PasswordNotMatchedException();
		}

	}

	@Override
	public ResponseCookie generateCookie(String type, String token)
	{
		ResponseCookie cookie = ResponseCookie.from(type, token)
				.maxAge(7 * 24 * 60 * 60)
				.path("/")
				.secure(true)
				.sameSite("None")
				.httpOnly(true)
				.build();
		return cookie;

	}


	public void logout(String email, String accessToken) {
		jwtProvider.logout(email, accessToken);
	}

}
