package com.medi.hs.dao;

import com.medi.hs.model.TbUser;

public interface TbUserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table MOBILE.TB_USER
     *
     * @mbg.generated Wed Aug 08 21:30:02 KST 2018
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table MOBILE.TB_USER
     *
     * @mbg.generated Wed Aug 08 21:30:02 KST 2018
     */
    int insert(TbUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table MOBILE.TB_USER
     *
     * @mbg.generated Wed Aug 08 21:30:02 KST 2018
     */
    int insertSelective(TbUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table MOBILE.TB_USER
     *
     * @mbg.generated Wed Aug 08 21:30:02 KST 2018
     */
    TbUser selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table MOBILE.TB_USER
     *
     * @mbg.generated Wed Aug 08 21:30:02 KST 2018
     */
    int updateByPrimaryKeySelective(TbUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table MOBILE.TB_USER
     *
     * @mbg.generated Wed Aug 08 21:30:02 KST 2018
     */
    int updateByPrimaryKey(TbUser record);
}