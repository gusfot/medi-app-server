package org.ohjic.mem.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
								 "file:src/main/webapp/WEB-INF/spring/appServlet/dao-context_dev.xml"})
public class IChurchMigrationServiceTest {

	@Autowired
	@Qualifier("iChurchOldMigrationService")
	private MigrationService migrationService;
	
	/**
	 * 성도정보로 db에 있는 프로필사진 컬럼을 사진으로 변경한다.
	 */
	@Test
	public void testGetMemberList() {
		
		// 파일이 저장될 위치
		String destDirStr = "c:/hosanna/member_img";
		
		// 멤버리스트 조회
		List<Map<String, Object>> memberList = (List<Map<String, Object>>) migrationService.getMemberList();
		
		for (Map<String, Object> member : memberList) {
			
			byte[] fileBytes =   (byte[]) member.get("Photo");
			String filename =  String.valueOf(member.get("MemberID"));
			String fileType = "jpg";
			
			bytesToFile(destDirStr, fileBytes, filename, fileType);
			
		}
		
		assert(memberList.size() > 0);
	}

	private void bytesToFile(String destDirStr, byte[] fileBytes, String filename, String fileType) {
		try {
			
			File desDir = new File(destDirStr);
			
			if(!desDir.exists()) {
				desDir.mkdirs();
			}

			FileUtils.writeByteArrayToFile(new File(destDirStr + "/" + filename+"."+fileType), fileBytes);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGenerteKGroupLogByOriginalKGroupLog() {
		migrationService.generteKGroupLogByOriginalKGroupLog();
	}
	
	@Test
	public void testGetExistMemberImage() {
		
//		String path = "C:/Users/ohjic/Documents/member_img";
		String path = "c:/hosanna/member_img";
		File imgDir = new File(path);
		
		File[] files = imgDir.listFiles();
		System.out.println("files.length: " + files.length);
		
		for (File file : files) {
			String fileName = file.getName();
			System.out.println(fileName);
			
			migrationService.modifyMemberImage(fileName);
		}
	}
}
