package org.ohjic.mem.dao;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.ohjic.mem.model.Namecode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
								 "file:src/main/webapp/WEB-INF/spring/appServlet/dao-context_local.xml"})
public class NamecodeMapperTest {

	@Autowired
	private NamecodeMapper namecodeMapper;
	
	@Test
	public void testSeleceCodeList() {
		
		Integer churchCode = 6;
		
		String type = "pGrade";
		String church = "kyo"+churchCode;
		List<Namecode> result = namecodeMapper.selectCodeList(church , type);
		
		for (Namecode namecode : result) {
			System.out.println(namecode.getName());
		}
		
		assertTrue(result.size()>0);

	}
	
	
}
