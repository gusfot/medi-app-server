package org.ohjic.flower.exception;

import org.ohjic.flower.exception.common.CommonException;
import org.ohjic.flower.exception.common.ResponseCode;

public class FileUploadException extends CommonException {
	public FileUploadException() {
		super(ResponseCode.FILEUPLOAD_FAIL);
	}
}
