package org.ohjic.flower.service.impl;


import java.util.List;

import org.apache.commons.fileupload.FileUploadException;
import org.ohjic.flower.dao.UserMapper;
import org.ohjic.flower.exception.NotAcceptedContentTypeException;
import org.ohjic.flower.exception.PermissionDeniedException;
import org.ohjic.flower.model.User;
import org.ohjic.flower.service.FileService;
import org.ohjic.flower.service.ImageService;
import org.ohjic.flower.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UserServiceImpl implements UserService {
	
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private ImageService imageService;
	@Autowired
    private FileService fileServcie;
	
	/**
	 * 사용자 한명의 정보를 가지고 온다.
	 */
	@Override
	public User getUser(String userId) {
		return userMapper.selectByPrimaryKey(userId); 
	}
	
	/**
	 * @throws FileUploadException 
	 * @throws NotAcceptedContentTypeException 
	 */
	
	@Autowired
	DataSourceTransactionManager transactionManager;
	
	@Override
	public boolean modifyUser(User user, MultipartFile pFile, List<MultipartFile> sFile) throws FileUploadException, NotAcceptedContentTypeException {
		
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		TransactionStatus status = transactionManager.getTransaction(def);
		
		int flag1 = 0;
		boolean flag2 = false;
		boolean flag3 = false;
		String imgName = null;
		String profileImgDirectory = "profileImg";
		
		try {
			if(!pFile.isEmpty()){
				imgName = fileServcie.fileUpload(pFile, profileImgDirectory, FileServiceImpl.IMAGE_TYPES);
			    user.setProfileImg(imgName);
			    flag1 = userMapper.updateByPrimaryKeySelective(user);
			}
			
			if(!sFile.isEmpty()){
				flag2 = imageService.regist(user, sFile);
			}
			
			transactionManager.commit(status);
			flag3 = true;
		}catch (Exception ex) {
			transactionManager.rollback(status);
			logger.error(ex.toString());
		}
		
		return flag3;
		
	}
	//user 정보를 삭제한다
	@Override
	public boolean removeUser(String userId) {
		// TODO 사용자를 등록할 때는 user 정보와 소속 부서(목장) 정보가 같이 삭제되어야 함.
		return userMapper.deleteByPrimaryKey(userId) > 0 ? true : false;
	}

	@Override
	public User getUserByUserId(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean regist(User user) {
		return userMapper.insert(user) == 1 ? true:false;
	}

	@Override
	public List<User> getUserList() throws PermissionDeniedException {
		return userMapper.selectList();
	}

	
}
