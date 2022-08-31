package com.efub.twitter_clone.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Member extends BaseTimeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long memberId;


	@NotNull
	private String email;

	@JsonIgnore
	@NotNull
	private String password;

	@NotNull
	private String nickname;


	//프로필 -> 나중 구현

	private String role;

	@Builder
	public Member(Long memberId, String email, String password, String nickname) {
		this.memberId = memberId;
		this.email = email;
		this.password = password;
		this.nickname = nickname;
		role = "USER";
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
