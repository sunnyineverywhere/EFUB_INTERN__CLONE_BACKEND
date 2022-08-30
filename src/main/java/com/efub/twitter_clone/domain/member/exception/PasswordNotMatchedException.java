package com.efub.twitter_clone.domain.member.exception;


import static com.efub.twitter_clone.global.constant.ResponseConstant.PASSWORD_NOT_MATCH;

public class PasswordNotMatchedException extends IllegalArgumentException {

	public PasswordNotMatchedException() {
		super(PASSWORD_NOT_MATCH);
	}

	@Override
	public String getMessage() {
		return super.getMessage();
	}
}