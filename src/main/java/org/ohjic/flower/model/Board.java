package org.ohjic.flower.model;

import java.util.Date;

public class Board {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column board.board_seq
	 * @mbggenerated  Tue Jul 26 11:22:01 KST 2016
	 */
	private Integer boardSeq;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column board.title
	 * @mbggenerated  Tue Jul 26 11:22:01 KST 2016
	 */
	private String title;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column board.writer
	 * @mbggenerated  Tue Jul 26 11:22:01 KST 2016
	 */
	private String writer;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column board.reg_time
	 * @mbggenerated  Tue Jul 26 11:22:01 KST 2016
	 */
	private Date regTime;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column board.content
	 * @mbggenerated  Tue Jul 26 11:22:01 KST 2016
	 */
	private String content;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column board.board_seq
	 * @return  the value of board.board_seq
	 * @mbggenerated  Tue Jul 26 11:22:01 KST 2016
	 */
	public Integer getBoardSeq() {
		return boardSeq;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column board.board_seq
	 * @param boardSeq  the value for board.board_seq
	 * @mbggenerated  Tue Jul 26 11:22:01 KST 2016
	 */
	public void setBoardSeq(Integer boardSeq) {
		this.boardSeq = boardSeq;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column board.title
	 * @return  the value of board.title
	 * @mbggenerated  Tue Jul 26 11:22:01 KST 2016
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column board.title
	 * @param title  the value for board.title
	 * @mbggenerated  Tue Jul 26 11:22:01 KST 2016
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column board.writer
	 * @return  the value of board.writer
	 * @mbggenerated  Tue Jul 26 11:22:01 KST 2016
	 */
	public String getWriter() {
		return writer;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column board.writer
	 * @param writer  the value for board.writer
	 * @mbggenerated  Tue Jul 26 11:22:01 KST 2016
	 */
	public void setWriter(String writer) {
		this.writer = writer;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column board.reg_time
	 * @return  the value of board.reg_time
	 * @mbggenerated  Tue Jul 26 11:22:01 KST 2016
	 */
	public Date getRegTime() {
		return regTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column board.reg_time
	 * @param regTime  the value for board.reg_time
	 * @mbggenerated  Tue Jul 26 11:22:01 KST 2016
	 */
	public void setRegTime(Date regTime) {
		this.regTime = regTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column board.content
	 * @return  the value of board.content
	 * @mbggenerated  Tue Jul 26 11:22:01 KST 2016
	 */
	public String getContent() {
		return content;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column board.content
	 * @param content  the value for board.content
	 * @mbggenerated  Tue Jul 26 11:22:01 KST 2016
	 */
	public void setContent(String content) {
		this.content = content;
	}

}