package org.ohjic.flower.service;

import java.util.List;

import org.apache.commons.fileupload.FileUploadException;
import org.ohjic.flower.exception.NotAcceptedContentTypeException;
import org.ohjic.flower.exception.PermissionDeniedException;
import org.ohjic.flower.model.User;
import org.springframework.web.multipart.MultipartFile;

public interface UserService {

	/**
	 * user 한명 기본정보를 가지고온다 
	 * @param userId
	 * @return
	 */
	User getUser(String userId);
	
	/**
	 * user 연관된 정보를 가지고 온다.
	 * @param userId
	 * @return
	 */
	User getUserByUserId(String userId);
	
	/**
	 * user 를 등록한다
	 * @param user
	 * @return
	 */
	boolean regist(User user);
	
	/**
	 * user 정보를 수정한다
	 * @param user
	 * @param sFile 
	 * @return
	 * @throws FileUploadException 
	 * @throws NotAcceptedContentTypeException 
	 */
	boolean modifyUser(User user, MultipartFile pFile, List<MultipartFile> sFile) throws FileUploadException, NotAcceptedContentTypeException;
	
	/**
	 * user 정보를 삭제한다 
	 * @param userId
	 * @return
	 */
	boolean removeUser(String userId);

	/**
	 * 사용자 목록을 조회한다.
	 * @return
	 */
	List<User> getUserList() throws PermissionDeniedException;

}









