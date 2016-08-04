package org.ohjic.flower.test;

import java.util.List;

public class Member {

	private int id;
	private String name;
	
	private int profileImgId;
	private String profileImgName;
	
	private ProfileImg profileImg;
	
	
	private List<StoreImg> storeImgList;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getProfileImgId() {
		return profileImgId;
	}

	public void setProfileImgId(int profileImgId) {
		this.profileImgId = profileImgId;
	}

	public ProfileImg getProfileImg() {
		return profileImg;
	}

	public void setProfileImg(ProfileImg profileImg) {
		this.profileImg = profileImg;
	}

	public List<StoreImg> getStoreImgList() {
		return storeImgList;
	}

	public void setStoreImgList(List<StoreImg> storeImgList) {
		this.storeImgList = storeImgList;
	}
	
	
	
}
