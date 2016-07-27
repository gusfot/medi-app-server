package org.ohjic.flower.exception;

import org.ohjic.flower.exception.common.CommonException;
import org.ohjic.flower.exception.common.ResponseCode;

public class InvalidPageNumberException extends CommonException {

	private static final long serialVersionUID = 3029039949918532789L;

	public InvalidPageNumberException() {
		super(ResponseCode.INVALID_PAGE_NUMBER);
	}
}
