package org.ohjic.flower.service.impl;


import java.util.List;

import org.apache.commons.fileupload.FileUploadException;
import org.ohjic.flower.dao.ImageMapper;
import org.ohjic.flower.exception.NotAcceptedContentTypeException;
import org.ohjic.flower.model.Image;
import org.ohjic.flower.model.User;
import org.ohjic.flower.service.FileService;
import org.ohjic.flower.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImageServiceImpl implements ImageService {

	@Autowired
	private ImageMapper imageMapper;
	@Autowired
    private FileService fileServcie;
	

	@Override
	public boolean regist(User user, List<MultipartFile> file) throws FileUploadException, NotAcceptedContentTypeException {
		
		Image img = new Image();
		
		String id = user.getUserId();
		img.setUserId(id);
		
		int flag = 0;
		List<String> imgNameList = null;
		String storeImgDirectory = "storeImg";
		
		imgNameList = fileServcie.fileUpload(file, storeImgDirectory, FileServiceImpl.IMAGE_TYPES);
		
		int imgNameListSize = imgNameList.size();
		if(imgNameListSize > 0) {
			int flag3 = imageMapper.deleteByPrimaryKey(id);
			System.out.println("flag3: " + flag3);
		}
		
		for(int i=0; i<imgNameListSize; i++){
			String imgName = imgNameList.get(i);
			img.setStoreImg(imgName);
			img.setImgId(i+1);
			  
			flag = imageMapper.insert(img);
		  }
		
		return flag > 0 ? true:false; 
	}


	@Override
	public Image getImage(String userId) {
		return imageMapper.selectByPrimaryKey(userId);
	}


	@Override
	public boolean removeImage(String userId) {
		return imageMapper.deleteByPrimaryKey(userId) > 0 ? true : false;
	}

}
