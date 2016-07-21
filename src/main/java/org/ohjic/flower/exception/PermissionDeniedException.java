package org.ohjic.flower.exception;

import org.ohjic.flower.exception.common.CommonException;
import org.ohjic.flower.exception.common.ResponseCode;

/**
 * 권한이 없을 경우 예외처리
 * @author ohjic
 *
 */
public class PermissionDeniedException extends CommonException {
	
	private static final long serialVersionUID = 1L;

	public PermissionDeniedException() {
		super(ResponseCode.PERMISSION_DENIED);
	}
}
