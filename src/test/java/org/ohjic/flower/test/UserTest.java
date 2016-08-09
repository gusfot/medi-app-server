package org.ohjic.flower.test;

import java.util.List;

import org.junit.Test;

public class UserTest {

	
	@Test
	public void testUser(){
		Member member = new Member();
		member.setId(1);
		
		ProfileImg img = new ProfileImg();
		img.setFileName("1.jpg");
		img.setPath("c:\\attach\\");
		
		member.setProfileImg(img);
		
		
		System.out.println(member.getProfileImg().getFileName());

		
		
		List<StoreImg> storeImageList = member.getStoreImgList();
	}
}
