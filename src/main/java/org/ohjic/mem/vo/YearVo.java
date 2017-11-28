package org.ohjic.mem.vo;

import org.ohjic.mem.model.Kyo;

public class YearVo extends Kyo {
	
	private Integer year;
	
	private Integer nextYear;
	
	private Integer kPartIdx;

	private String standardDate;

	private String startDate;
	
	private String endDate;
	
	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getNextYear() {
		this.nextYear=year+1;
		return nextYear;
	}

	public void setNextYear(Integer nextYear) {
		this.nextYear = nextYear;
	}

	public Integer getkPartIdx() {
		return kPartIdx;
	}

	public void setkPartIdx(Integer kPartIdx) {
		this.kPartIdx = kPartIdx;
	}

	public String getStandardDate() {
		return standardDate;
	}

	public void setStandardDate(String standardDate) {
		this.standardDate = standardDate;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
}
