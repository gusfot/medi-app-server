package org.ohjic.mem.dao;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.ohjic.mem.vo.YearVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
								 "file:src/main/webapp/WEB-INF/spring/appServlet/dao-context_dev.xml"})
public class KPartMapperTest {

	@Autowired
	private KPartMapper kPartMapper;
	
	@Test
	public void testSelectByPrimaryKey() {
		Integer churchCode = 6;
		
		YearVo yearVo = new YearVo();
		yearVo.setChurchCode(churchCode);
		List<Integer> kPartList = kPartMapper.selectActiveKPartList(yearVo);
		
		for (Integer kPart : kPartList) {
			System.out.println(kPart);
		}
		assertTrue(kPartList.size()==7);

	}
	
}
