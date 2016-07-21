package org.ohjic.flower.exception.common;

public class CommonException extends Exception {

	private ResponseCode responseCode;

	public CommonException(ResponseCode responseCode) {
		this.responseCode = responseCode;
	}

	public ResponseCode getResponseCode() {
		return responseCode;
	}
}
