package org.ohjic.mem.dao;

import java.util.List;

import org.ohjic.mem.model.Historypgrade;
import org.ohjic.mem.model.Kyo;

public interface HistorypgradeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table historyPgrade
     *
     * @mbg.generated Fri Dec 15 15:31:43 KST 2017
     */
    int deleteByPrimaryKey(Integer historyIdx);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table historyPgrade
     *
     * @mbg.generated Fri Dec 15 15:31:43 KST 2017
     */
    int insert(Historypgrade record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table historyPgrade
     *
     * @mbg.generated Fri Dec 15 15:31:43 KST 2017
     */
    int insertSelective(Historypgrade record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table historyPgrade
     *
     * @mbg.generated Fri Dec 15 15:31:43 KST 2017
     */
    Historypgrade selectByPrimaryKey(Integer historyIdx);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table historyPgrade
     *
     * @mbg.generated Fri Dec 15 15:31:43 KST 2017
     */
    int updateByPrimaryKeySelective(Historypgrade record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table historyPgrade
     *
     * @mbg.generated Fri Dec 15 15:31:43 KST 2017
     */
    int updateByPrimaryKey(Historypgrade record);

	List<Historypgrade> selectHistoryPgradeListByTid(Kyo kyo);
}