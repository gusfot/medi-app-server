package org.ohjic.flower.exception.common;

public enum ResponseCode {
	SUCCESS("SUCC00", ""),
	INVALID_PASSWORD("ERR0001", "잘못된 비밀번호입니다."),
	PERMISSION_DENIED("ERR0002", "권한이 없습니다."),
	FILEUPLOAD_FAIL("ERR0003", "파일업로드에 실패했습니다."),
	FILE_CONTENTTYPE("ERR0004", "파일 형식이 맞지 않습니다.")
	;

	private String code;
	private String message;

	ResponseCode(String code, String message) {
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
