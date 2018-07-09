package com.medi.hs.dao;

import com.medi.hs.model.Member;
import java.math.BigDecimal;
import java.util.List;

public interface MemberMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table MEDI.MEMBER
	 * @mbg.generated  Thu Jul 05 09:10:01 KST 2018
	 */
	int deleteByPrimaryKey(BigDecimal memberSeq);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table MEDI.MEMBER
	 * @mbg.generated  Thu Jul 05 09:10:01 KST 2018
	 */
	int insert(Member record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table MEDI.MEMBER
	 * @mbg.generated  Thu Jul 05 09:10:01 KST 2018
	 */
	int insertSelective(Member record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table MEDI.MEMBER
	 * @mbg.generated  Thu Jul 05 09:10:01 KST 2018
	 */
	Member selectByPrimaryKey(BigDecimal memberSeq);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table MEDI.MEMBER
	 * @mbg.generated  Thu Jul 05 09:10:01 KST 2018
	 */
	int updateByPrimaryKeySelective(Member record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table MEDI.MEMBER
	 * @mbg.generated  Thu Jul 05 09:10:01 KST 2018
	 */
	int updateByPrimaryKey(Member record);

	Member selectByUserId(String userId);

	List<Member> selectMembers(Object object);

	Member selectById(String userId);
	
	int insertMember(Member member);
}