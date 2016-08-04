package org.ohjic.flower.model;

import java.util.Date;

public class Board {

	private String title;
	
	private int boardSeq;
	
	private String content;
	
	private String writer;
	
	private Date regTime;

	public int getBoardSeq() {
		return boardSeq;
	}

	public void setBoardSeq(int boardSeq) {
		this.boardSeq = boardSeq;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public Date getRegTime() {
		return regTime;
	}

	public void setRegTime(Date regTime) {
		this.regTime = regTime;
	}

}
