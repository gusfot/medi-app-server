package org.ohjic.flower.model;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

/**
 * 사용자
 * 
 * @author gusfot
 *
 */
public class Image {

	private String userId;
	
	private Integer imgId;
	
	private String imgName;

	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Integer getImgId() {
		return imgId;
	}

	public void setImgId(Integer imgId) {
		this.imgId = imgId;
	}

	public String getImgName() {
		return imgName;
	}

	public void setImgName(String imgName) {
		this.imgName = imgName;
	}
	

}