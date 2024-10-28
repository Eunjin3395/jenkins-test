package com.challenge.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.*;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

    /**
     * 공통으로 사용되는 일반적인 에러
     */
    COMMON_INTERNAL_SERVER_ERROR(INTERNAL_SERVER_ERROR, "COMMON_500", "서버 에러, 관리자에게 문의 바랍니다."),
    COMMON_BAD_REQUEST(BAD_REQUEST, "COMMON_400", "잘못된 요청입니다."),
    COMMON_UNAUTHORIZED(UNAUTHORIZED, "COMMON_401", "인증이 필요합니다."),
    COMMON_FORBIDDEN(FORBIDDEN, "COMMON_403", "금지된 요청입니다."),
    COMMON_NETWORK_ERROR(GATEWAY_TIMEOUT, "COMMON_504", "네트워크 오류가 발생하였습니다. 잠시 후 다시 시도해주세요."),

    /**
     * 인증 관련 에러
     */
    INVALID_REQUEST_BODY(BAD_REQUEST, "AUTH_4000", "잘못된 요청입니다."),
    EXPIRED_KAKAO_ACCESS_TOKEN(UNAUTHORIZED, "AUTH_4001", "유효하지 않은 액세스 토큰입니다."),
    INVALID_TOKEN_EXCEPTION(UNAUTHORIZED, "AUTH_4002", "토큰이 올바르지 않습니다."),
    INVALID_REFRESH_TOKEN(BAD_REQUEST, "AUTH_4003", "리프레쉬 토큰이 유효하지 않습니다. 다시 로그인 해주세요"),
    EXPIRED_JWT_EXCEPTION(UNAUTHORIZED, "AUTH_4004", "기존 토큰이 만료되었습니다. 토큰을 재발급해주세요."),
    UNAUTHORIZED_EXCEPTION(UNAUTHORIZED, "AUTH_4005", "로그인 후 이용가능합니다. 토큰을 입력해 주세요"),
    INACTIVE_MEMBER(NOT_FOUND, "AUTH_4006", "탈퇴한 사용자 입니다."),

    /**
     * 사용자 관련 에러
     */
    USER_DUPLICATE_LOGIN_ID(UNPROCESSABLE_ENTITY, "USER_4001", "이미 존재하는 아이디입니다.");

    private final HttpStatus status;
    private final String code;
    private final String message;
}

