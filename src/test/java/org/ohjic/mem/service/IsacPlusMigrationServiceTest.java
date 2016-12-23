package org.ohjic.mem.service;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.ohjic.mem.model.Member;
import org.ohjic.mem.model.MemberWithBLOBs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
								 "file:src/main/webapp/WEB-INF/spring/appServlet/dao-context_dev.xml"})
public class IsacPlusMigrationServiceTest {

	@Autowired
	@Qualifier("isacPlusMigrationService")
	private MigrationService migrationService;
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private ToolsService toolsService;
	/**
	 * 성도정보로 db에 있는 프로필사진 컬럼을 사진으로 변경한다.
	 */
	@Test
	public void testGetMemberList() {
		
		// 파일이 저장될 위치
		String destDirStr = "C:/Users/ohjic/Documents/juan/사진";
		
		File imgDir = new File(destDirStr);
		if(imgDir.isDirectory()) {
			File[] files = imgDir.listFiles();
			
			for (File file : files) {
				String fileName = file.getName().split("\\.")[0];
				Map<String, Object> member = (Map<String, Object>) migrationService.getMemberByFileName(fileName);
				
				System.out.println(member);
				
				if(member !=null) {
					String memberName = (String) member.get("p_name");
					String memberNameDistinct =(String) member.get("p_no");
					
									
					Member imgMember = memberService.getMemberByMemberNameAndMemberNameDistinct(memberName, memberNameDistinct);
					String newFilename = imgMember.getTid() + "." + file.getName().split("\\.")[1];
					System.out.println("file.getAbsolutePath()+newFilename : " + file.getParent()+"\\result\\" +newFilename);
					File renameFile = new File(file.getParent()+"\\result\\" +newFilename);
					file.renameTo(renameFile);
					
					String memberImage = "people/init/" + imgMember.getTid() + "." + file.getName().split("\\.")[1];
					MemberWithBLOBs newMember = new MemberWithBLOBs();
					newMember.setTid(imgMember.getTid());
					newMember.setMemberImage(memberImage);
					memberService.modifyMember(newMember);
				}else {
					System.out.println("Member is not exist..");
				}
			}
		}
		// 멤버리스트 조회
		
		
//		for (Map<String, Object> member : memberList) {
//			System.out.println(member.get("p_name"));
//			System.out.println(member.get("p_no"));
//		}
		
//		assert(memberList.size() > 0);
	}
	
	@Test
	public void testRenameFilesInDirectory() {
		String orginalDirStr = "C:/Users/ohjic/Documents/의왕우리교회 백업파일/의왕우리교회백업/11.성도사진/IPSPictureFolder";
		
		boolean result = toolsService.renameFilesByTid(orginalDirStr);
		
		assertTrue(result);
	}
	
	@Test
	public void testStatByChurch() {
		
		List<Map<String, Object>> result = toolsService.getChurchListDetail();
		
//		assertTrue(result);
	}
}
