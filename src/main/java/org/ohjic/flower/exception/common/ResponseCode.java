package org.ohjic.flower.exception.common;

public enum ResponseCode {
	SUCCESS("SUCC00", ""),
	UNKOWN("ERR0000", "알 수 없는 오류입니다."),
	INVALID_USER("ERR0001", "일치하는 회원 정보가 없습니다."),
	PERMISSION_DENIED("ERR0002", "권한이 없습니다."), 
	INVALID_PHONE_NUMBER("ERR0003", "잘못된 전화번호입니다."),
	UNSERVICEABLE_TEXT_MESSAGE("ERR0004", "문자 메세지 서비스를 사용할 수 없습니다."),
	SESSION_NULL("ERR0005", "세션이 없습니다. 로그인이 필요합니다"),
	RESOURCE_NOT_FOUND("ERR0006", "리소스를 찾을 수 없습니다."),
	CANNOT_SEND_NOTE_MESSAGE("ERR0007", "쪽지를 전송할 수 없습니다."),
	INVALID_PAGE_NUMBER("ERR0008", "잘못된 페이지입니다."),
	INVALID_PASSWORD("ERR0009", "잘못된 비밀번호입니다."),
	FILEUPLOAD_FAIL("ERR0010", "파일업로드에 실패했습니다."),
	FILE_CONTENTTYPE("ERR0011", "파일 형식이 맞지 않습니다.")
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
