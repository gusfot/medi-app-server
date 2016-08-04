package org.ohjic.flower.exception;

import org.ohjic.flower.exception.common.CommonException;
import org.ohjic.flower.exception.common.ResponseCode;

public class NotAcceptedContentTypeException extends CommonException {
	public NotAcceptedContentTypeException() {
		super(ResponseCode.FILE_CONTENTTYPE);
	}
}
