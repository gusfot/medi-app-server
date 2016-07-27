package org.ohjic.flower.exception;

import org.ohjic.flower.exception.common.CommonException;
import org.ohjic.flower.exception.common.ResponseCode;

public class CannotSendNoteMessageException extends CommonException {

	private static final long serialVersionUID = 2435430374014992939L;

	public CannotSendNoteMessageException() {
		super(ResponseCode.CANNOT_SEND_NOTE_MESSAGE);
	}

}
