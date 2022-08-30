package com.efub.twitter_clone.domain.member.controller;


import com.efub.twitter_clone.domain.member.exception.DuplicateEmailException;
import com.efub.twitter_clone.domain.member.exception.DuplicateNicknameException;
import com.efub.twitter_clone.domain.member.service.MemberService;
import com.efub.twitter_clone.domain.member.dto.SignupReqDto;
import com.efub.twitter_clone.domain.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static com.efub.twitter_clone.global.constant.ResponseConstant.AVAILABLE_NICKNAME;
import static com.efub.twitter_clone.global.constant.ResponseConstant.SIGNUP_SUCCESS;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class SignupController {

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
}
