package org.ohjic.mem.model;

public class Kyo {

	private Integer churchCode;
	
	private String church;

	public Kyo() { }
	
	public Kyo(Integer churchCode) {
		this.churchCode = churchCode;
	}

	public Integer getChurchCode() {
		return churchCode;
	}

	public void setChurchCode(Integer churchCode) {
		this.churchCode = churchCode;
	}

	public String getChurch() {
		this.church= churchCode !=null ? "kyo"+churchCode:"";
		return church;
	}

	public void setChurch(String church) {
		this.church = church;
	}
}
