package org.ohjic.mem.dao;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.ohjic.mem.model.Kgroup;
import org.ohjic.mem.model.KgroupKey;
import org.ohjic.mem.vo.DepthVo;
import org.ohjic.mem.vo.YearVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
								 "file:src/main/webapp/WEB-INF/spring/appServlet/dao-context_dev.xml"})
public class KgroupMapperTest {

	@Autowired
	private KgroupMapper kgroupMapper;
	
	@Test
	public void testSelectByPrimaryKey() {
		Integer churchCode = 6;
		
		KgroupKey key = new KgroupKey();
		key.setChurchCode(churchCode);
		key.setNo(1899);
		key.setYear(2016);
		
		Kgroup group = kgroupMapper.selectByPrimaryKey(key );
		
		assertTrue(group!=null);

	}
	
	@Test
	public void testSelectKgroupByYear() {
		Integer churchCode = 6;
		
		Kgroup group = new Kgroup();
		group.setChurchCode(churchCode);
		group.setYear(2016);
		
		List<Kgroup> groupList = kgroupMapper.selectKgroupByYear(group);
		
		assertTrue(groupList!=null);

	}
	
	/**
	 * 생성되는 그룹 활동기간은 해당연도의 1월1일~12월31일 로 세팅한다.
	 */
	@Test
	public void testInsertNextYearKgroupByYear() {
		
		Integer churchCode = 6;
		Integer year = 2016;
		
		YearVo yearVo = new YearVo();
		yearVo.setChurchCode(churchCode);
		yearVo.setYear(year);
		int result = kgroupMapper.insertNextYearKgroupByYear(yearVo);
		
		assertTrue(result>0);

	}
	
	/**
	 * depth1, depth2, depth3, depth4, depth5를 재설정한다.
	 */
	@Test
	public void testUpdateDepth() {
		
		Integer churchCode = 6;
		Integer year = 2016;
		
		
		for (int i = 1; i < 6; i++) {
			DepthVo depthVo = new DepthVo();
			depthVo.setChurchCode(churchCode);
			depthVo.setYear(year);
			depthVo.setDepth(i );
			int result = kgroupMapper.updateNextYearKgroupDepthByYear(depthVo);
			assertTrue(result>0);
			
		}
	}
	
	@Test
	public void testKgroupMapper() {
		
		Integer churchCode = 6;
		Integer year = 2016;
		Integer kPartIdx = 1;
		
		YearVo yearVo = new YearVo();
		yearVo.setChurchCode(churchCode);
		yearVo.setYear(year);
		yearVo.setkPartIdx(kPartIdx);
		kgroupMapper.deleteNextYearKgroup(yearVo);
	}
}
