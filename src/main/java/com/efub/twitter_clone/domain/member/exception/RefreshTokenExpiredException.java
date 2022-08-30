package com.efub.twitter_clone.domain.member.exception;

import static com.efub.twitter_clone.global.constant.ResponseConstant.EXPIRED_REFRESHTOKEN;

public class RefreshTokenExpiredException extends RuntimeException {
	public RefreshTokenExpiredException() {
		super(EXPIRED_REFRESHTOKEN);
	}

	@Override
	public String getMessage() {
		return super.getMessage();
	}
}
