package org.ohjic.flower.exception;

import org.ohjic.flower.exception.common.CommonException;
import org.ohjic.flower.exception.common.ResponseCode;

public class InvalidUserException extends CommonException {
	public InvalidUserException() {
		super(ResponseCode.INVALID_USER);
	}
}
