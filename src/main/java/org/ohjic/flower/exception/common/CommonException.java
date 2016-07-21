package org.ohjic.flower.exception.common;

public class CommonException {

	private ErrorCode errorCode;

	public CommonException(ErrorCode errorCode) {
		this.errorCode = errorCode;
	}

	public ErrorCode getErrorCode() {
		return errorCode;
	}
}
