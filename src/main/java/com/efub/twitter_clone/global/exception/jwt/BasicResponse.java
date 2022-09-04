package com.efub.twitter_clone.global.exception.jwt;


import com.efub.twitter_clone.global.exception.ErrorCode;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;


@Getter
@NoArgsConstructor
public class BasicResponse {
	private HttpStatus status;
	private ErrorCode code;
	private String message;

	@Builder
	public BasicResponse(HttpStatus status, ErrorCode code, String message) {
		this.status = status;
		this.code = code;
		this.message = message;
	}
}
