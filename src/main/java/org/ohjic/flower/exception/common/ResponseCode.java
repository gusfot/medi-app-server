package org.ohjic.flower.exception.common;

public enum ResponseCode {
	SUCCESS("SUCC00", ""),
	UNKOWN("ERR0000", "알 수 없는 오류입니다."),
	INVALID_USER("ERR0001", "일치하는 회원 정보가 없습니다."),
	PERMISSION_DENIED("ERR0003", "권한이 없습니다."), 
	SESSION_NULL("ERR0004", "세션이 없습니다. 로그인이 필요합니다")
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

	public static ResponseCode getResponseCodeByCode(String code) {
		ResponseCode[] values = ResponseCode.values();
		
		for (ResponseCode responseCode : values) {
			if(responseCode.getCode().equals(code)) {
				return responseCode;
			}
		}
		
		return null;
	}
}
