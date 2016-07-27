package org.ohjic.flower.model;

public class NoteMessageSearch {
	private boolean isReceive;
	private Integer ownUserSeq;
	private String startDate;
	private String endDate;
	private String content;
	private String area;
	private String otherUserName;
	private Integer offset;
	private Integer countPerPage;
	
	public boolean isReceive() {
		return isReceive;
	}
	public void setReceive(boolean isReceive) {
		this.isReceive = isReceive;
	}
	public Integer getOwnUserSeq() {
		return ownUserSeq;
	}
	public void setOwnUserSeq(Integer ownUserSeq) {
		this.ownUserSeq = ownUserSeq;
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getOtherUserName() {
		return otherUserName;
	}
	public void setOtherUserName(String otherUserName) {
		this.otherUserName = otherUserName;
	}
	public Integer getOffset() {
		return offset;
	}
	public void setOffset(Integer offset) {
		this.offset = offset;
	}
	public Integer getCountPerPage() {
		return countPerPage;
	}
	public void setCountPerPage(Integer countPerPage) {
		this.countPerPage = countPerPage;
	}
}