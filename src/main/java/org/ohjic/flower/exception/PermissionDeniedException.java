package org.ohjic.flower.exception;

import org.ohjic.flower.exception.common.CommonException;
import org.ohjic.flower.exception.common.ResponseCode;

public class PermissionDeniedException extends CommonException {
	public PermissionDeniedException() {
		super(ResponseCode.PERMISSION_DENIED);
	}
}
