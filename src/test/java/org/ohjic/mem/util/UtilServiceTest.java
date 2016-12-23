package org.ohjic.mem.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Test;

public class UtilServiceTest {

	@Test
	public void testRename() throws IOException {
		String pathname = "C:\\church_images\\burim";
		File dir = new File(pathname);
		
		if(dir.isDirectory()) {
			File[] files = dir.listFiles();
			
			for (File file : files) {
				String newPath = pathname+"\\rename\\";
				File newFile = new File(newPath+rename(file.getName())+".JPG");
				
				boolean result = file.renameTo(newFile);
				
				System.out.println(newPath+newFile.getName());
				
				
//				Path ofile = file.toPath();
//				Path movePath = Paths.get("C:\\Users\\ohjic\\PhpstormProjects\\member\\mem\\application\\controllers\\flat_member\\rename");
//
//				 
//				Files.move(ofile , movePath.resolve(file.getName()));
				
			}
		}
	}
	

	private String rename(String originName) {
		String newName = "";

		newName =originName.replaceAll("[^0-9]", "");
		return newName;
	}
	
	@Test
	public void test() {
		for(int i=1994;i<2017;i++) {
		String sql = "delete from kyo6011.kGroup where (year, k_part_idx, depth1_name) in (\n"
					+"select year, k_part_idx, depth1_name from (\n"
					+"select\n" 
					+ i+" year,3 k_part_idx, ActivityName depth1_name,1 depth, ActivityName group_name, StartDate, EndDate,\n"
					+"if(StartDate is null or StartDate ='', UNIX_TIMESTAMP(STR_TO_DATE(concat("+i+",'-01-01'),'%Y-%m-%d')) , if('"+i+"'= left(StartDate,4),UNIX_TIMESTAMP(STR_TO_DATE(StartDate,'%Y-%m-%d')), UNIX_TIMESTAMP(STR_TO_DATE(concat("+i+",'-01-01'),'%Y-%m-%d')))) start_date,\n"
					+"if(EndDate is null or EndDate ='', UNIX_TIMESTAMP(STR_TO_DATE(concat("+i+"+1,'-01-01'),'%Y-%m-%d'))-1, if('"+i+"'= left(EndDate,4), UNIX_TIMESTAMP(STR_TO_DATE(EndDate,'%Y-%m-%d')), if('"+i+"'< left(EndDate,4),UNIX_TIMESTAMP(STR_TO_DATE(concat("+i+"+1,'-01-01'),'%Y-%m-%d'))-1,0))) end_date\n"
					+"from ChurchActivity where ActivityName != '' and ActivityName !='1'\n" 
					+"and (EndDate is null or EndDate ='')\n"
					+"group by ActivityName\n"
					+") a\n"
					+"where year < left(StartDate,4)*1\n"
					+")\n"
					+";\n";
		
		System.out.println(sql);
		
		}
	}
	
}
