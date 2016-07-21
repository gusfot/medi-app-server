package org.ohjic.flower.exception.common;

public enum ErrorCode {
	INVALID_PASSWORD("ERR0001", "잘못된 비밀번호입니다.");

	private String code;
	private String message;

	ErrorCode(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}
}
