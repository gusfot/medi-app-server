package org.ohjic.mem.service.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ohjic.mem.common.GOODS;
import org.ohjic.mem.dao.CgroupMapper;
import org.ohjic.mem.dao.ChurchinfoMapper;
import org.ohjic.mem.dao.FinmemberMapper;
import org.ohjic.mem.dao.HistorychristeningMapper;
import org.ohjic.mem.dao.HistorypgradeMapper;
import org.ohjic.mem.dao.MemberMapper;
import org.ohjic.mem.dao.ToolsMapper;
import org.ohjic.mem.model.Cgroup;
import org.ohjic.mem.model.Churchinfo;
import org.ohjic.mem.model.Historychristening;
import org.ohjic.mem.model.Kyo;
import org.ohjic.mem.model.Member;
import org.ohjic.mem.model.MemberWithBLOBs;
import org.ohjic.mem.service.ToolsService;
import org.ohjic.mem.vo.TidVo;
import org.ohjic.mem.vo.TidsVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;

@Service
public class ToolsServiceImpl implements ToolsService {
	
	private static final String KYO = "kyo";

	private static final Logger logger = LoggerFactory.getLogger(ToolsServiceImpl.class);
	
	@Autowired
	ToolsMapper toolsMapper;
	
	@Autowired
	ChurchinfoMapper churchinfoMapper;
	
	@Autowired
	CgroupMapper cgroupMapper;
	
	@Transactional
	@Override
	public void removeChuch(Integer churchCode, boolean isFree) {
		
		toolsMapper.deleteGoodsByChurchCode(churchCode);
		toolsMapper.deleteChurchUserByChurchCode(churchCode);
		if(isFree) {
			toolsMapper.deleteChurchInfoByChurchCode(churchCode);
			toolsMapper.deleteServiceByChurchCode(churchCode);
			toolsMapper.deleteProductByChurchCode(churchCode);
		}
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("church", KYO+churchCode);
				
		toolsMapper.dropDatabaseByChurchCode(params);
			
	}

	@Transactional
	@Override
	public void readjustFamily(Integer churchCode) {
			
		Map<String, Object> params = new HashMap<>();
		params.put("church", KYO+churchCode);
		
		toolsMapper.readjustFid(params);
		toolsMapper.readjustFamilyLeaderBySelf(params);	
		toolsMapper.readjustFamilyLeaderByAllMember(params);
		toolsMapper.readjustFamilyLeaderAndRelation(params);
		toolsMapper.readjustPartnerRelation(params);
		toolsMapper.readjustFatherRelation(params);
		toolsMapper.readjustMotherRelation(params);
		toolsMapper.readjustPartnerRelationOfFamilyLeader(params);
		toolsMapper.readjustAppellation(params);
		toolsMapper.readjustPatner(params);
			
	}

	/**
	 * UPDATE ohjic.portal_user
		SET user_id = '바꿀아이디'
		WHERE user_id = '원래아이디';
		
		UPDATE ohjic.church_user
		SET user_id = '바꿀아이디'
		WHERE user_id = '원래아이디';
		
		UPDATE ohjic.churchInfo
		SET adminId = '바꿀아이디'
		WHERE adminId = '원래아이디';
		
		UPDATE ohjic.service
		SET userId = '바꿀아이디'
		WHERE userId = '원래아이디';
		
		UPDATE ohjic.product
		SET userId = '바꿀아이디'
		WHERE userId = '원래아이디';
		 
		UPDATE kyoXXXX.board
		SET user_id = '바꿀아이디'
		WHERE user_id = '원래아이디';
		
		UPDATE kyoXXXX.manager
		SET id = '바꿀아이디'
		WHERE id = '원래아이디';
		
		UPDATE kyoXXXX.managerLog
		SET user_id = '바꿀아이디'
		WHERE user_id = '원래아이디';
	 */
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	@Override
	public void changeChurchAdminId(Integer churchCode, String oldAdminId, String newAdminId) {
		
		Map<String, Object> params = new HashMap<>();
		params.put("church", KYO+churchCode);
		params.put("oldAdminId", oldAdminId);
		params.put("newAdminId", newAdminId);
		
		toolsMapper.updateUserIdOfPortalUserByUserId(params);
		toolsMapper.updateUserIdOfChurchUserByUserId(params);
		toolsMapper.updateAdminIdOfChurchInfoByAdminId(params);
		toolsMapper.updateUserIdOfServiceByUserId(params);
		toolsMapper.updateUserIdOfProductByUserId(params);
		toolsMapper.updateUserIdOfKyoBoardByUserId(params);
		toolsMapper.updateUserIdOfKyoManagerByUserId(params);
		toolsMapper.updateUserIdOfKyoManagerLogByUserId(params);
			
	}

