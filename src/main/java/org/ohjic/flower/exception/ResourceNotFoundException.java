package org.ohjic.flower.exception;

import org.ohjic.flower.exception.common.CommonException;
import org.ohjic.flower.exception.common.ResponseCode;

public class ResourceNotFoundException extends CommonException {

	private static final long serialVersionUID = 3278541028578316501L;

	public ResourceNotFoundException() {
		super(ResponseCode.RESOURCE_NOT_FOUND);
	}

}
