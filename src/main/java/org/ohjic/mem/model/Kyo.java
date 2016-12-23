package org.ohjic.mem.model;

public class Kyo {

	private Integer churchCode;
	
	private String church;

	public Integer getChurchCode() {
		return churchCode;
	}

	public void setChurchCode(Integer churchCode) {
		this.churchCode = churchCode;
	}

	public String getChurch() {
		this.church="kyo"+churchCode;
		return church;
	}

	public void setChurch(String church) {
		this.church = church;
	}
}
