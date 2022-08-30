package com.efub.twitter_clone.domain.member.exception;


import static com.efub.twitter_clone.global.constant.ResponseConstant.DUPLICATE_EMAIL;

public class DuplicateEmailException extends IllegalArgumentException {
	public DuplicateEmailException() {
		super(DUPLICATE_EMAIL);
	}

	@Override
	public String getMessage() {
		return super.getMessage();
	}
}
