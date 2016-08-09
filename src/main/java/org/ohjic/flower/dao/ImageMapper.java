package org.ohjic.flower.dao;

import org.ohjic.flower.model.Image;


public interface ImageMapper {

	//int insert(Image record);

	int insert(Image img);

	Image selectByPrimaryKey(String userId);
	
	int deleteByPrimaryKey(String userId);
	
}