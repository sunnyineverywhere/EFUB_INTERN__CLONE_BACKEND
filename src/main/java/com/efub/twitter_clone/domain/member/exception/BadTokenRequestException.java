package com.efub.twitter_clone.domain.member.exception;


import static com.efub.twitter_clone.global.constant.ResponseConstant.BAD_TOKEN_REQUEST;

public class BadTokenRequestException extends RuntimeException {
	public BadTokenRequestException() {
		super(BAD_TOKEN_REQUEST);
	}

	@Override
	public String getMessage() {
		return super.getMessage();
	}
}
