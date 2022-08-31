package com.efub.twitter_clone.domain.member.service;

import com.efub.twitter_clone.domain.member.dto.LoginResDto;
import com.efub.twitter_clone.domain.member.dto.SignupReqDto;
import org.springframework.http.ResponseCookie;

import javax.servlet.http.HttpServletResponse;

public interface MemberService {
	void signup(SignupReqDto signupReqDto);

	LoginResDto login(String email, String password);

	ResponseCookie generateCookie(String type, String token);

	public void logout(String email, String accessToken);

	public LoginResDto reIssueAccessToken(String email, String refreshToken);

}
