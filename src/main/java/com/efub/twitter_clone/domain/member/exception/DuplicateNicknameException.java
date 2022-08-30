package com.efub.twitter_clone.domain.member.exception;


import static com.efub.twitter_clone.global.constant.ResponseConstant.DUPLICATE_NICKNAME;

public class DuplicateNicknameException extends IllegalArgumentException {
	public DuplicateNicknameException() {
		super(DUPLICATE_NICKNAME);
	}

	@Override
	public String getMessage() {
		return super.getMessage();
	}
}
