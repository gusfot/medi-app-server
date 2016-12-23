package org.ohjic.mem.vo;

import org.ohjic.mem.model.Kyo;

public class YearVo extends Kyo {
	
	private Integer year;
	
	private Integer nextYear;
	
	private Integer kPartIdx;

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
}
