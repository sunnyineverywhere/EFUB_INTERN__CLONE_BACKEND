package com.efub.twitter_clone.domain.member.service;

import com.efub.twitter_clone.domain.entity.AuthMember;
import com.efub.twitter_clone.domain.entity.Member;
import com.efub.twitter_clone.domain.member.exception.BadTokenRequestException;
import com.efub.twitter_clone.domain.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomMemberDetailService implements UserDetailsService { //AuthenticationProvider는 내부적으로 UserDetailsService를 이용한다. UserDetailsService는 실제로 인증을 위한 데이터를 가져오는 역할을 한다.
	private final MemberRepository memberRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Member member = memberRepository.findByEmail(email)
				.orElseThrow(BadTokenRequestException::new);
		System.out.println(member.getEmail());
		return new AuthMember(member);
	}
}
