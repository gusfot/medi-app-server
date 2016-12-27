package org.ohjic.mem.dao;

import org.ohjic.mem.model.GroupInfo;
import org.ohjic.mem.vo.YearVo;

public interface GroupInfoMapper {
    /**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table group_info
	 * @mbg.generated  Tue Dec 27 13:08:41 KST 2016
	 */
	int deleteByPrimaryKey(Integer infoIdx);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table group_info
	 * @mbg.generated  Tue Dec 27 13:08:41 KST 2016
	 */
	int insert(GroupInfo record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table group_info
	 * @mbg.generated  Tue Dec 27 13:08:41 KST 2016
	 */
	int insertSelective(GroupInfo record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table group_info
	 * @mbg.generated  Tue Dec 27 13:08:41 KST 2016
	 */
	GroupInfo selectByPrimaryKey(Integer infoIdx);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table group_info
	 * @mbg.generated  Tue Dec 27 13:08:41 KST 2016
	 */
	int updateByPrimaryKeySelective(GroupInfo record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table group_info
	 * @mbg.generated  Tue Dec 27 13:08:41 KST 2016
	 */
	int updateByPrimaryKey(GroupInfo record);

	int insertGroupInfoForNextYear(YearVo yearVo);

	int deleteNextYearGroupInfo(YearVo yearVo);
}