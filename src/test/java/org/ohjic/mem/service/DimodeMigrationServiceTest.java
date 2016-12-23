package org.ohjic.mem.service;

import java.io.File;
import java.io.IOException;
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
								 "file:src/main/webapp/WEB-INF/spring/appServlet/dao-context_live.xml"})
public class DimodeMigrationServiceTest {

	@Autowired
	@Qualifier("dimodeMigrationService")
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

			FileUtils.writeByteArrayToFile(new File(destDirStr + File.pathSeparator + filename+"."+fileType), fileBytes);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGenerteKGroupLogByOriginalKGroupLog() {
		migrationService.generteKGroupLogByOriginalKGroupLog();
	}
	
	/**
	 * 파일명 rename 후 db insert
	 */
	@Test
	public void testGetExistMemberImage() {
		
		String path = "C:/church_images/burim";
		File imgDir = new File(path);
		
		File[] files = imgDir.listFiles();
		System.out.println("files.length: " + files.length);
		
		for (File file : files) {
			String fileName = rename(file.getName());
			System.out.println(fileName);
			
			migrationService.modifyMemberImage(fileName);
		}
	}

	private String rename(String originName) {
		String newName = "";

		newName =originName.replaceAll("[^0-9]", "");
		return newName;
	}
}
