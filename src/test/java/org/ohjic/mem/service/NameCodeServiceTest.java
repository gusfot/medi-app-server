package org.ohjic.mem.service;

import static org.junit.Assert.assertTrue;

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
import org.ohjic.mem.model.Namecode;
import org.ohjic.mem.vo.NextYearSettingStatusVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.google.gson.Gson;


@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
								 "file:src/main/webapp/WEB-INF/spring/appServlet/dao-context_local.xml"})
public class NameCodeServiceTest {

	private static final Logger logger = LoggerFactory.getLogger(NameCodeServiceTest.class);
	
	@Autowired
	private NameCodeService nameCodeService;
	
	@Test
	public void testGetCodeList() {

		int churchCode = 2393;
		String type = "pGrade";
		List<Namecode> result = null;
		
		try {
			
			result = nameCodeService.getCodeList(churchCode, type);
		} catch (BadSqlGrammarException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertTrue(result.size()>0);
		
	}
	
}
