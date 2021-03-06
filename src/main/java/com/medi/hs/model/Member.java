package com.medi.hs.model;

import java.math.BigDecimal;
import java.util.Date;

public class Member {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column MEDI.MEMBER.MEMBER_SEQ
	 * @mbg.generated  Thu Jul 05 09:10:01 KST 2018
	 */
	private BigDecimal memberSeq;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column MEDI.MEMBER.ID
	 * @mbg.generated  Thu Jul 05 09:10:01 KST 2018
	 */
	private String id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column MEDI.MEMBER.PASSWD
	 * @mbg.generated  Thu Jul 05 09:10:01 KST 2018
	 */
	private String passwd;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column MEDI.MEMBER.EMAIL
	 * @mbg.generated  Thu Jul 05 09:10:01 KST 2018
	 */
	private String email;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column MEDI.MEMBER.BIRTHDAY
	 * @mbg.generated  Thu Jul 05 09:10:01 KST 2018
	 */
	private String birthday;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column MEDI.MEMBER.BIRTHDAY_SOLAR
	 * @mbg.generated  Thu Jul 05 09:10:01 KST 2018
	 */
	private String birthdaySolar;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column MEDI.MEMBER.IS_AUTHENTICATED
	 * @mbg.generated  Thu Jul 05 09:10:01 KST 2018
	 */
	private String isAuthenticated;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column MEDI.MEMBER.IS_DELETED
	 * @mbg.generated  Thu Jul 05 09:10:01 KST 2018
	 */
	private String isDeleted;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column MEDI.MEMBER.MOD_DATE
	 * @mbg.generated  Thu Jul 05 09:10:01 KST 2018
	 */
	private Date modDate;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column MEDI.MEMBER.REG_DATE
	 * @mbg.generated  Thu Jul 05 09:10:01 KST 2018
	 */
	private Date regDate;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column MEDI.MEMBER.NAME
	 * @mbg.generated  Thu Jul 05 09:10:01 KST 2018
	 */
	private String name;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column MEDI.MEMBER.CELL_PHONE
	 * @mbg.generated  Thu Jul 05 09:10:01 KST 2018
	 */
	private String cellPhone;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column MEDI.MEMBER.MEMBER_SEQ
	 * @return  the value of MEDI.MEMBER.MEMBER_SEQ
	 * @mbg.generated  Thu Jul 05 09:10:01 KST 2018
	 */
	public BigDecimal getMemberSeq() {
		return memberSeq;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column MEDI.MEMBER.MEMBER_SEQ
	 * @param memberSeq  the value for MEDI.MEMBER.MEMBER_SEQ
	 * @mbg.generated  Thu Jul 05 09:10:01 KST 2018
	 */
	public void setMemberSeq(BigDecimal memberSeq) {
		this.memberSeq = memberSeq;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column MEDI.MEMBER.ID
	 * @return  the value of MEDI.MEMBER.ID
	 * @mbg.generated  Thu Jul 05 09:10:01 KST 2018
	 */
	public String getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column MEDI.MEMBER.ID
	 * @param id  the value for MEDI.MEMBER.ID
	 * @mbg.generated  Thu Jul 05 09:10:01 KST 2018
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column MEDI.MEMBER.PASSWD
	 * @return  the value of MEDI.MEMBER.PASSWD
	 * @mbg.generated  Thu Jul 05 09:10:01 KST 2018
	 */
	public String getPasswd() {
		return passwd;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column MEDI.MEMBER.PASSWD
	 * @param passwd  the value for MEDI.MEMBER.PASSWD
	 * @mbg.generated  Thu Jul 05 09:10:01 KST 2018
	 */
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column MEDI.MEMBER.EMAIL
	 * @return  the value of MEDI.MEMBER.EMAIL
	 * @mbg.generated  Thu Jul 05 09:10:01 KST 2018
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column MEDI.MEMBER.EMAIL
	 * @param email  the value for MEDI.MEMBER.EMAIL
	 * @mbg.generated  Thu Jul 05 09:10:01 KST 2018
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column MEDI.MEMBER.BIRTHDAY
	 * @return  the value of MEDI.MEMBER.BIRTHDAY
	 * @mbg.generated  Thu Jul 05 09:10:01 KST 2018
	 */
	public String getBirthday() {
		return birthday;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column MEDI.MEMBER.BIRTHDAY
	 * @param birthday  the value for MEDI.MEMBER.BIRTHDAY
	 * @mbg.generated  Thu Jul 05 09:10:01 KST 2018
	 */
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column MEDI.MEMBER.BIRTHDAY_SOLAR
	 * @return  the value of MEDI.MEMBER.BIRTHDAY_SOLAR
	 * @mbg.generated  Thu Jul 05 09:10:01 KST 2018
	 */
	public String getBirthdaySolar() {
		return birthdaySolar;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column MEDI.MEMBER.BIRTHDAY_SOLAR
	 * @param birthdaySolar  the value for MEDI.MEMBER.BIRTHDAY_SOLAR
	 * @mbg.generated  Thu Jul 05 09:10:01 KST 2018
	 */
	public void setBirthdaySolar(String birthdaySolar) {
		this.birthdaySolar = birthdaySolar;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column MEDI.MEMBER.IS_AUTHENTICATED
	 * @return  the value of MEDI.MEMBER.IS_AUTHENTICATED
	 * @mbg.generated  Thu Jul 05 09:10:01 KST 2018
	 */
	public String getIsAuthenticated() {
		return isAuthenticated;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column MEDI.MEMBER.IS_AUTHENTICATED
	 * @param isAuthenticated  the value for MEDI.MEMBER.IS_AUTHENTICATED
	 * @mbg.generated  Thu Jul 05 09:10:01 KST 2018
	 */
	public void setIsAuthenticated(String isAuthenticated) {
		this.isAuthenticated = isAuthenticated;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column MEDI.MEMBER.IS_DELETED
	 * @return  the value of MEDI.MEMBER.IS_DELETED
	 * @mbg.generated  Thu Jul 05 09:10:01 KST 2018
	 */
	public String getIsDeleted() {
		return isDeleted;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column MEDI.MEMBER.IS_DELETED
	 * @param isDeleted  the value for MEDI.MEMBER.IS_DELETED
	 * @mbg.generated  Thu Jul 05 09:10:01 KST 2018
	 */
	public void setIsDeleted(String isDeleted) {
		this.isDeleted = isDeleted;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column MEDI.MEMBER.MOD_DATE
	 * @return  the value of MEDI.MEMBER.MOD_DATE
	 * @mbg.generated  Thu Jul 05 09:10:01 KST 2018
	 */
	public Date getModDate() {
		return modDate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column MEDI.MEMBER.MOD_DATE
	 * @param modDate  the value for MEDI.MEMBER.MOD_DATE
	 * @mbg.generated  Thu Jul 05 09:10:01 KST 2018
	 */
	public void setModDate(Date modDate) {
		this.modDate = modDate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column MEDI.MEMBER.REG_DATE
	 * @return  the value of MEDI.MEMBER.REG_DATE
	 * @mbg.generated  Thu Jul 05 09:10:01 KST 2018
	 */
	public Date getRegDate() {
		return regDate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column MEDI.MEMBER.REG_DATE
	 * @param regDate  the value for MEDI.MEMBER.REG_DATE
	 * @mbg.generated  Thu Jul 05 09:10:01 KST 2018
	 */
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column MEDI.MEMBER.NAME
	 * @return  the value of MEDI.MEMBER.NAME
	 * @mbg.generated  Thu Jul 05 09:10:01 KST 2018
	 */
	public String getName() {
		return name;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column MEDI.MEMBER.NAME
	 * @param name  the value for MEDI.MEMBER.NAME
	 * @mbg.generated  Thu Jul 05 09:10:01 KST 2018
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column MEDI.MEMBER.CELL_PHONE
	 * @return  the value of MEDI.MEMBER.CELL_PHONE
	 * @mbg.generated  Thu Jul 05 09:10:01 KST 2018
	 */
	public String getCellPhone() {
		return cellPhone;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column MEDI.MEMBER.CELL_PHONE
	 * @param cellPhone  the value for MEDI.MEMBER.CELL_PHONE
	 * @mbg.generated  Thu Jul 05 09:10:01 KST 2018
	 */
	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}
}