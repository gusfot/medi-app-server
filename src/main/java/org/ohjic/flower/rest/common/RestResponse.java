package org.ohjic.flower.rest.common;

/**
 * 공통 Restful JsonResponse 객체
 * @author ohjic
 *
 */
public class RestResponse {

	private boolean success;
	private Object data;
	private String message;
	private String code;
	
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	
}
