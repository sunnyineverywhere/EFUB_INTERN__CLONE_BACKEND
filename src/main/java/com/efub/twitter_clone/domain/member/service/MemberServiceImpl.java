package com.efub.twitter_clone.domain.member.service;

import com.efub.twitter_clone.domain.member.dto.SignupReqDto;
import com.efub.twitter_clone.domain.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{
	private final MemberRepository memberRepository;
	//private final PasswordEncoder passwordEncoder;

	@Override
	public void signup(SignupReqDto signupReqDto) {
		//signupReqDto.setPassword(passwordEncoder.encode(signupReqDto.getPassword()));
		memberRepository.save(signupReqDto.toEntity());
	}

}
