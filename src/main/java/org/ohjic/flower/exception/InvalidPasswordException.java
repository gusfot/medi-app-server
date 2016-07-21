package org.ohjic.flower.exception;

import org.ohjic.flower.exception.common.CommonException;
import org.ohjic.flower.exception.common.ErrorCode;

public class InvalidPasswordException extends CommonException {
	public InvalidPasswordException() {
		super(ErrorCode.INVALID_PASSWORD);
	}
}
