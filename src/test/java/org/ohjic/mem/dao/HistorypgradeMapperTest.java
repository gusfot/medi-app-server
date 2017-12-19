package org.ohjic.mem.dao;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.ohjic.mem.model.Historypgrade;
import org.ohjic.mem.vo.TidVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
								 "file:src/main/webapp/WEB-INF/spring/appServlet/dao-context_local.xml"})
public class HistorypgradeMapperTest {

	@Autowired
	private HistorypgradeMapper historypgradeMapper;
	
	@Test
	public void testSelectHistoryPgradeListByTid() {
		
		TidVo tid = new TidVo(3227);
		tid.setTid(1);
		List<Historypgrade> result = historypgradeMapper.selectHistoryPgradeListByTid(tid );
		System.out.println(result.get(0).getpGradeName() +":"+result.get(0).getpGradeDate());
		assertTrue(result!=null);

	}
	
	
}
