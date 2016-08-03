package org.ohjic.flower.service;

import java.util.List;

import org.apache.commons.fileupload.FileUploadException;
import org.ohjic.flower.exception.NotAcceptedContentTypeException;
import org.ohjic.flower.model.Image;
import org.ohjic.flower.model.User;
import org.springframework.web.multipart.MultipartFile;

public interface ImageService {

	boolean regist(User user, List<MultipartFile> file) throws FileUploadException, NotAcceptedContentTypeException;
	
	Image getImage(String userId);
	
	boolean removeImage(String userId);
	
}
