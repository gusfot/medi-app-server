package org.ohjic.flower.exception;

import org.ohjic.flower.exception.common.CommonException;
import org.ohjic.flower.exception.common.ResponseCode;

public class InvalidPhoneNumberException extends CommonException {

	private static final long serialVersionUID = 8633670748533747686L;

	public InvalidPhoneNumberException() {
		super(ResponseCode.INVALID_PHONE_NUMBER);
	}

}
