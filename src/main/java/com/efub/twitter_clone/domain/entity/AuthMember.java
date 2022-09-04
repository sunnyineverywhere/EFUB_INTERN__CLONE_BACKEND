package com.efub.twitter_clone.domain.entity;

import lombok.Getter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.List;

@Getter
public class AuthMember extends User {
	private final Member member;

	public AuthMember(Member member) {
		super(member.getEmail(), member.getPassword(), List.of(new SimpleGrantedAuthority(member.getRole())));
		this.member = member;
	}
}
