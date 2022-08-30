package com.efub.twitter_clone.global.exception;


import com.efub.twitter_clone.domain.member.exception.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.DateTimeException;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

	/*================== Basic Exception ==================*/
	@ExceptionHandler(RuntimeException.class)
	protected final ResponseEntity<ErrorResponse> handleRunTimeException(RuntimeException e) {
		final ErrorResponse response = ErrorResponse.builder()
				.status(HttpStatus.BAD_REQUEST)
				.code(ErrorCode.RUNTIME_EXCEPTION)
				.message(e.getMessage())
				.build();
		return ResponseEntity.status(response.getStatus()).body(response);
	}


	//vaild 오류
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex){
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors()
				.forEach(c -> errors.put(((FieldError) c).getField(), c.getDefaultMessage()));
		return ResponseEntity.badRequest().body(errors);
	}


	/*================== Image Exception ==================
	@ExceptionHandler(ImageFileMissingException.class)
	protected final ResponseEntity<ErrorResponse> handleImageFileMissingException(ImageFileMissingException e){
		final ErrorResponse response = ErrorResponse.builder()
				.status(HttpStatus.BAD_REQUEST)
				.code(ErrorCode.IMAGE_MISSING)
				.message(e.getMessage())
				.build();
		return ResponseEntity.status(response.getStatus()).body(response);
	}

	@ExceptionHandler(ImageNotFoundException.class)
	protected final ResponseEntity<ErrorResponse> handleImageNotFoundException(ImageNotFoundException e){
		final ErrorResponse response = ErrorResponse.builder()
				.status(HttpStatus.NOT_FOUND)
				.code(ErrorCode.IMAGE_NOT_FOUND)
				.message(e.getMessage())
				.build();
		return ResponseEntity.status(response.getStatus()).body(response);
	}
*/

	/*================== User Exception ==================*/
	@ExceptionHandler(DuplicateEmailException.class)
	protected final ResponseEntity<ErrorResponse> handleDuplicateEmailException(DuplicateEmailException e) {
		final ErrorResponse response = ErrorResponse.builder()
				.status(HttpStatus.BAD_REQUEST)
				.code(ErrorCode.DUPLICATE_EMAIL)
				.message(e.getMessage())
				.build();
		return ResponseEntity.status(response.getStatus()).body(response);
	}

	@ExceptionHandler(DuplicateNicknameException.class)
	protected final ResponseEntity<ErrorResponse> handleDuplicateNicknameException(DuplicateNicknameException e) {
		final ErrorResponse response = ErrorResponse.builder()
				.status(HttpStatus.BAD_REQUEST)
				.code(ErrorCode.DUPLICATE_NICKNAME)
				.message(e.getMessage())
				.build();
		return ResponseEntity.status(response.getStatus()).body(response);
	}

	@ExceptionHandler(PasswordNotMatchedException.class)
	protected final ResponseEntity<ErrorResponse> handlePasswordNotMatchedException(PasswordNotMatchedException e) {
		final ErrorResponse response = ErrorResponse.builder()
				.status(HttpStatus.BAD_REQUEST)
				.code(ErrorCode.PASSWORD_NOT_MATCH)
				.message(e.getMessage())
				.build();
		return ResponseEntity.status(response.getStatus()).body(response);

	}

	/*@ExceptionHandler(PasswordsNotEqualException.class)
	protected final ResponseEntity<ErrorResponse> handlePasswordsNotEqualException(PasswordsNotEqualException e) {
		final ErrorResponse response = ErrorResponse.builder()
				.status(HttpStatus.BAD_REQUEST)
				.code(ErrorCode.PASSWORDS_NOT_EQUAL)
				.message(e.getMessage())
				.build();
		return ResponseEntity.status(response.getStatus()).body(response);

	}

	@ExceptionHandler(BeforePasswordNotMatchException.class)
	protected final ResponseEntity<ErrorResponse> handleBeforePasswordNotMatchException(BeforePasswordNotMatchException e) {
		final ErrorResponse response = ErrorResponse.builder()
				.status(HttpStatus.BAD_REQUEST)
				.code(ErrorCode.BEFORE_PASSWORD_NOT_MATCH)
				.message(e.getMessage())
				.build();
		return ResponseEntity.status(response.getStatus()).body(response);

	}
	*/


	// 존재하지 않는 유저
	@ExceptionHandler(UserNotFoundException.class)
	protected final ResponseEntity<ErrorResponse> handleUserNotFoundException(UserNotFoundException e) {
		final ErrorResponse response = ErrorResponse.builder()
				.status(HttpStatus.NOT_FOUND)
				.code(ErrorCode.USER_NOT_FOUND)
				.message(e.getMessage())
				.build();
		return ResponseEntity.status(response.getStatus()).body(response);
	}

	/*================== Friend Exception ==================
	@ExceptionHandler(DuplicateFriendException.class)
	protected final ResponseEntity<ErrorResponse> handleDuplicateFriendException(DuplicateFriendException e) {
		final ErrorResponse response = ErrorResponse.builder()
				.status(HttpStatus.BAD_REQUEST)
				.code(ErrorCode.DUPLICATE_FRIEND)
				.message(e.getMessage())
				.build();
		return ResponseEntity.status(response.getStatus()).body(response);
	}

	 */

	/*================== File Exception ==================
	// io 예외
	@ExceptionHandler(S3IOException.class)
	protected final ResponseEntity<ErrorResponse> handleS3IOException(S3IOException e) {
		final ErrorResponse response = ErrorResponse.builder()
				.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.code(ErrorCode.S3_UPLOAD_FAILURE)
				.message(e.getMessage())
				.build();
		return ResponseEntity.status(response.getStatus()).body(response);
	}

	// 파일 형식 잘못된 경우
	@ExceptionHandler(FileExtenstionException.class)
	protected final ResponseEntity<ErrorResponse> handleFileExtenstionException(FileExtenstionException e) {
		final ErrorResponse response = ErrorResponse.builder()
				.status(HttpStatus.BAD_REQUEST)
				.code(ErrorCode.FILE_UPLOAD_FAILURE)
				.message(e.getMessage())
				.build();
		return ResponseEntity.status(response.getStatus()).body(response);
	}

	*/

	/*================== Security Exception ==================*/
	@ExceptionHandler(BadTokenRequestException.class)
	protected final ResponseEntity<ErrorResponse> handleBadTokenRequestException(BadTokenRequestException e) {
		final ErrorResponse response = ErrorResponse.builder()
				.status(HttpStatus.BAD_REQUEST)
				.code(ErrorCode.TOKEN_VALIDATE_FAILURE)
				.message(e.getMessage())
				.build();
		return ResponseEntity.status(response.getStatus()).body(response);
	}


	@ExceptionHandler(RefreshTokenExpiredException.class)
	protected final ResponseEntity<ErrorResponse> handleAccessTokenExpiredException(RefreshTokenExpiredException e) {
		final ErrorResponse response = ErrorResponse.builder()
				.status(HttpStatus.BAD_REQUEST)
				.code(ErrorCode.REFRESHTOKEN_EXPIRED)
				.message(e.getMessage())
				.build();
		return ResponseEntity.status(response.getStatus()).body(response);
	}



	/*================== Comment Exception ==================
	@ExceptionHandler(CommentNotFoundException.class)
	protected final ResponseEntity<ErrorResponse> handleCommentNotFoundException(CommentNotFoundException e) {
		final ErrorResponse response = ErrorResponse.builder()
				.status(HttpStatus.NOT_FOUND)
				.code(ErrorCode.COMMENT_NOT_FOUND)
				.message(e.getMessage())
				.build();
		return ResponseEntity.status(response.getStatus()).body(response);
	}

	@ExceptionHandler(ParentNotFoundException.class)
	protected final ResponseEntity<ErrorResponse> handleParentNotFoundException(ParentNotFoundException e) {
		final ErrorResponse response = ErrorResponse.builder()
				.status(HttpStatus.NOT_FOUND)
				.code(ErrorCode.PARENT_NOT_FOUND)
				.message(e.getMessage())
				.build();
		return ResponseEntity.status(response.getStatus()).body(response);
	}

	@ExceptionHandler(UnauthorizedException.class)
	protected final ResponseEntity<ErrorResponse> handleUnauthorizedException(UnauthorizedException e) {
		final ErrorResponse response = ErrorResponse.builder()
				.status(HttpStatus.UNAUTHORIZED)
				.code(ErrorCode.UNAUTHORIZED_USER)
				.message(e.getMessage())
				.build();
		return ResponseEntity.status(response.getStatus()).body(response);
	}

	 */
}
