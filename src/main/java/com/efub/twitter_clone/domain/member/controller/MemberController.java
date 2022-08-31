package com.efub.twitter_clone.domain.member.controller;


import com.efub.twitter_clone.domain.entity.Member;
import com.efub.twitter_clone.domain.member.dto.LoginReqDto;
import com.efub.twitter_clone.domain.member.dto.LoginResDto;
import com.efub.twitter_clone.domain.member.exception.DuplicateEmailException;
import com.efub.twitter_clone.domain.member.exception.DuplicateNicknameException;
import com.efub.twitter_clone.domain.member.service.MemberService;
import com.efub.twitter_clone.domain.member.dto.SignupReqDto;
import com.efub.twitter_clone.domain.repository.MemberRepository;
import com.efub.twitter_clone.global.customAnnotation.AuthMember;
import com.efub.twitter_clone.global.exception.ErrorCode;
import com.efub.twitter_clone.global.exception.jwt.BasicResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import static com.efub.twitter_clone.global.constant.ResponseConstant.*;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class MemberController {

	private final MemberService memberService;
	private final MemberRepository memberRepository;

	@PostMapping("/signup")
	public ResponseEntity<String> signup(@Valid @RequestBody SignupReqDto reqDto) {
		memberService.signup(reqDto);
		return ResponseEntity.ok(SIGNUP_SUCCESS);
	}

	@GetMapping("/signup/email")
	public ResponseEntity<?> checkEmailDuplicate(@Valid @RequestParam String email) {
		if (memberRepository.existsByEmail(email)) {
			throw new DuplicateEmailException();
		} else {
			return ResponseEntity.ok(AVAILABLE_NICKNAME);

		}
	}

	@GetMapping("/signup/nickname")
	public ResponseEntity<?> checkNicknameDuplicate(@Valid @RequestParam String nickname) {
		if (memberRepository.existsByNickname(nickname)) {
			throw new DuplicateNicknameException();
		} else {
			return ResponseEntity.ok(AVAILABLE_NICKNAME);
		}
	}

	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody LoginReqDto loginDto) {
		LoginResDto loginResDto = memberService.login(loginDto.getEmail(), loginDto.getPassword());
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("Set-Cookie", memberService.generateCookie("accessToken", loginResDto.getAccessToken()).toString());
		responseHeaders.add("Set-Cookie",memberService.generateCookie("refreshToken", loginResDto.getRefreshToken()).toString());
		return new ResponseEntity<String>(LOGIN_SUCCESS, responseHeaders, HttpStatus.CREATED);
	}


	@GetMapping("/re-issue")
	public ResponseEntity<String> reIssue(@RequestParam("email") String email, HttpServletRequest request) {
		String refreshToken = request.getHeader("Authorization").substring(7);
		LoginResDto responseDto = memberService.reIssueAccessToken(email, refreshToken);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("Set-Cookie", memberService.generateCookie("accessToken", responseDto.getAccessToken()).toString());
		responseHeaders.add("Set-Cookie",memberService.generateCookie("refreshToken", responseDto.getRefreshToken()).toString());
		return new ResponseEntity<String>(REISSUE_TOKEN_SUCCESS, responseHeaders, HttpStatus.CREATED);
	}

	@GetMapping("/logout")
	public ResponseEntity<BasicResponse> logout(@AuthMember Member member, HttpServletRequest request) {
		String accessToken = request.getHeader("Authorization").substring(7);
		memberService.logout(member.getEmail(), accessToken);
		BasicResponse response = new BasicResponse(HttpStatus.OK, ErrorCode.LOGOUT_SUCCESS, "LOGOUT_SUCCESS");
		return new ResponseEntity<>(response, HttpStatus.OK);

	}

}
