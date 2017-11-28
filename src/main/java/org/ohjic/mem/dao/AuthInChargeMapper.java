package org.ohjic.mem.dao;

import org.ohjic.mem.model.AuthInCharge;
import org.ohjic.mem.vo.YearVo;

public interface AuthInChargeMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table auth_in_charge
	 * @mbg.generated  Thu Nov 02 16:17:48 KST 2017
	 */
	int deleteByPrimaryKey(Integer authInChargeIdx);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table auth_in_charge
	 * @mbg.generated  Thu Nov 02 16:17:48 KST 2017
	 */
	int insert(AuthInCharge record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table auth_in_charge
	 * @mbg.generated  Thu Nov 02 16:17:48 KST 2017
	 */
	int insertSelective(AuthInCharge record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table auth_in_charge
	 * @mbg.generated  Thu Nov 02 16:17:48 KST 2017
	 */
	AuthInCharge selectByPrimaryKey(Integer authInChargeIdx);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table auth_in_charge
	 * @mbg.generated  Thu Nov 02 16:17:48 KST 2017
	 */
	int updateByPrimaryKeySelective(AuthInCharge record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table auth_in_charge
	 * @mbg.generated  Thu Nov 02 16:17:48 KST 2017
	 */
	int updateByPrimaryKey(AuthInCharge record);

	int insertAuthInChargeForNextYear(YearVo yearVo);

	int deleteNextYearAuthInCharge(YearVo yearVo);
	
	int deleteNextYearAuthInChargeDefault(YearVo yearVo);
}