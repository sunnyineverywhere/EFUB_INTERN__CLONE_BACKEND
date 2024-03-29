package com.efub.twitter_clone.global.constant;

public class ResponseConstant {

	/* Users */
	// login
	public static final String LOGIN_SUCCESS = "성공적으로 로그인되었습니다.";

	//tempPassword
	public static final String SEND_EMAIL_SUCCESS = "성공적으로 임시 비밀번호를 전송했습니다.";

	// withdraw
	public static final String WITHDRAW_SUCCESS = "성공적으로 탈퇴되었습니다.";
	public static final String AVAILABLE_NICKNAME = "사용할 수 있는 닉네임입니다.";
	public static final String AVAILABLE_EMAIL = "사용할 수 있는 이메일입니다.";

	// signup
	public static final String SIGNUP_SUCCESS = "성공적으로 가입되었습니다.";


	// exception
	public static final String DUPLICATE_NICKNAME = "중복된 닉네임이 존재합니다.";
	public static final String DUPLICATE_EMAIL = "중복된 이메일이 존재합니다.";
	public static final String PASSWORD_NOT_MATCH = "비밀번호가 일치하지 않습니다.";
	public static final String NOTFOUND_USER = "해당 유저를 찾을 수 없습니다.";

	public static final String PASSWORDS_NOT_EQUAL = "입력한 새 비밀번호가 서로 일치하지 않습니다.";
	public static final String BEFORE_PASSWORD_NOT_MATCH = "현재 비밀번호가 일치하지 않습니다.";


	/*Likes*/
	public static final String LIKES_ADD_SUCCESS = "좋아요가 추가되었습니다";
	public static final String LIKES_DELETE_SUCCESS = "좋아요가 취소되었습니다";

	/*Comment*/
	public static final String COMMENT_ADD_SUCCESS = "해당 댓글이 작성되었습니다.";
	public static final String COMMENT_DELETE_SUCCESS = "댓글이 삭제되었습니다.";
	public static final String NOTFOUND_PARENT = "상위 댓글이 존재하지 않습니다.";
	public static final String NO_AUTHORIZATION = "권한이 없습니다.";

	/* Token */
	public static final String BAD_TOKEN_REQUEST = "토큰을 확인하세요";
	public static final String EXPIRED_REFRESHTOKEN = "refresh 토큰이 만료되었습니다.";
	public static final String REISSUE_TOKEN_SUCCESS = "토큰이 재발급되었습니다.";
}
