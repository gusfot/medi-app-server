package org.ohjic.mem.model;

public class MemberWithBLOBs extends Member {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column member.car_memo
	 * @mbggenerated  Tue Aug 09 13:52:35 KST 2016
	 */
	private String carMemo;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column member.etc
	 * @mbggenerated  Tue Aug 09 13:52:35 KST 2016
	 */
	private String etc;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column member.etc_secure
	 * @mbggenerated  Tue Aug 09 13:52:35 KST 2016
	 */
	private String etcSecure;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column member.car_memo
	 * @return  the value of member.car_memo
	 * @mbggenerated  Tue Aug 09 13:52:35 KST 2016
	 */
	public String getCarMemo() {
		return carMemo;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column member.car_memo
	 * @param carMemo  the value for member.car_memo
	 * @mbggenerated  Tue Aug 09 13:52:35 KST 2016
	 */
	public void setCarMemo(String carMemo) {
		this.carMemo = carMemo;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column member.etc
	 * @return  the value of member.etc
	 * @mbggenerated  Tue Aug 09 13:52:35 KST 2016
	 */
	public String getEtc() {
		return etc;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column member.etc
	 * @param etc  the value for member.etc
	 * @mbggenerated  Tue Aug 09 13:52:35 KST 2016
	 */
	public void setEtc(String etc) {
		this.etc = etc;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column member.etc_secure
	 * @return  the value of member.etc_secure
	 * @mbggenerated  Tue Aug 09 13:52:35 KST 2016
	 */
	public String getEtcSecure() {
		return etcSecure;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column member.etc_secure
	 * @param etcSecure  the value for member.etc_secure
	 * @mbggenerated  Tue Aug 09 13:52:35 KST 2016
	 */
	public void setEtcSecure(String etcSecure) {
		this.etcSecure = etcSecure;
	}
}