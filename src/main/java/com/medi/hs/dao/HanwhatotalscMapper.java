package com.medi.hs.dao;

import com.medi.hs.model.Hanwhatotalsc;

public interface HanwhatotalscMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table MOBILE.HANWHATOTALSC
     *
     * @mbg.generated Wed Aug 08 21:22:13 KST 2018
     */
    int deleteByPrimaryKey(Short id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table MOBILE.HANWHATOTALSC
     *
     * @mbg.generated Wed Aug 08 21:22:13 KST 2018
     */
    int insert(Hanwhatotalsc record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table MOBILE.HANWHATOTALSC
     *
     * @mbg.generated Wed Aug 08 21:22:13 KST 2018
     */
    int insertSelective(Hanwhatotalsc record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table MOBILE.HANWHATOTALSC
     *
     * @mbg.generated Wed Aug 08 21:22:13 KST 2018
     */
    Hanwhatotalsc selectByPrimaryKey(Short id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table MOBILE.HANWHATOTALSC
     *
     * @mbg.generated Wed Aug 08 21:22:13 KST 2018
     */
    int updateByPrimaryKeySelective(Hanwhatotalsc record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table MOBILE.HANWHATOTALSC
     *
     * @mbg.generated Wed Aug 08 21:22:13 KST 2018
     */
    int updateByPrimaryKey(Hanwhatotalsc record);
}