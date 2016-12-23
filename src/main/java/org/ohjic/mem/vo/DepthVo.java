package org.ohjic.mem.vo;

import org.ohjic.mem.model.Kyo;

public class DepthVo extends Kyo {

	private Integer year;
	private Integer nextYear;
	private Integer depth;
	private Integer depth1;
	private Integer depth2;
	private Integer depth3;
	private Integer depth4;
	private Integer depth5;
	
	public Integer getDepth() {
		return depth;
	}
	public void setDepth(Integer depth) {
		this.depth = depth;
	}
	public Integer getDepth1() {
		return depth1;
	}
	public void setDepth1(Integer depth1) {
		this.depth1 = depth1;
	}
	public Integer getDepth2() {
		return depth2;
	}
	public void setDepth2(Integer depth2) {
		this.depth2 = depth2;
	}
	public Integer getDepth3() {
		return depth3;
	}
	public void setDepth3(Integer depth3) {
		this.depth3 = depth3;
	}
	public Integer getDepth4() {
		return depth4;
	}
	public void setDepth4(Integer depth4) {
		this.depth4 = depth4;
	}
	public Integer getDepth5() {
		return depth5;
	}
	public void setDepth5(Integer depth5) {
		this.depth5 = depth5;
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	public Integer getNextYear() {
		this.nextYear = year+1;
		return nextYear;
	}
	public void setNextYear(Integer nextYear) {
		this.nextYear = nextYear;
	}
	
	
}
