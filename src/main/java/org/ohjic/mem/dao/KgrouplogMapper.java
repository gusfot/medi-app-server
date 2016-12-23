package org.ohjic.mem.dao;

import java.util.List;
import java.util.Map;

import org.ohjic.mem.model.Kgroup;
import org.ohjic.mem.model.Kgrouplog;
import org.ohjic.mem.vo.DepthVo;
import org.ohjic.mem.vo.YearVo;

public interface KgrouplogMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kGroupLog
     *
     * @mbggenerated Wed Aug 31 22:00:43 KST 2016
     */
    int deleteByPrimaryKey(Integer no);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kGroupLog
     *
     * @mbggenerated Wed Aug 31 22:00:43 KST 2016
     */
    int insert(Kgrouplog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kGroupLog
     *
     * @mbggenerated Wed Aug 31 22:00:43 KST 2016
     */
    int insertSelective(Kgrouplog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kGroupLog
     *
     * @mbggenerated Wed Aug 31 22:00:43 KST 2016
     */
    Kgrouplog selectByPrimaryKey(Integer no);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kGroupLog
     *
     * @mbggenerated Wed Aug 31 22:00:43 KST 2016
     */
    int updateByPrimaryKeySelective(Kgrouplog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kGroupLog
     *
     * @mbggenerated Wed Aug 31 22:00:43 KST 2016
     */
    int updateByPrimaryKey(Kgrouplog record);

    List<Kgrouplog> selectKGroupLogByGrouNOAndMinYear(Map<String, Object> params);

	int insertSelectiveKgroupLog(Kgrouplog kGroupLog);

	List<Kgrouplog> selectKgrouplogByYear(Kgroup group);

	int insertNextYearKgrouplogByYear(YearVo yearVo);

	int updateNextYearKgrouplogDepthByYear(DepthVo depthVo);
}