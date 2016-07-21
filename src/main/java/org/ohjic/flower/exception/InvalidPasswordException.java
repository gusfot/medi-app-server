package org.ohjic.flower.exception;

import org.ohjic.flower.exception.common.CommonException;
import org.ohjic.flower.exception.common.ResponseCode;

public class InvalidPasswordException extends CommonException {
	public InvalidPasswordException() {
		super(ResponseCode.INVALID_PASSWORD);
	}
}
