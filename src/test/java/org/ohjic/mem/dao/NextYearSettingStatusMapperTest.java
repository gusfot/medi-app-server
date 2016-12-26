package org.ohjic.mem.dao;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.ohjic.mem.model.NextYearSettingStatus;
import org.ohjic.mem.vo.NextYearSettingStatusVo;
import org.ohjic.mem.vo.YearVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
								 "file:src/main/webapp/WEB-INF/spring/appServlet/dao-context_dev.xml"})
public class NextYearSettingStatusMapperTest {

	@Autowired
	private NextYearSettingStatusMapper nextYearSettingStatusMapper;
	
	@Test
	public void testInsertNextYearSettingStatus() {
		Integer churchCode = 6;
		Integer year =2016;
		
		NextYearSettingStatus record = new NextYearSettingStatus();
		record.setChurchCode(churchCode);
		record.setkPartIdx(1);
		record.setManagerIdx(1);
		record.setYear(year);
		record.setStatus("Y");
		
		int result = nextYearSettingStatusMapper.insertNextYearSettingStatus(record);
		
		assertTrue(result==2);

	}
	
	@Test
	public void testSelectNextYearSettingStatusByChurchCode() {
		
		Integer churchCode = 6;
		Integer year =2016;
		Integer kPartIdx = 1;
		
		YearVo yearVo = new YearVo();
		yearVo.setChurchCode(churchCode);
		yearVo.setkPartIdx(kPartIdx);
		yearVo.setYear(year);
		List<NextYearSettingStatusVo> resultList = nextYearSettingStatusMapper.selectNextYearSettingStatusByChurchCode(yearVo );
		
		System.out.println(resultList.size());
		
		assertTrue(resultList.size()==1);

	}
}
