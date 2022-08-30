package com.efub.twitter_clone.global.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.*;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

	/* Common */
	// Basic - C0***
	RUNTIME_EXCEPTION(BAD_REQUEST, "C0001", "RUNTIME_EXCEPTION"),

	// User - C2***
	DUPLICATE_NICKNAME(CONFLICT, "C2001", "DUPLICATE_NICKNAME_EXISTS"),
	DUPLICATE_EMAIL(CONFLICT, "C2002", "DUPLICATE_EMAIL_EXISTS"),
	USER_NOT_FOUND(NOT_FOUND, "C2003", "USER_NOT_FOUND"),
	PASSWORD_NOT_MATCH(BAD_REQUEST, "C2004", "PASSWORD_NOT_MATCH"),


	// Comment - C4***
	COMMENT_NOT_FOUND(NOT_FOUND, "C4001", "COMMENT_NOT_FOUND"),
	PARENT_NOT_FOUND(NOT_FOUND, "C4002", "PARENT_NOT_FOUND"),
	UNAUTHORIZED_USER(UNAUTHORIZED, "C4003", "UNAUTHORIZED_USER"),

	// Exception
	S3_UPLOAD_FAILURE(INTERNAL_SERVER_ERROR, "E0001", "NETWORK_FAILURE"),
	FILE_UPLOAD_FAILURE(BAD_REQUEST, "E0002", "WRONG_FILE_TYPE"),
	TOKEN_VALIDATE_FAILURE(BAD_REQUEST, "E1001", "INVALID_TOKEN"),
	REFRESHTOKEN_EXPIRED(BAD_REQUEST, "E1002", "REFRESHTOKEN_EXPIRED"),

	//SUCCESS
	LOGOUT_SUCCESS(OK, "S0001", "LOGOUT_SUCCESS");

	private final HttpStatus status;
	private final String code;
	private final String message;
}
