package org.ohjic.mem.service;

import static org.junit.Assert.assertTrue;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.ohjic.mem.model.Churchinfo;
import org.ohjic.mem.model.InformationSchemaStatitics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.google.gson.Gson;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/dao-context_dev.xml" })
public class DbToolsServiceTest {

	@Autowired
	private DbToolsService dbtoolsService;

	@Autowired
	private NextYearSettingService nextYearSettingService;
	
	@Test
	public void testGetTableIndexListByScheme() {

		Integer churchCode= 6;
		List<InformationSchemaStatitics> list = dbtoolsService.getTableIndexListByScheme(churchCode);

	}
	
	@Test
	public void testGetTableIndexListBySchemeAndColumnAndIndex() {

		InformationSchemaStatitics record = new InformationSchemaStatitics();
		record.setChurchCode(6);
		record.setTableName("admin");
		record.setColumnName("no");
		record.setIndexName("PRIMARY");

		InformationSchemaStatitics result = dbtoolsService.getTableIndexListBySchemeByInformationSchemaStatitics(record);
		
		assertTrue(result !=null);

	}
	
	@Test
	public void testGetTableIndexListBySchemeAndColumnAndIndexForAll() {
		
		Integer refChurchCode= 6;
		List<InformationSchemaStatitics> informationSchemaStatiticsList = dbtoolsService.getTableIndexListByScheme(refChurchCode);
		List<Churchinfo> churchInfoList = nextYearSettingService.getChurchInfoList();
		List<Map<String, String>> resultList = new ArrayList<>();
		
		for (Churchinfo churchinfo : churchInfoList) {
			Integer churchCode = churchinfo.getChurchCode();
			
			try {
				InformationSchemaStatitics record = new InformationSchemaStatitics();
				record.setChurchCode(churchCode);
				
				for (InformationSchemaStatitics informationSchemaStatitics : informationSchemaStatiticsList) {
					
					record.setTableName(informationSchemaStatitics.getTableName());
					record.setColumnName(informationSchemaStatitics.getColumnName());
					record.setIndexName(informationSchemaStatitics.getIndexName());

					InformationSchemaStatitics result = dbtoolsService.getTableIndexListBySchemeByInformationSchemaStatitics(record);
					
					if(result!=null) {
						
					}else {
						Map<String, String> noIndexResult = new HashMap<>();
						noIndexResult.put("churchCode", churchCode+"");
						noIndexResult.put("TableName", informationSchemaStatitics.getTableName());
						noIndexResult.put("ColumnName", informationSchemaStatitics.getColumnName());
						noIndexResult.put("IndexName", informationSchemaStatitics.getIndexName());
						
						resultList.add(noIndexResult);
					}
				}
				
				
				
			} catch (Exception e) {

			}
			
			String fileName = "C:\\Users\\ohjic\\Documents\\ohjic_kyo_different_db_list.txt";
			toJsonFile(resultList, fileName);
		}
		

	}
//	
//	@Test
//	public void testCompareTableIndexListByScheme() {
//
//		Integer refChurchCode= 6;
//		List<Map<String, String>> resultList =new ArrayList<>();
//		
//		List<Map<String, String>> refList = dbtoolsService.getTableIndexListByScheme(refChurchCode);
//		
//		List<Churchinfo> churchInfoList = nextYearSettingService.getChurchInfoList();
//
//		for (Churchinfo churchinfo : churchInfoList) {
//			Integer churchCode = churchinfo.getChurchCode();
//			try {
//				List<Map<String, String>> list = dbtoolsService.getTableIndexListByScheme(churchCode);
//				
//				for (int i = 0; i < refList.size(); i++) {
//					if(!refList.get(i).equals(list.get(i))) {
//						System.out.println("churchCode: "+churchCode +", table: "+ refList.get(i));
//						Map<String, String> result = new HashMap<String, String>();
//						result.put("churchCode", String.valueOf(churchCode));
//						result.put("TABLE_NAME", refList.get(i).get("TABLE_NAME"));
//						result.put("INDEX_NAME", refList.get(i).get("INDEX_NAME"));
//						resultList.add(result);
//						
//					}
//				}
//			} catch (Exception e) {
//
//			}
//		}
//		
//		String fileName = "C:\\Users\\ohjic\\Documents\\ohjic_kyo_different_db_list.txt";
//		toJsonFile(resultList, fileName);
//	}
	
	private void toJsonFile(Object resultList, String fileName) {
		String resultJson = new Gson().toJson(resultList);

		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter(fileName));
			writer.write(resultJson);

		} catch (IOException e) {

		} finally {
			try {
				if (writer != null)
					writer.close();
			} catch (IOException e) {

			}
		}
	}
	


}
