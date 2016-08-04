package org.ohjic.flower.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import javax.annotation.Resource;

import org.apache.commons.fileupload.FileUploadException;
import org.ohjic.flower.exception.NotAcceptedContentTypeException;
import org.ohjic.flower.service.FileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileServiceImpl implements FileService {

	public static final List<String> IMAGE_TYPES = Arrays.asList("image/gif", "image/jpeg", "image/png");
	
	public static final List<String> EXCEL_TYPES = Arrays.asList("application/vnd.ms-excel");
	
	public static final List<String> ALL_TYPES = Arrays.asList("");
	
	private static final Logger logger = LoggerFactory.getLogger(FileServiceImpl.class);

	@Resource(name = "flowerProperties")
	private Properties flowerProperties;

	public String fileUpload(MultipartFile file, String uploadPath, List<String> mediaTypeList) throws FileUploadException, NotAcceptedContentTypeException {
		
		String newName = null;
		String fileExt = null;
		String dbImgName = null;
		int idx = 1;
		
		logger.info("[pilot] mFile >>>>>>>>>>> " + file);
		logger.info("[pilot] mFile.getOriginalFilename() >>>>>>>>>>> " + file.getOriginalFilename());
		
		String contentType = file.getContentType();
		logger.info("[pilot] contentType >>>>>>>>>>> " + contentType);
		boolean isAccepted = mediaTypeList.contains(contentType);
		
		if (! isAccepted) {
			throw new NotAcceptedContentTypeException();
		}
		
		fileExt = file.getOriginalFilename()
				.substring(file.getOriginalFilename().lastIndexOf(".") + 1, file.getOriginalFilename().length())
				.toLowerCase();

		logger.info("[pilot] fileExt >>>>>>>>>>> " + fileExt);
		logger.info("[pilot] System.nanoTime() >>>>>>>>>>> " + System.nanoTime());
		logger.info("[pilot] idx++ >>>>>>>>>>> " + idx++);

		newName = System.nanoTime() + "_" + (idx++) + "." + fileExt;
		newName = uploadPath + "/" + newName;
		logger.info("::::::::::::::::::::: newName:" + newName);

		File systemDirectory = new File(flowerProperties.getProperty("system.upload.root"));
		logger.info("[pilot] uploadFile >>>>>>>>>>> " + systemDirectory);
		if (!systemDirectory.exists()) {
			systemDirectory.mkdir();
		}

		File newFile = new File(systemDirectory + "/" + newName);
		
		try {
			file.transferTo(newFile);
		} catch (IllegalStateException | IOException e) {
			throw new FileUploadException();
		}
		
		return newName;
		
	}

	@Override
	public List<String> fileUpload(List<MultipartFile> fileList, String uploadPath,  List<String> mediaTypeList) throws FileUploadException, NotAcceptedContentTypeException {

		MultipartFile mFile = null;
		String imgName = null;
		List<String> imgNameList = new ArrayList<>();
		
		logger.info("[pilot] fileList.size() >>>>>>>>>>> " + fileList.size());

		for (int i = 0; i < fileList.size(); i++) {
			
			if (!fileList.get(i).isEmpty()) {
				mFile = fileList.get(i);
				imgName = fileUpload(mFile, uploadPath, mediaTypeList);
				logger.info("[pilot] imgName >>>>>>>>>>> " + imgName);
				imgNameList.add(imgName);
			}
		}
		
		return imgNameList; // 디비에 들어갈 저장 파일이름 리턴
	}

}
