package org.ohjic.flower.exception;

import org.ohjic.flower.exception.common.CommonException;
import org.ohjic.flower.exception.common.ResponseCode;

public class UnserviceableTextMessageException extends CommonException {

	private static final long serialVersionUID = 6778507052295374032L;

	public UnserviceableTextMessageException() {
		super(ResponseCode.UNSERVICEABLE_TEXT_MESSAGE);
	}
}
