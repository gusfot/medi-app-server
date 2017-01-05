package org.ohjic.mem.vo;

public class NextYearSettingStatusVo {
	
	private Integer kPartIdx;
	private String kPartName;
	private String status;
	private int groupCount;
	private int oldGroupCount;
	private int oldAuthSetCount;
	private int authSetCount;
	
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
	public int getAuthSetCount() {
		return authSetCount;
	}
	public void setAuthSetCount(int authSetCount) {
		this.authSetCount = authSetCount;
	}
	public int getOldAuthSetCount() {
		return oldAuthSetCount;
	}
	public void setOldAuthSetCount(int oldAuthSetCount) {
		this.oldAuthSetCount = oldAuthSetCount;
	}
	public int getOldGroupCount() {
		return oldGroupCount;
	}
	public void setOldGroupCount(int oldGroupCount) {
		this.oldGroupCount = oldGroupCount;
	}
	
}