	@Override
	public boolean readjustEduCount(Integer churchCode) {
		
		boolean result = false;
		
		try{
			
			Map<String, Object> params = new HashMap<>();
			params.put("church", KYO+churchCode);
			result = toolsMapper.updateNowMemberCountOfEdu(params) > 0 ? true:false;
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public int hasNameCodeForVisitCategory(Integer churchCode) {
		
		int result = 0;
		Map<String, Object> params = new HashMap<>();
		params.put("church", KYO+churchCode);
		
		try{
			result = toolsMapper.selectNameCodeOfVisitCategory(params);
		}catch (Exception e) {
			// TODO: handle exception
			result = -1;
		}
		return result;
	}

	@Override
	public boolean renameByReplacingFilesInDirectory(String orginalDirStr, String oldStr, String newStr) {
		
		File originalDir = new File(orginalDirStr);
		File newDir = new File(orginalDirStr+"/" + "rename");
		
		File[] files = originalDir.listFiles();
		
		List<String> errorList = new ArrayList<>();
		
		if(!newDir.exists()) {
			newDir.mkdir();
		}
		
		for (File file : files) {
			File newFile = new File(newDir, file.getName().replaceAll(oldStr, newStr));
			try {
				Files.copy(file.toPath(), newFile.toPath());
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("This file is failed!!!: " + file.getName());
				errorList.add(file.getName());
			}
		}
		
		return errorList.size() > 0 ? false:true;
	}

	@Override
	public List<Churchinfo> getChurchInfoList() {
		return churchinfoMapper.selectList(1);
	}

	@Override
	public boolean authSmsForChurch(String churchName, String churchPhoneNumber, List<String> userIdList) {

		Map<String, Object> params = new HashMap<>();
		params.put("churchName", churchName);
		params.put("churchPhoneNumber", churchPhoneNumber.replace("-", ""));
		params.put("userIdList", userIdList);
		
		return toolsMapper.insertAuthSmsForChurch(params);
	}

	@Override
	public String generateKyoEncryptedPassword(String plain) {
		return toolsMapper.selectEncryptedPassword(plain);
	}

	@Transactional(readOnly=true)
	@Override
	public List<Map<String, Object>> getKyoTableList(int churchCode) {
		return toolsMapper.selectChurchCodeList(churchCode);
	}

	@Override
	public List<Map<String, Object>> getTableColumnList(int i, String tableName) {
		return toolsMapper.selectTableColumnList(i, tableName);
	}

	@Override
	public int registMemberGuide(Integer churchCode) {
		Map<String, Object> params = new HashMap<>();
		params.put("church", KYO+churchCode);
		return toolsMapper.insertMemberGuide(params);
	}

	@Override
	public int modifyUpdateDateForMemberGuide(Integer churchCode) {
		Map<String, Object> params = new HashMap<>();
		params.put("church", KYO+churchCode);
		return toolsMapper.udpateUpdateDateForMemberGuide(params);
	}


	@Override
	public boolean modifyDashboardTitleByName(Integer churchCode, String name, String title) {
		Map<String, Object> params = new HashMap<>();
		params.put("church", KYO+churchCode);
		params.put("name", name);
		params.put("title", title);
		return toolsMapper.updateDashboardPortletByName(params);
	}


	@Override
	public boolean renameFilesInDirectory(String orginalDirStr, String string, String string2) {
		
		File dir = new File(orginalDirStr);
		
		if(dir.isDirectory()) {
			File[] files = dir.listFiles();
			
			for (File file : files) {
				String filename = file.getName().split("\\.")[0];
				System.out.println(filename);
				
				String newFilename = "";
//				File resultDest = new File(file.getName());
//				System.out.println(resultDest);
				//file.renameTo(resultDest);
			}
		}
		return false;
	}

	@Override
	public List<Map<String, Object>> getChurchListDetail() {
		
		List<Map<String, Object>> result = new ArrayList<>();
		
		List<Map<String, Object>> churchList = toolsMapper.selectChurchList();
		
		for (Map<String, Object> church : churchList) {

			if(church!=null) {
				
				Integer churchCode =  (int)church.get("churchCode");
				String churchName = (String) church.get("churchName");
				Integer limit = church.containsKey("limit") ? (int) church.get("limit"): null;
				
				Map<String, Object> params = new HashMap<>();
				params.put("church", KYO+churchCode);
				
				try {
					Map<String, Object> churchDetail = toolsMapper.selectChurchDetailInfo(params );
					churchDetail.put("churchCode", churchCode);
					churchDetail.put("churchName", churchName);
					churchDetail.put("limit", limit);
					result.add(churchDetail);
				}catch(Exception e) {
					System.out.println(KYO+churchCode + " is not exist..");
				}
			}
		}
		
		return result;
	}

	@Override
	public List<Map<String, Object>> getMemberCardViewListByChurchCode(Integer churchCode) {
		Map<String, Object> params = new HashMap<>();
		params.put("church", KYO+churchCode);
		return toolsMapper.selectMemberCardView(params);
	}

	@Override
	public boolean modifyMemberCardView(Integer churchCode, Map<String, Object> view) {
		view.put("church", KYO+churchCode);
		return toolsMapper.updateManagerSelectView(view) == 1;
	}

	@Override
	public Map<String, Object> getManagerById(Integer churchCode, String managerId) {
		Map<String, String> params = new HashMap<>();
		params.put("church", KYO+churchCode);
		params.put("managerId", managerId);
		return toolsMapper.selectManagerById(params);
	}

	@Override
	public List<Map<String, Object>> getChurchManagerByChurchUseNumber(int useNumber) {
		return toolsMapper.selectChurchManagerByChurchUseNumber(useNumber);
	}

	@Override
	public Map<String, Object> getSuperAdminByChurchCode(Integer churchCode) {
		Map<String, String> params = new HashMap<>();
		params.put("church", KYO+churchCode);
		return toolsMapper.selectSuperAdminByChurchCode(params);
	}

	@Override
	public List<Map<String, String>> getCommonCodeByName(Integer churchCode, String name) {
		Map<String, String> params = new HashMap<>();
		params.put("church", KYO+churchCode);
		params.put("name", name);
		return toolsMapper.selectCommonCodeByName(params);
	}

	@Override
	public boolean registCommonCode(Integer churchCode, Map<String, String> commonCode) {
		Map<String, Object> params = new HashMap<>();
		params.put("church", KYO+churchCode);
		params.put("commonCode", commonCode);
		return toolsMapper.insertCommonCode(params) == 1;
	}


	@Override
	public boolean modifyCommonCodeDepth(Integer churchCode, String name) {
		Map<String, String> params = new HashMap<>();
		params.put("church", KYO+churchCode);
		params.put("name", name);
		return toolsMapper.updateCommonCodeDepth(params) == 1;
	}

	@Override
	public boolean renameFilesByTid(String orginalDirStr) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addGoods(Integer churchCode,String domain, GOODS goods) {
		
		boolean result = false;
		
		Map<String, Object> params = new HashMap<>();
		params.put("churchCode", churchCode);
		params.put("domain", domain);
		params.put("type", goods);
		
		// 스마트콜은 도메인 중복검사를 하지 않는다.
		Map<String, Object> obj = null;
		if(goods != GOODS.smart_call) { 
			obj =toolsMapper.selectGoods(params);
		}
		
		if(obj != null) {
			System.out.println("이미 있는 도메인 입니다.");
			result = false;
		}else {
			result = toolsMapper.insertGoods(params) == 1 ;
		}
		
		return result;
	}

	@Override
	public Map<String, Object> getCgroupByGroupName(Integer churchCode, String groupName) {
		Map<String, String> params = new HashMap<>();
		params.put("church", KYO+churchCode);
		params.put("groupName", groupName);
		return toolsMapper.selectCgroupByGroupName(params);
	}

	@Override
	public boolean registSocheon(Integer churchCode) {
		Map<String, String> params = new HashMap<>();
		params.put("church", KYO+churchCode);
		return toolsMapper.insertSocheon(params)==1;
	}

	@Override
	public List<Map<String, Object>> getMemberNameHanAndEnCount(Integer churchCode) {
		Map<String, String> params = new HashMap<>();
		params.put("church", KYO+churchCode);
		return toolsMapper.selectMemberNameHanAndEnCount(params);
	}

	@Override
	public boolean registSocheon1(Integer churchCode) {
		Map<String, String> params = new HashMap<>();
		params.put("church", KYO+churchCode);
		return toolsMapper.insertSocheonDepth1(params)==1;
	}

	@Override
	public int modifyEndDateForGroupLog(Integer churchCode, Integer year) {
		Map<String, String> params = new HashMap<>();
		params.put("church", KYO+churchCode);
		return toolsMapper.upateEndDateForKGroupLog(params);
	}

	@Override
	public List<Map<String, Object>> getEndDateForGroupLog(Integer churchCode, Integer year) {
		Map<String, Object> params = new HashMap<>();
		params.put("church", KYO+churchCode);
		params.put("year", year);
		return toolsMapper.selecctEndDateForGroupLog(params);
	}

	@Override
	public List<Cgroup> getCgroupByChurch(Integer churchCode) {
		Cgroup cGroup = new Cgroup();
		cGroup.setChurchCode(churchCode);
		return cgroupMapper.selectCgroupList(cGroup);
	}

	@Autowired
	private FinmemberMapper finMemberMapper;
	@Override
	public int modifyPartnerNameOfFinmemberByDeath(Kyo kyo) {
		return finMemberMapper.updatePartnerNameByDeath(kyo);
	}

	
	@Transactional
	@Override
	public int removeChurchUserByRemovedManager(Kyo kyo) {
		return toolsMapper.deleteChurchUserByDeletedManager(kyo);
	}

	@Override
	public int modifyFimMemberNameByMemberName(Kyo kyo) {
		return toolsMapper.updateFimMemberNameByMemberName(kyo);
	}

	@Autowired
	private MemberMapper memberMapper;
	
	@Autowired
	private HistorypgradeMapper historypgradeMapper;
	
	@Autowired
	private HistorychristeningMapper historychristeningMapper;
	
	@Override
	public Object getLatestChrstening(Kyo kyo) {
		
		List<Member> members = memberMapper.selectMemberList(kyo);
		
		List<Integer> updatedTids = new ArrayList<>();
		
		for (Member member : members) {
			
			Integer tid = member.getTid();
			TidVo tidVo = new TidVo();
			tidVo.setChurchCode(kyo.getChurchCode());
			tidVo.setTid(tid);
			
			List<Historychristening> historychristeningList = historychristeningMapper.selectHistorychristeningListByTid(tidVo);
			
			if(historychristeningList!=null && historychristeningList.size() > 0) {
				
				Historychristening lastestHistory = historychristeningList.get(0);
				
				if( (lastestHistory.getChristeningDate()!=null && member.getChristeningDate() !=null &&  lastestHistory.getChristeningDate().getTime() >  member.getChristeningDate().getTime() && lastestHistory.getChristeningDate().after(member.getChristeningDate()))  ||  (lastestHistory.getChristeningDate() != null && member.getChristeningDate() ==null) ) {
					
					System.out.println("member:" + member.getChristeningDate());
					System.out.println("history:" + lastestHistory.getChristeningDate());	
					
					MemberWithBLOBs newMember = new MemberWithBLOBs();
					newMember.setChurchCode(kyo.getChurchCode());
					newMember.setChristeningDate(lastestHistory.getChristeningDate());
					newMember.setChristeningName(lastestHistory.getChristeningName());
					newMember.setChristening(lastestHistory.getChristening());
					newMember.setChristeningMinister(lastestHistory.getChristeningMinister());
					newMember.setChristeningChurch(lastestHistory.getChristeningChurch());
					newMember.setTid(tid);
					
					memberMapper.updateByPrimaryKeySelective( newMember);
					
					updatedTids.add(tid);
					
				}else {
					
					
				}
				
				
			}
		}
		
		String resultJson = new Gson().toJson(updatedTids);
		System.out.println(resultJson);
//		
//		return toolsMapper.selectLatestHistoryChristening();
		return null;
	}

	@Override
	public boolean modifyMemberImageByFile(Integer churchCode, String dir) {

		boolean result = false;
		
		try{
			
			File directory = new File(dir);
			File[] files = directory.listFiles();
			String filePrefix = "/people/init/";
			
			for (File file : files) {
				
				String memberImage = file.getName();
				
//				System.out.println(memberImage);
				String[] imageNames = memberImage.split("\\.");
				String tid = imageNames[0];

				
				
				TidsVo vo = new TidsVo();
				vo.setChurchCode(churchCode);
				Integer[] tidArray = {Integer.valueOf(tid)};
				vo.setTidArray(tidArray );
				Member member = memberMapper.selectLatestMemberByTids(vo );		
				
				
				if(member !=null && !"".equals(member.getMemberImage())) {
					
					MemberWithBLOBs record = new MemberWithBLOBs();
					record.setChurchCode(churchCode);
					record.setMemberImage(filePrefix+memberImage );
					record.setTid(Integer.valueOf(tid));
					
					memberMapper.updateByPrimaryKeySelective(record);
				}
				
			}
			
			result = true;
			
		}catch(Exception e) {
			
			e.printStackTrace();
			
		}
		
		return result;
	}
	
	
	@Override
	public boolean modifyMemberImageByFileName(Integer churchCode, String dir) {

		boolean result = false;
		
		try{
			
			File directory = new File(dir);
			File[] files = directory.listFiles();
			String filePrefix = "people/init/";
			
			for (File file : files) {
				
				String memberImage = file.getName();
				
//				System.out.println(memberImage);
				String[] imageNames = memberImage.split("\\.");
				String memberName = imageNames[0];
				String memberNameDistinct = "";

				
				MemberWithBLOBs memberVo =new MemberWithBLOBs();
				memberVo.setChurchCode(churchCode);
				memberVo.setMemberName(memberName);
				Member member = memberMapper.selectMemberByMemberNameAndMemberNameDistinct("kyo"+churchCode, memberName, memberNameDistinct );
				
				
				if(member !=null && memberName!=null ) {
				
//					String newDir = dir + File.separator+ "new";
					File newDir = new File(dir+File.separator + "new");
					
					if(!newDir.exists()) {
						newDir.mkdir();
					}
					
					
					String oldStr = memberName;
					String newStr = String.valueOf(member.getTid());
					File newFile = new File(newDir , file.getName().replaceAll(oldStr , newStr));
					try {
						Files.copy(file.toPath(), newFile.toPath());
					} catch (IOException e) {
						e.printStackTrace();
						System.out.println("This file is failed!!!: " + file.getName());
//						errorList.add(file.getName());
					}
					
					
					System.out.println("OOOOOOOOOOOOOOOOOOOOO");
					MemberWithBLOBs record = new MemberWithBLOBs();
					record.setChurchCode(churchCode);
					record.setMemberImage(filePrefix+member.getTid()+ "."+imageNames[1]);
					record.setTid(member.getTid());
					
					memberMapper.updateByPrimaryKeySelective(record);
				}else {
					System.out.println("XXXXXXXXXXXXXXXXXXX");
				}
				
			}
			
			result = true;
			
		}catch(Exception e) {
			
			e.printStackTrace();
			
		}
		
		return result;
	}


}

