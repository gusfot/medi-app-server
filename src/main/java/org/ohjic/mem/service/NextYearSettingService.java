package org.ohjic.mem.service;

import java.sql.SQLSyntaxErrorException;
import java.util.List;

import org.ohjic.mem.model.Churchinfo;
import org.ohjic.mem.vo.NextYearSettingStatusVo;
import org.springframework.jdbc.BadSqlGrammarException;

public interface NextYearSettingService {

	/**
	 * 다음 해의 kGroup의 를 기준연도 kGroupr의 kPart와 동일하게 생성한다.
	 * kGroup 활동기간은 다음해의 1월 1일부터 12월 31일까지이다. 
	 * @param churchCode
	 * @param standardYear
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	Object createNextYearKGroup(int churchCode, int standardYear, String startDate, String endDate, String standardDate);
	
	/**
	 * 다음 해의 kGroup의 kPart를 기준연도 kGroupr의 kPart와 동일하게 생성한다.
	 * kGroup 활동기간은 다음해의 1월 1일부터 12월 31일까지이다. 
	 * @param churchCode
	 * @param standardYear
	 * @param kPartIdx
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	Object createNextYearKGroup(int churchCode, int standardYear, String startDate, String endDate, String standardDate, int kPartIdx);
	
	/**
	 * 다음 해의 kGroup의 kPart를 기준연도 kGroupr의 kPart와 동일하게 생성한다.
	 * kGroup 활동기간은 다음해의 1월 1일부터 12월 31일까지이다. 
	 * @param churchCode
	 * @param standardYear
	 * @param startDate
	 * @param endDate
	 * @param kPartIdxList
	 * @return
	 * @throws Exception 
	 */
	Object createNextYearKGroup(int churchCode, int standardYear, String standardDate, String startDate, String endDate, List<Integer> kPartIdxList) throws Exception;

	/**
	 * 다음 해의 kGroupLog kPartIdx를 기준연도 kGroupLog kPartIdx와 동일하게 생성한다.
	 * kGroupLog 활동기간은 다음해의 1월 1일부터 12월 31일까지이다.
	 * @param churchCode
	 * @param standardYear
	 * @param startDate
	 * @param endDate
	 * @param kPartIdx
	 * @return
	 */
	Object createNextYearKGroupLog(int churchCode, int standardYear, String standardDate, String startDate, String endDate);
	
	/**
	 * 다음 해의 kGroupLog kPartIdx를 기준연도 kGroupLog kPartIdx와 동일하게 생성한다.
	 * kGroupLog 활동기간은 다음해의 1월 1일부터 12월 31일까지이다.
	 * @param churchCode
	 * @param standardYear
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	Object createNextYearKGroupLog(int churchCode, int standardYear, String standardDate, String startDate, String endDate, int kPartIdx);
	
	/**
	 * 다음 해의 kGroupLog kPartIdx를 기준연도 kGroupLog kPartIdx와 동일하게 생성한다.
	 * kGroupLog 활동기간은 다음해의 1월 1일부터 12월 31일까지이다.
	 * @param churchCode
	 * @param standardYear
	 * @param startDate
	 * @param endDate
	 * @param kPartIdxList
	 * @return
	 * @throws Exception 
	 */
	Object createNextYearKGroupLog(int churchCode, int standardYear, String standardDate, String startDate, String endDate, List<Integer> kPartIdxList) throws Exception;

	/**
	 * 다음 해의 권한를 기준연도 권한과 동일하게 생성한다.
	 * @param churchCode
	 * @param standardYear
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	Object createNextYearAuth(int churchCode, int standardYear);

	/**
	 * 다음 해의 예배를 기준연도 예배와 동일하게 생성한다.
	 * @param churchCode
	 * @param standardYear
	 * @return
	 */
	Object createNextYearWorship(int churchCode, int standardYear);
	
	/**
	 * 해당연도의 kGroup을 reset한다.
	 * @param churchCode
	 * @param year
	 * @return
	 * @throws Exception 
	 */

	Object createNextYearAuth(int churchCode, int standardYear, String standardDate, List<Integer> kPartIdxList) throws Exception;

	Object createNextYearWorship(int churchCode, int standardYear, List<Integer> kPartIdxList) throws Exception;

	Object resetNextYearKGroup(int churchCode, int standardYear,List<Integer> kPartIdxList);

	Object resetNextYearKGroupLog(int churchCode, int standardYear, List<Integer> kPartIdxList);
	
	Object resetNextYearWorship(int churchCode, int standardYear, List<Integer> kPartIdxList);

	Object resetNextYearAuth(int churchCode, int standardYear, List<Integer> kPartIdxList);

	List<NextYearSettingStatusVo> getNextYearSettingStatus(int churchCode, int year) throws SQLSyntaxErrorException;

	Object createNextYearGroupInfo(int churchCode, int standardYear, List<Integer> kPartIdxList) throws Exception;

	Object resetNextYearGroupInfo(int churchCode, int standardYear, List<Integer> kPartIdxList);

	List<Churchinfo> getChurchInfoList();

	List<Integer> getKPartListByChurchCode(int churchCode);

	boolean resetNextYear(int churchCode, int standardYear, int userId, List<Integer> kPartIdxList);

	boolean createNextYear(int churchCode, int standardYear, String standardDate, String startDate, String endDate, int userId, List<Integer> kPartIdxList) throws BadSqlGrammarException, Exception;

}
