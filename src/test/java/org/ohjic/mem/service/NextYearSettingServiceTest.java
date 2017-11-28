package org.ohjic.mem.service;

import static org.junit.Assert.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLSyntaxErrorException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.ohjic.mem.model.Churchinfo;
import org.ohjic.mem.vo.NextYearSettingStatusVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.google.gson.Gson;


@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
								 "file:src/main/webapp/WEB-INF/spring/appServlet/dao-context_dev.xml"})
public class NextYearSettingServiceTest {

	@Autowired
	private NextYearSettingService nextYearSettingService;
	
	@Test
	public void testCreateNextYear() {

		int churchCode = 6037;
		int standardYear = 2017;
		int managerIdx =0;
		String standardDate = "2017-11-01";
		String startDate = "2017-12-01";
		String endDate = "2018-11-30";
		
		List<Integer> kPartIdxList = new ArrayList<>();
		kPartIdxList.add(1);
		kPartIdxList.add(2);
		kPartIdxList.add(3);
		kPartIdxList.add(4);
		
		try {
			nextYearSettingService.createNextYear(churchCode, standardYear, standardDate, startDate, endDate, managerIdx, kPartIdxList);
		} catch (BadSqlGrammarException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testResetNextYear() {

		int churchCode = 6037;
		int standardYear = 2017;
		int managerIdx = 0;
		List<Integer> kPartIdxList = new ArrayList<>();
		kPartIdxList.add(1);
		kPartIdxList.add(2);
		kPartIdxList.add(3);
		kPartIdxList.add(4);
		
		nextYearSettingService.resetNextYear(churchCode, standardYear, managerIdx, kPartIdxList );
		
	}
	
	@Test
	public void testgetNextYearStatus() {

		int year = 2016;
		
		List<Churchinfo> churchInfoList = nextYearSettingService.getChurchInfoList();
		List<Object> objList = new ArrayList<>();
		
		for(Churchinfo churchInfo: churchInfoList) {
			int churchCode = churchInfo.getChurchCode();
			try{
				
				
				List<NextYearSettingStatusVo> voList = nextYearSettingService.getNextYearSettingStatus(churchCode, year);
				
				for(NextYearSettingStatusVo vo:voList) {
					if(vo.getOldAuthSetCount() >0 && vo.getAuthSetCount()==0) {
						Map<String, Object> church = new HashMap<>();
						church.put("churchCode", churchCode);
						church.put("kPartIdx", vo.getkPartIdx());
						objList.add(church);
					}
				}
				
			}catch(Exception e) {
				
			}
			
		}
		
		String sucessfileName = "C:\\Users\\ohjic\\Documents\\ohjic_authSetList.txt";
		toJsonFile(objList, sucessfileName );
		
	}
	
	@Test
	public void testCreateNextYearWithException() throws SQLSyntaxErrorException {

		int churchCode = 1;
		int standardYear = 2016;
		int managerIdx = 0;
		String standardDate = "2017-11-01";
		String startDate = "2017-12-01";
		String endDate = "2018-11-30";
		
		List<Integer> kPartIdxList = new ArrayList<>();
		kPartIdxList.add(1);
		kPartIdxList.add(5);
		
		try {
			nextYearSettingService.createNextYear(churchCode, standardYear, standardDate , startDate, endDate, managerIdx,  kPartIdxList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	@Test
	public void testGetChurchInfoList() {

		List<Churchinfo> churchInfolist = nextYearSettingService.getChurchInfoList();
		assertTrue(churchInfolist.size()==3944);
		
	}
	
	@Test 
	public void testCreateAuth() {
		
		int churchCode = 6037;// 351, 474, 2393, 476,5290,5932, 6245
		int standardYear=2017;
		String standardDate = "20171101";
		List<Integer> kPartIdxList = new ArrayList<>();
		kPartIdxList.add(1);
		kPartIdxList.add(2);
		kPartIdxList.add(3);
		kPartIdxList.add(4);
		try {
			nextYearSettingService.createNextYearAuth(churchCode, standardYear, standardDate, kPartIdxList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test 
	public void testResetAuth() {
		int churchCode = 6037; // 5932
		int standardYear=2017;
		List<Integer> kPartIdxList = new ArrayList<>();
		kPartIdxList.add(1);
//		kPartIdxList.add(2);
//		kPartIdxList.add(3);
//		kPartIdxList.add(4);
		nextYearSettingService.resetNextYearAuth(churchCode, standardYear, kPartIdxList);
	}
	
	@Test
	public void testCreateNextYearAllChurch() {

		System.out.println("====================================================================================================================================");
		System.out.println("CreateNextYearSettings started....");
		System.out.println("====================================================================================================================================");
		
		List<Integer> sucessResultList = new ArrayList<>();
		List<Integer> failResultList = new ArrayList<>();
		
		int standardYear = 2016;
		int managerIdx = 0;
		String standardDate = "2017-11-01";
		String startDate = "2017-12-01";
		String endDate = "2018-11-30";
		
		List<Churchinfo> churchInfoList = nextYearSettingService.getChurchInfoList();
		
		for (Churchinfo churchinfo : churchInfoList) {
			
			int churchCode = churchinfo.getChurchCode();
			
			if(churchCode!=6011) {	// 호산나교회예외처리
				try {
					
					boolean result = false;
					
					// 활성화된 k_part_idx 만 추출한다.
					List<Integer> kPartIdxList = getKpartIdxList(standardYear, churchCode);
					
					if(kPartIdxList.size()>0) {
						result = nextYearSettingService.createNextYear(churchCode, standardYear, standardDate, startDate, endDate, managerIdx, kPartIdxList );
					}
					
					if(result) {
						sucessResultList.add(churchCode);
					}else {
						failResultList.add(churchCode);
						
					}
				}catch (Exception e) {
					failResultList.add(churchCode);
					System.out.println(e.getMessage());
				}
			}
		}
		
		String sucessfileName = "C:\\Users\\ohjic\\Documents\\ohjic_2017_sucess.txt";
		String failfileName = "C:\\Users\\ohjic\\Documents\\ohjic_2017_fail.txt";
		toJsonFile(sucessResultList, sucessfileName );
		toJsonFile(failResultList, failfileName );
		
		System.out.println("====================================================================================================================================");
		System.out.println("CreateNextYearSettings finished....");
		System.out.println("====================================================================================================================================");
		
	}

	/**
	 * k_part에서 활성화된 k_part_idx만 추출하여 list 생성한다.
	 * @param standardYear
	 * @param churchCode
	 * @return
	 */
	private List<Integer> getKpartIdxList(int standardYear, int churchCode) {
		
		List<Integer> kPartIdxList = new ArrayList<>();
		
		List<NextYearSettingStatusVo> kPartList = nextYearSettingService.getNextYearSettingStatus(churchCode, standardYear);
		
		for (NextYearSettingStatusVo kPart : kPartList) {
			if("N".equals(kPart.getStatus()) && kPart.getGroupCount() > 0 ) {
				kPartIdxList.add(kPart.getkPartIdx());
			}
		}
		
		return kPartIdxList;
	}
	
	
	private void toJsonFile(Object resultList, String fileName) {
		String resultJson = new Gson().toJson(resultList);
		
		
		BufferedWriter writer = null;
		try {
		    writer = new BufferedWriter( new FileWriter( fileName));
		    writer.write( resultJson);

		} catch ( IOException e) {
			
		} finally {
		    try {
		        if ( writer != null)
		        writer.close( );
		    } catch ( IOException e) {
		    	
		    }
		}
	}
}
