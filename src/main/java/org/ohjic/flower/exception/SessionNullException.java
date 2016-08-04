package org.ohjic.flower.exception;

import org.ohjic.flower.exception.common.CommonException;
import org.ohjic.flower.exception.common.ResponseCode;

public class SessionNullException extends CommonException {
	public SessionNullException() {
		super(ResponseCode.SESSION_NULL);
	}
}
