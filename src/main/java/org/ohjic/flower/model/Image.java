package org.ohjic.flower.model;

/**
 * 사용자
 * 
 * @author gusfot
 *
 */
public class Image {

	private String userId;
	
	private int imgSeq;
	
	private Integer imgId;

	private String storeImg;

	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getImgSeq() {
		return imgSeq;
	}

	public void setImgSeq(int imgSeq) {
		this.imgSeq = imgSeq;
	}

	public Integer getImgId() {
		return imgId;
	}

	public void setImgId(Integer imgId) {
		this.imgId = imgId;
	}

	public String getStoreImg() {
		return storeImg;
	}

	public void setStoreImg(String storeImg) {
		this.storeImg = storeImg;
	}

	
	
	

}