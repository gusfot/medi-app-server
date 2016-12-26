package org.ohjic.mem.dao;

import org.ohjic.mem.model.AuthSet;
import org.ohjic.mem.vo.YearVo;

public interface AuthSetMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table auth_set
	 * @mbg.generated  Wed Dec 21 18:33:33 KST 2016
	 */
	int deleteByPrimaryKey(Integer authSetIdx);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table auth_set
	 * @mbg.generated  Wed Dec 21 18:33:33 KST 2016
	 */
	int insert(AuthSet record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table auth_set
	 * @mbg.generated  Wed Dec 21 18:33:33 KST 2016
	 */
	int insertSelective(AuthSet record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table auth_set
	 * @mbg.generated  Wed Dec 21 18:33:33 KST 2016
	 */
	AuthSet selectByPrimaryKey(Integer authSetIdx);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table auth_set
	 * @mbg.generated  Wed Dec 21 18:33:33 KST 2016
	 */
	int updateByPrimaryKeySelective(AuthSet record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table auth_set
	 * @mbg.generated  Wed Dec 21 18:33:33 KST 2016
	 */
	int updateByPrimaryKey(AuthSet record);

	int insertAuthSetForGroup(YearVo yearVo);
	
	int insertAuthSetForDefault(YearVo yearVo);

	int deleteNextYearAuthSet(YearVo yearVo);
}