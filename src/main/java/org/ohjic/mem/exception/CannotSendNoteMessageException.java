package org.ohjic.mem.exception;

import org.ohjic.mem.exception.common.CommonException;
import org.ohjic.mem.vo.ResponseCode;

public class CannotSendNoteMessageException extends CommonException {

	private static final long serialVersionUID = 2435430374014992939L;

	public CannotSendNoteMessageException() {
		super(ResponseCode.CANNOT_SEND_NOTE_MESSAGE);
	}

}
