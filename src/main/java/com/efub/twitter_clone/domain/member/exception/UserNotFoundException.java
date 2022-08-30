package com.efub.twitter_clone.domain.member.exception;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import static com.efub.twitter_clone.global.constant.ResponseConstant.NOTFOUND_USER;

public class UserNotFoundException extends ResourceNotFoundException {

	public UserNotFoundException() {
		super(NOTFOUND_USER);
	}

	@Override
	public String getMessage() {
		return super.getMessage();
	}
}