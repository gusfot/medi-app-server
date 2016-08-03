package org.ohjic.flower.service;

import java.util.List;

import org.apache.commons.fileupload.FileUploadException;
import org.ohjic.flower.exception.NotAcceptedContentTypeException;
import org.springframework.http.MediaType;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {

	String fileUpload(MultipartFile file, String uploadPath, List<String> mediaTypeList)
			throws FileUploadException, NotAcceptedContentTypeException;

	List<String> fileUpload(List<MultipartFile> fileList, String uploadPath, List<String> mediaTypeList) 
			throws FileUploadException, NotAcceptedContentTypeException;
}
