package org.ohjic.mem.vo;

public class NextYearSettingStatusVo {
	
	private Integer kPartIdx;
	private String kPartName;
	private String status;
	private int groupCount;
	
	public Integer getkPartIdx() {
		return kPartIdx;
	}
	public void setkPartIdx(Integer kPartIdx) {
		this.kPartIdx = kPartIdx;
	}
	public String getkPartName() {
		return kPartName;
	}
	public void setkPartName(String kPartName) {
		this.kPartName = kPartName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getGroupCount() {
		return groupCount;
	}
	public void setGroupCount(int groupCount) {
		this.groupCount = groupCount;
	}
	
}
