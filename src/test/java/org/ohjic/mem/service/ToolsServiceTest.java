package org.ohjic.mem.service;

import static org.junit.Assert.assertTrue;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.ohjic.mem.common.GOODS;
import org.ohjic.mem.dao.ChurchUseNumberMapper;
import org.ohjic.mem.model.Cgroup;
import org.ohjic.mem.model.ChurchUseNumber;
import org.ohjic.mem.model.Churchinfo;
import org.ohjic.mem.model.Kyo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.google.gson.Gson;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/dao-context_live.xml" })
public class ToolsServiceTest {

	@Autowired
	private ToolsService toolsService;

	/**
	 * 교회정보를 삭제한다.
	 * 
	 * // Integer churchCode = 3194; // 3194 열국교회 // Integer churchCode = 6068;
	 * // 효성교회 (6068) // Integer churchCode = 6051; // 6051 사랑의교회 // Integer
	 * churchCode = 5192; // 5192 참사랑교회 // Integer churchCode = 1786; // 1786
	 * 인천서부교회 // Integer churchCode = 1782; // 1782 천군교회 // Integer churchCode =
	 * 5192; // 5192:참사랑교회 // Integer churchCode = 6064; // 6064:참사랑교회 //
	 * Integer churchCode = 3194; // 3194:열국교회 // Integer churchCode = 6094 ; //
	 * 6094:김지훈 // Integer churchCode = 63 ; // 63:은평교회3부청소년부(테스트용) // Integer
	 * churchCode = 1859 ; // 1859:시민교회 // Integer churchCode = 6154 ; // 진성교회
	 * // Integer churchCode = 845 ; // 삼양교회 // Integer churchCode = 1616 ; //
	 * 여수명은교회 // Integer churchCode = 5480 ; // 5480 성광교회 // Integer churchCode
	 * = 6184 ; // 오직교회 // Integer churchCode = 5330 ; // 의왕우리교회 // Integer
	 * churchCode = 3844 ; // 3844 자인제일교회 // Integer churchCode = 1016 ; // 1016
	 * 시온성교회 // Integer churchCode = 6184 ; // 6184 오직교회 // Integer churchCode =
	 * 6241 ; // 주북교회-유년부-6241 // Integer churchCode = 6240 ; // 주북교회-중등부-6240
	 * // Integer churchCode = 6243 ; // 주북교회-초등부-6243 // Integer churchCode =
	 * 4949 ; // 성은교회 // Integer churchCode = 2054 ; // 온양신광교회청년부(2054 //
	 * Integer churchCode = 4603 ; // 춘천온누리교회중등부(4603), // Integer churchCode =
	 * 5886 ; // 연무제일교회5886 // Integer churchCode = 928 ; // 928 재건중앙교회 (무료사용)
	 * // Integer churchCode = 701 ; // 신성교회701 // Integer churchCode = 1169 ;
	 * // 강릉백석교회(1169) // Integer churchCode = 6377 ; // 6377 김화감리교회 // Integer
	 * churchCode = 6258 ; // 평안교회-6258 // Integer churchCode = 1202 ; // 새누리
	 * 1202 (무료 교적 사용중) // Integer churchCode = 1203 ; // 새누리청년 1203 (무료 교적 사용중)
	 * // Integer churchCode = 5432 ; // 안양중앙교회-5432 // Integer churchCode =
	 * 1999 ; // 영길교회(1999) // Integer churchCode = 2000 ; // 영길중고등부(2000) //
	 * Integer churchCode = 2000 ; // 영길중고등부(2000) // Integer churchCode = 5925
	 * ; // 제주벧엘감리교회(5925)
	 */
	@Test
	public void testRemoveChurch() {

		// Integer churchCode = 1523 ; // 기적의 감리교회(1523)
		// Integer churchCode = 908 ; // 석천제일교회-908
		// Integer churchCode = 6202; // 헤븐리터치-6202
		// Integer churchCode = 5407; // 그십자가교회-5407
		// Integer churchCode = 1238; // 천안대성교회-1238
		// Integer churchCode = 3881; // 혜현교회-3881
		// Integer churchCode = 4707; // 송파사랑의교회-4707
		// Integer churchCode = 6819; // 신갈중앙교회-6819
		// Integer churchCode = 6842; // 수원동산교회 6842
		// Integer churchCode = 7253; // 김천성화교회-7252 김천성화교회-7253
		// Integer churchCode = 7318 ; // 김천성화교회-7252 김천성화교회-7253, 7318
//		Integer churchCode = 1329; // 동주교회-1329
//		Integer churchCode = 3049; // 사랑과평화교회-3049
		
//		Integer churchCode = 4018; // 좋은이웃교회-4018
//		Integer churchCode = 2861; // 기륭한국교회-2861
//		Integer churchCode = 3519; // 북삼제일교회-3519
//		Integer churchCode = 5230; // 김천명성교회-5230
//		Integer churchCode = 1426; // 삼은대길교회-1426
//		Integer churchCode = 7485; // ychurch-7485
//		Integer churchCode = 422; // 명성교회-422
//		Integer churchCode = 7668; // 세인교회-7667
//		Integer churchCode = 5088; // 성산포교회-5088
//		Integer churchCode = 908; // 석천제일교회-908
//		Integer churchCode = 3380; // 진도초대교회-3380
//		Integer churchCode = 6322; // 6322 내일 02년생
//		Integer churchCode = 6323; // 6323 내일03년생
//		Integer churchCode = 6324; // 6324 내일04냔생
//		Integer churchCode = 6350; // 6350 내일중등교사
//		Integer churchCode = 6720; // 6720 내일중등새가족
//		Integer churchCode = 2682; // 2682 예제공동체교회
//		Integer churchCode = 7900; // 성문교회-7900
//		Integer churchCode = 6566; // 6566 광주서광교회
//		Integer churchCode = 2276; // 홍천제일-2276 
//		Integer churchCode = 2277; // 홍천제일-2277
//		Integer churchCode = 6753; // 주례교회청년부교회 6753
//		Integer churchCode = 7229; // 푸른우리교회청년부-7229
//		Integer churchCode = 4876; // 새빛이슬청년부-4876
//		Integer churchCode = 770; // 대사교회-770
//		Integer churchCode = 7935; // 예수열방의소망교회-7935
//		Integer churchCode = 2556; // 행복한교회-2556
//		Integer churchCode = 3729; // 보라매교회-3729
//		Integer churchCode = 286; // 테스트3-286
//		Integer churchCode = 7870; // 창원임마누엘교회-7870
//		Integer churchCode = 6108; // 6108-김찬주
//		Integer churchCode = 7455; // 소생-7455
		Integer churchCode = 7456; // 소생-7456


		boolean isFree = true; // 무료 사용여부

		toolsService.removeChuch(churchCode, isFree);

	}

	/**
	 * 가족 관계 재설정 // Integer churchCode = 2393; // Integer churchCode = 6233; //
	 * Integer churchCode = 5291; // 장유대성교회 // Integer churchCode = 3883; //
	 * 분당우리교회 // Integer churchCode = 6328; // 영복교회 // Integer churchCode =
	 * 6352; // 송내사랑의교회 // Integer churchCode = 6026; // 주안감리교회 // Integer
	 * churchCode = 6344; // 서북교회 // Integer churchCode = 6346; // 주님앞에 제일교회 //
	 * Integer churchCode = 3809; // 신도교회 // Integer churchCode = 1293; //
	 * 서석교회-1293 // Integer churchCode = 3986; // 목동반석교회-3986 // Integer
	 * churchCode = 6326; // 정원교회 // Integer churchCode = 6428; // 한사랑교회 //
	 * Integer churchCode = 6402; // 군산세광교회 // Integer churchCode = 5616; //
	 * 여의도순복음분당교회-5616 // Integer churchCode = 3814; // 하나사랑의교회-3814 // Integer
	 * churchCode = 6325; // 금성교회-6325 // Integer churchCode = 6515; //
	 * 서부제일교회6515 // Integer churchCode = 6515; // 서부제일교회6515 // Integer
	 * churchCode = 5291; // 장유대성교회-5291 // Integer churchCode = 3883; //
	 * 분당우리교회-3883 // Integer churchCode = 6329; // 서문교회-6329 // Integer
	 * churchCode = 6344; // 서북교회-6344 // Integer churchCode = 6506; //
	 * 부산제일교회-6506 // Integer churchCode = 6506; // 부산제일교회-6506 // Integer
	 * churchCode = 476; // 꿈꾸는교회-476 // Integer churchCode = 5818; //
	 * 평택침례교회-5818 // Integer churchCode = 3164; // 원천침례교회-3164 // Integer
	 * churchCode = 5626; // 수인중앙교회-5626 // Integer churchCode = 6451; //
	 * 신광남부교회-6451 // Integer churchCode = 6535; // 부민교회-6535 // Integer
	 * churchCode = 2393; // 새로남교회-2393 // Integer churchCode = 3740; //
	 * 호산나교회-3740 // Integer churchCode = 5626; // 수인중앙교회-5626 // Integer
	 * churchCode = 3975; // 서울침례교회-3975 // Integer churchCode = 6736; //
	 * 신갈중앙교회-6736 // Integer churchCode = 6630; // 신갈중앙교회-6630 Integer
	 * churchCode = 6503; // 유성교회-6503
	 */
	@Test
	public void testReadustFamily() {

		// Integer churchCode = 6217; // 성지교회-6217
		// Integer churchCode = 6326; // 정원교회-6326
		// Integer churchCode = 6503; // 유성교회-6503
		// Integer churchCode = 6037; // 오병이어교회-6037
		// Integer churchCode = 3287; // 남현교회-3287
		// Integer churchCode = 6734; // 대전제자들교회-6734
		// Integer churchCode = 2727; // 효성영광교회-2727
		// Integer churchCode = 6425; // 동암교회-6425
		// Integer churchCode = 7274; // 마포중앙교회 7274
		// Integer churchCode = 7276; // 신천교회 7274
		// Integer churchCode = 7306; // 천안중부교회 7306
//		Integer churchCode = 7307; // 천안중부교회 7307
//		Integer churchCode = 7343; // 드림교회 7343
//		Integer churchCode = 7388; // 항동교회 7388
//		Integer churchCode = 7353; // 영신교회 7353
//		Integer churchCode = 7418; // 만나교회 7418
//		Integer churchCode = 7500; // 갈마교회 7500
//		Integer churchCode = 7587; // 강남동교회 7587
//		Integer churchCode = 7590; // 대전새중앙교회 7590
//		Integer churchCode = 7517; // 황금동교회 7517
//		Integer churchCode = 7657; // 신세계교회 7657
//		Integer churchCode = 7618; // 신남교회 7618
//      Integer churchCode = 7694; // 송도가나안교회 7694
//        Integer churchCode = 7737; // 영남제일교회 7737
		Integer churchCode = 7756; // 동산교회 7756
		

		toolsService.readjustFamily(churchCode);

	}

	/**
	 * 관리자 아이디 변경 쿼리
	 */
	@Test
	// @Test(expected=Exception.class)
	public void testChangeChurchAdminId() {

		Integer churchCode = 7642;
		String oldId = "ohnlee49";
		String newId = "johnlee49";

		toolsService.changeChurchAdminId(churchCode, oldId, newId);

	}

	/**
	 * 교육 수강인원 현재로 맞춰주기
	 */
	@Test
	public void testReadjustEduCount() {

		// Integer churchCode = 7276;
//		Integer churchCode = 7307; // 천안중부교회 7307
//		Integer churchCode = 7353; // 영신교회 7353
//		Integer churchCode = 7418; // 만나교회 7418
//		Integer churchCode = 7500; // 갈마교회 7500
//		Integer churchCode = 7587; // 강남동교회 7587
//		Integer churchCode = 7517; // 황금동교회 7517

		Integer churchCode = 7657; // 신세계교회 7657
		boolean result = toolsService.readjustEduCount(churchCode);

		assertTrue(result);
	}

	/**
	 * 코회 nameCode에 visitCategory 데이터 있는지 여부 확인
	 */
	@Test
	public void testHasNameCodeForVisitCategory() {

		List<Churchinfo> churchCodeList = toolsService.getChurchInfoList();
		List<Churchinfo> hasNotChurch = new ArrayList<>();

		for (Churchinfo churchinfo : churchCodeList) {
			int result = toolsService.hasNameCodeForVisitCategory(churchinfo.getChurchCode());

			if (result != 3 && result > -1) {
				// System.out.println(churchinfo.getChurchName() + ": " +
				// churchinfo.getChurchCode());
				hasNotChurch.add(churchinfo);
			}
		}

		for (Churchinfo churchinfo : hasNotChurch) {
			System.out.println(churchinfo.getChurchName() + ": " + churchinfo.getChurchCode());
		}
	}

	/**
	 * 디렉토리 내의 모든 파일목록의 파일명의 일부를 replace함으로 변경한다. replace된 파일들은 해당 디렉토리 내의
	 * rename 디렉토리에 복사된다. toolsService.renameFilesInDirectory(orginalDirStr,
	 * "S", "1"); ex) S0061000 => 10061000
	 * 
	 */
	@Test
	public void testRenameByReplacingFilesInDirectory() {
		String orginalDirStr = "C:/Users/ohjic/Downloads/70000";
		boolean result = toolsService.renameByReplacingFilesInDirectory(orginalDirStr, "S", "1");

		assertTrue(result);
	}

	@Test
	public void testRenameFilesInDirectory() {
		String orginalDirStr = "C:/Users/ohjic/Documents/juan/사진";

		boolean result = toolsService.renameFilesInDirectory(orginalDirStr, "S", "1");

		assertTrue(result);
	}

	/**
	 * 문자인증이 되지 않는 교회를 수동으로 문자인증 처리한다.
	 */
	@Test
	public void testAuthSmsForChurch() {
		/*
		 * 관리자: 이준영(id:shalom7312 ), 교회번호로 문자인증 요청, 052-245-0091 / 이름:우정교회 관리자:
		 * 이준영(oryun4825 ), 교회번호로 문자인증 요청, 024854004 / 이름:오륜교회 울산대영교회 ,
		 * 전화번호:052-288-1771,
		 * 권원식(holysky23),김명규(kimmg),김성태(elkaime),양형모(chong3824),서동혁(seawind7),
		 * 이형욱(dasa1882),박은석(dmstjr2104)
		 */
		/*
		 * String churchNam = "울산대영교회"; String churchPhoneNumber =
		 * "052-288-1771".replace("-", ""); List<String> userIdList = new
		 * ArrayList<>(); userIdList.add("holysky23"); userIdList.add("kimmg");
		 * userIdList.add("elkaime"); userIdList.add("chong3824");
		 * userIdList.add("seawind7"); userIdList.add("dasa1882");
		 * userIdList.add("dmstjr2104");
		 */
		/*String churchNam = "새롬교회";
		String churchPhoneNumber = "031-394-9183".replace("-", "");
		List<String> userIdList = new ArrayList<>();
		userIdList.add("woo1409");*/
		
/*		String churchNam = "광교지구촌교회";
		String churchPhoneNumber = "031-212-2291";
		
		churchPhoneNumber = churchPhoneNumber.replace("-", "");
		List<String> userIdList = new ArrayList<>();
		userIdList.add("sunggimin10");
*/
		/*
		String churchNam = "무주장로교회";
		String churchPhoneNumber = "063-324-9191";
		
		List<String> userIdList = new ArrayList<>();
		userIdList.add("gods1023");
		userIdList.add("woochiun ");
		userIdList.add("ilhf317");
		*/
/*		String churchNam = "예수사랑교회";
		String churchPhoneNumber = "063-278-7004";
		
		List<String> userIdList = new ArrayList<>();
		userIdList.add("lsy4421");*/
		
		String churchNam = "울산대영교회";
		String churchPhoneNumber = "052-288-1771";
		
		List<String> userIdList = new ArrayList<>();
		userIdList.add("cjuhome");


		boolean result = toolsService.authSmsForChurch(churchNam, churchPhoneNumber, userIdList);

		assertTrue(result);
	}

	// String plain = "1111"; // a0ca9ad87e220dd9ee97c32f94142afc
	// String plain = "1004";
	// String plain = "7511"; // c472207ab6bdc021ae67cbe471fcf1ad
	// String plain = "0930"; // fa641e55aad0372b6f9d150d67b3b8fc
	// 기존:26f09498bc5fd1505d5784e0e78a462d
	// String plain = "2053"; // b71b61c92e43750f9127806dd87085fa
	// String plain = "0298"; // 35ef2e86354c4c8978a022e865d28af5
	// String plain = "5755"; // 5295ad31b07037cd3bc2bb528ebdbf2f
	// String plain = "7954"; // ff49426aa6ab92dbbf8f13b39b655ff4
	// String plain = "0863"; // 6131cca989256bf7992c14ff0bd22de6
	// String plain = "9170"; // 853bb16a7e800261fc1a1afa45ed31d5
	// String plain = "2701"; // 7ff1f83e78bd3da1d7468c37a9b6bc02
	// String plain = "cu2642!!"; // 7ff1f83e78bd3da1d7468c37a9b6bc02
	@Test
	public void testGenerateKyoEncryptedPassword() {

		 //String plain = "1111"; // e12c1a24d4a6e91609a3f89a753c9361
		// String plain = "1234"; // 2379ae4a8c79ec840b5298706094d134
		//String plain = "!@calling"; // 2379ae4a8c79ec840b5298706094d134
		 //String plain = "jesus213"; // e12c1a24d4a6e91609a3f89a753c9361
//		 String plain = "150917!!"; // e12c1a24d4a6e91609a3f89a753c9361
//		 String plain = "elcnjusa!@"; // 39b75cbd901465ec76166d89e84bbcc1
//		 String plain = "87090600"; // 39b75cbd901465ec76166d89e84bbcc1
//		 String plain = "0104"; // 7193c7488f2fb141ab905e6ff9592a2c
//		 String plain = "0507"; // b8943b100352121f522d4b2bc548b405
//		 String plain = "0810"; // a2c8aa36f279b0f210ded8ab02d0f3ff
//		 String plain = "1416"; // 0d24feb597877f3daeb2846bf9c43686
//		 String plain = "1719"; // 4864c9c333b17daf588a78c1a9015862
//		 String plain = "6216"; // e3be86a850dca8b7fed9b54158cf3572
//		 String plain = "!IBC20010415"; // 9e8c090a8c7a2a484477c5abcfd8fa67
//		 String plain = "!#$Yh1577"; // 9e8c090a8c7a2a484477c5abcfd8fa67
//		 String plain = "paul4413<>"; // ea24a019df12707a3e1832cafc3662c2
//		 String plain = "hsy8773**"; // e1bc246cdf7df00edfd86fc49a437504
//		 String plain = "skqhf12@"; // 
//		 String plain = "1111"; // 
//		 String plain = "life5626*"; // 
//		 String plain = "nsmilal2018*"; // 
		 String plain = "757577"; // 

		String result = toolsService.generateKyoEncryptedPassword(plain);
		System.out.println("generated password: " + result);
	}

	@Test
	public void testGenerateKyoEncryptedPasswordList() {

		String[] plainList = { "3205", "6082", "6750", "9321", "2696", "8315", "0272", "8422", "5933", "4598", "9597",
				"3130", "8044", "1405", "4128", "6259", "2433", "6508", "1363", "8309", "4600", "2531", "3450", "2615",
				"5313", "1957", "3489", "3045", "3712", "1720", "7100", "2649", "9571", "2275", "2850", "0708", "8678",
				"4213", "8766", "9687", "8147", "5611", "9558", "1556", "3030", "5984", "9624", "6057", "0971", "6937",
				"0263", "2405", "9114", "4531", "0211", "9686", "7138", "8814", "2140", "9277", "2189", "4398", "1924",
				"2833", "0251", "5166", "8661", "5809", "1729", "8683", "9815", "9654", "1190", "7743", "6189", "9649",
				"7588", "5301", "4127", "2280", "0965", "5327", "2020", "5054", "8640", "8315", "3513", "6274", "1098",
				"0546", "9997", "4027", "2558", "7757", "0863", "3704", "6531", "0832", "0693", "5533", "3378", "4677",
				"7988", "9033", "5386", "5759", "5724", "4624", "4257", "9226", "3163", "9152", "9679", "3215", "0050",
				"6089", "5142" }; // e12c1a24d4a6e91609a3f89a753c9361
		List<Map<String, String>> resultList = new ArrayList<>();
		for (int i = 0; i < plainList.length; i++) {
			String encryptedText = toolsService.generateKyoEncryptedPassword(plainList[i]);
			// System.out.println(plainList[i] +", "+ encryptedText);
			Map<String, String> result = new HashMap<>();
			result.put("plain", plainList[i]);
			result.put("encryption", plainList[i]);

			resultList.add(result);
		}

		for (int i = 0; i < resultList.size(); i++) {
			Map<String, String> tmp = resultList.get(i);
			System.out.println(tmp.get("plain") + "," + tmp.get("encryption"));
		}

	}

	// INSERT INTO `ohjic`.`portal_user` (`user_id`, `user_name`, `jumin`,
	// `secureKey`, `user_passwd`, `birth_year`, `birth_date`, `birth_solar`,
	// `user_zipcode`, `user_address1`, `user_address2`, `user_email`,
	// `position`, `regi_date`, `paster_name`, `email_agree`, `sms_agree`,
	// `admin`, `withdraw`, `point`, `user_address_street`) VALUES
	// ('hanwooricalgar', '김재윤', '', '0', 'c472207ab6bdc021ae67cbe471fcf1ad',
	// '1964', '6', '14', '-', '', '', '', '', '1473145192', '김재윤목사님', '0', '0',
	// '0', '0', '0', '');

	@Test
	public void testBackupMemberImage() {

		// String plain = "1004";
		String plain = "4406"; // c472207ab6bdc021ae67cbe471fcf1ad
		String result = toolsService.generateKyoEncryptedPassword(plain);
		System.out.println("generated password: " + result);
		// assertTrue("18a89831df46bf18809d958047555aaf".equals(result));
	}

	@Test
	public void testGetKyoTableList() {

		int churchCode = 6100;
		Map<Integer, Integer> churchList = new HashMap<>();

		for (int i = 0; i < churchCode; i++) {
			try {
				List<Map<String, Object>> tableList = toolsService.getKyoTableList(i);
				System.out.println("churchCode : " + i + ", tableCount: " + tableList.size());
				churchList.put(i, tableList.size());
			} catch (Exception e) {
				System.out.println("churchCode is not exist");
			}
		}

		/*Set<Integer> keySet = churchList.keySet();
		for (Integer integer : keySet) {
			int tableCount = churchList.get(integer);
			if (tableCount > 0 && tableCount < 107) {
				System.out.println("churchCode : " + integer + ", count: " + churchList.get(integer));
			}
		}
*/
	}

	@Test
	public void testGetKyoTableColumnList() {

		int churchCode = 6100;
		Map<Integer, Integer> churchList = new HashMap<>();

		for (int i = 0; i < churchCode; i++) {
			try {
				String tableName = "member";
				List<Map<String, Object>> tableColumnList = toolsService.getTableColumnList(i, tableName);
				// System.out.println("churchCode : " + i + ", tableColumnCount:
				// " + tableList.size());
				churchList.put(i, tableColumnList.size());
			} catch (Exception e) {
				System.out.println("churchCode is not exist");
			}
		}

		Set<Integer> keySet = churchList.keySet();
		for (Integer integer : keySet) {
			int tableCount = churchList.get(integer);
			if (tableCount != 0 && tableCount != 101) {
				System.out.println("churchCode : " + integer + ", tableColumnCount: " + churchList.get(integer));
			}
		}

	}

	@Test
	public void testRegistMemberGuide() {

		// {1037,1054,1139,1183,1199,1223,1293,130,1331,1337,1362,1372,1388,1433,1446,1482,152,1568,158,1580,1581,163,1685,1690,1700,1708,1725,1775,1796,1811,1899,2005,2018,2019,2112,2113,2115,2151,216,2226,2238,2255,2261,2274,2286,2288,2289,2310,2324,234,2342,2350,2371,2382,2411,2433,2444,245,2478,2503,2509,2510,2512,2539,2547,2588,2590,2623,2629,2631,2638,2664,267,2727,28,2836,2878,2903,2972,2983,3006,3007,3013,3022,3042,3061,3070,3078,3087,3092,3094,3106,3125,3128,3130,3164,3165,3186,3189,3190,3193,3206,3215,3227,3233,3234,3241,3263,3287,3304,3310,3311,3322,3337,3348,3372,3374,3383,3388,3400,3403,3404,3410,3469,3485,3497,3498,3500,351,3522,3524,3525,3527,3529,353,3535,3539,3544,3547,3548,3549,3560,3561,3563,3564,3577,3579,3589,3603,3609,3621,3633,3642,3648,3670,3671,3688,3700,3701,3705,3707,3740,3742,3749,3761,3762,3784,3789,3794,3797,3809,3814,3820,3826,3833,3882,3902,3909,3919,3922,3925,3929,3943,396,3965,3974,3975,3997,4010,4031,4045,4056,4059,4061,4064,4068,4071,4072,408,4080,4086,4093,4094,4097,4108,4116,4121,4133,4150,4184,4190,4199,4213,4217,427,4275,4298,4307,4308,4325,4326,4359,4365,4407,4409,4416,4428,4431,4435,4451,4465,4468,4501,4529,4531,4532,4572,4591,46,4604,4616,4640,4644,4652,4667,4680,4700,4716,4728,4732,4741,4750,476,4762,4772,4793,4794,4815,4822,4831,4834,4835,4864,4878,4884,4889,4915,4920,4929,4959,4960,4981,4983,4995,5015,5031,5072,5078,5080,5125,5151,5153,5155,5160,5180,5199,5200,5227,5233,5235,5245,5254,5272,5276,5277,5280,5284,5287,5290,5305,5328,5339,539,5416,5426,544,5505,5589,565,5703,5750,5774,5780,5807,5809,5814,5818,5839,5846,5909,5930,5977,5986,6,6007,6011,6026,6028,6075,6090,6095,614,636,703,710,748,791,793,800,802,817,902,937,999};
		Integer[] churchCodeList = { 5059, 5228, 6037, 6092 };

		Map<Integer, Integer> reusltList = new HashMap<>();
		for (Integer churchCode : churchCodeList) {
			try {
				int resultCount = toolsService.registMemberGuide(churchCode);
				reusltList.put(churchCode, resultCount);
			} catch (Exception e) {
				// TODO: handle exception
			}

		}

		Set<Integer> keySet = reusltList.keySet();
		for (Integer key : keySet) {
			int resultCount = reusltList.get(key);
			System.out.println("churchCode : " + key + ", resultCount: " + resultCount);

		}

	}

	@Test
	public void testModifyUpdateDateForMemberGuide() {

		Integer[] churchCodeList = { 1037, 1054, 1139, 1183, 1199, 1223, 1293, 130, 1331, 1337, 1362, 1372, 1388, 1433,
				1446, 1482, 152, 1568, 158, 1580, 1581, 163, 1685, 1690, 1700, 1708, 1725, 1775, 1796, 1811, 1899, 2005,
				2018, 2019, 2112, 2113, 2115, 2151, 216, 2226, 2238, 2255, 2261, 2274, 2286, 2288, 2289, 2310, 2324,
				234, 2342, 2350, 2371, 2382, 2411, 2433, 2444, 245, 2478, 2503, 2509, 2510, 2512, 2539, 2547, 2588,
				2590, 2623, 2629, 2631, 2638, 2664, 267, 2727, 28, 2836, 2878, 2903, 2972, 2983, 3006, 3007, 3013, 3022,
				3042, 3061, 3070, 3078, 3087, 3092, 3094, 3106, 3125, 3128, 3130, 3164, 3165, 3186, 3189, 3190, 3193,
				3206, 3215, 3227, 3233, 3234, 3241, 3263, 3287, 3304, 3310, 3311, 3322, 3337, 3348, 3372, 3374, 3383,
				3388, 3400, 3403, 3404, 3410, 3469, 3485, 3497, 3498, 3500, 351, 3522, 3524, 3525, 3527, 3529, 353,
				3535, 3539, 3544, 3547, 3548, 3549, 3560, 3561, 3563, 3564, 3577, 3579, 3589, 3603, 3609, 3621, 3633,
				3642, 3648, 3670, 3671, 3688, 3700, 3701, 3705, 3707, 3740, 3742, 3749, 3761, 3762, 3784, 3789, 3794,
				3797, 3809, 3814, 3820, 3826, 3833, 3882, 3902, 3909, 3919, 3922, 3925, 3929, 3943, 396, 3965, 3974,
				3975, 3997, 4010, 4031, 4045, 4056, 4059, 4061, 4064, 4068, 4071, 4072, 408, 4080, 4086, 4093, 4094,
				4097, 4108, 4116, 4121, 4133, 4150, 4184, 4190, 4199, 4213, 4217, 427, 4275, 4298, 4307, 4308, 4325,
				4326, 4359, 4365, 4407, 4409, 4416, 4428, 4431, 4435, 4451, 4465, 4468, 4501, 4529, 4531, 4532, 4572,
				4591, 46, 4604, 4616, 4640, 4644, 4652, 4667, 4680, 4700, 4716, 4728, 4732, 4741, 4750, 476, 4762, 4772,
				4793, 4794, 4815, 4822, 4831, 4834, 4835, 4864, 4878, 4884, 4889, 4915, 4920, 4929, 4959, 4960, 4981,
				4983, 4995, 5015, 5031, 5072, 5078, 5080, 5125, 5151, 5153, 5155, 5160, 5180, 5199, 5200, 5227, 5233,
				5235, 5245, 5254, 5272, 5276, 5277, 5280, 5284, 5287, 5290, 5305, 5328, 5339, 539, 5416, 5426, 544,
				5505, 5589, 565, 5703, 5750, 5774, 5780, 5807, 5809, 5814, 5818, 5839, 5846, 5909, 5930, 5977, 5986, 6,
				6007, 6011, 6026, 6028, 6075, 6090, 6095, 614, 636, 703, 710, 748, 791, 793, 800, 802, 817, 902, 937,
				999, 5059, 5228, 6037, 6092 };

		Map<Integer, Integer> reusltList = new HashMap<>();
		for (Integer churchCode : churchCodeList) {
			try {
				int resultCount = toolsService.modifyUpdateDateForMemberGuide(churchCode);
				reusltList.put(churchCode, resultCount);
			} catch (Exception e) {
				// TODO: handle exception
			}

		}

		Set<Integer> keySet = reusltList.keySet();
		for (Integer key : keySet) {
			int resultCount = reusltList.get(key);
			System.out.println("churchCode : " + key + ", resultCount: " + resultCount);

		}

	}

	/**
	 * 대시보드의 제목(title) 변경(통일) update dashboard_portlet set title = '이번주 새 등록자'
	 * where name = 'registration_members'; update dashboard_portlet set title =
	 * '이번주 새 환영자' where name = 'reception_members';
	 */

	@Test
	public void testModifyDashboardTitle() {

		int maxChurchCode = 6138;

		for (int i = 0; i < maxChurchCode; i++) {

			try {
				Integer churchCode = i;
				String name = "registration_members";
				String title = "이번주 새 등록자";

				toolsService.modifyDashboardTitleByName(churchCode, name, title);

				name = "reception_members";
				title = "이번주 새 환영자";

				toolsService.modifyDashboardTitleByName(churchCode, name, title);
			} catch (Exception e) {
				System.out.println("This church is not exist..");
			}
		}
	}

	@Autowired
	ChurchUseNumberMapper churchUseNumberMapper;

	@Test
	public void testGetChurchListDetail() {

		List<Map<String, Object>> result = toolsService.getChurchListDetail();

		for (Map<String, Object> churchDatail : result) {

			String churchCode = String.valueOf(churchDatail.get("churchCode"));
			BigDecimal kyoNumber = (BigDecimal) churchDatail.get("교인");
			String churchName = (String) churchDatail.get("churchName");
			// Integer limit = churchDatail.containsKey("limit") ? (int)
			// churchDatail.get("limit"):null;

			ChurchUseNumber churchUseNumber = new ChurchUseNumber();
			churchUseNumber.setChurchCode(churchCode);
			churchUseNumber.setKyoNumber(kyoNumber.intValue());
			churchUseNumber.setChurchName(churchName);
			// churchUseNumber.setLimit(limit);

			churchUseNumberMapper.insertSelective(churchUseNumber);

		}
		/*
		 * String resultJson = new Gson().toJson(result);
		 * 
		 * 
		 * BufferedWriter writer = null; try { writer = new BufferedWriter( new
		 * FileWriter( "C:\\Users\\ohjic\\Documents\\ohjic_stat"));
		 * writer.write( resultJson);
		 * 
		 * } catch ( IOException e) {
		 * 
		 * } finally { try { if ( writer != null) writer.close( ); } catch (
		 * IOException e) {
		 * 
		 * } }
		 */
	}

	@Test
	public void testModifyMemberCardView() {

		Integer limitChurchCode = 6118;

		for (int i = 0; i < limitChurchCode; i++) {
			Integer churchCode = i;

			try {

				List<Map<String, Object>> viewList = toolsService.getMemberCardViewListByChurchCode(churchCode);

				for (Map<String, Object> view : viewList) {
					String viewColumn = (String) view.get("view_column");
					Long viewNo = (Long) view.get("view_no");
					System.out.println("before: " + viewColumn);

					try {
						JSONObject json = new JSONObject(viewColumn);
						String[] removeColumList = { "guide", "guide2", "guide_phone", "guide_relation" };

						for (String removeColum : removeColumList) {
							if (json.has(removeColum)) {
								json.remove(removeColum);
							}
						}

						view.put("view_column", json.toString());
						boolean result = toolsService.modifyMemberCardView(churchCode, view);

						System.out.println("churchCode: " + churchCode + ", view_no:" + viewNo + ", result: " + result);
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		}
	}

	@Test
	public void testGetManagerById() {

		String managerId = "young1960";
		List<Integer> resultList = new ArrayList<>();

		for (int i = 0; i < 6170; i++) {
			try {
				Integer churchCode = i;
				Map<String, Object> manager = toolsService.getManagerById(churchCode, managerId);
				if (manager != null) {
					System.out.println("managerId는  churchCode가 " + i + "에 속해 있습니다.");
					resultList.add(churchCode);
				}
			} catch (Exception e) {

			}
		}

		for (Integer result : resultList) {
			System.out.println("managerId는  churchCode가 " + result + "에 속해 있습니다.");
		}
	}

	@Test
	public void testGetChurchManagerByChurchUseNumber() {

		List<Map<String, Object>> churchCodeList = toolsService.getChurchManagerByChurchUseNumber(2000);

		List<Map<String, Object>> resultList = new ArrayList<>();

		for (Map<String, Object> church : churchCodeList) {

			try {

				Integer churchCode = Integer.parseInt((String) church.get("church_code"));
				System.out.println("churchCode: " + churchCode);
				Map<String, Object> superAdmin = toolsService.getSuperAdminByChurchCode(churchCode);

				superAdmin.put("version", church.get("version").toString());
				superAdmin.put("status", church.get("status").toString());
				superAdmin.put("church_code", church.get("church_code").toString());
				superAdmin.put("church_name", church.get("church_name").toString());

				resultList.add(superAdmin);

			} catch (Exception e) {

			}

		}

		String fileName = "C:\\Users\\ohjic\\Documents\\ohjic_super_admin.txt";
		toJsonFile(resultList, fileName);

	}

	private void toJsonFile(Object resultList, String fileName) {
		String resultJson = new Gson().toJson(resultList);

		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter(fileName));
			writer.write(resultJson);

		} catch (IOException e) {

		} finally {
			try {
				if (writer != null)
					writer.close();
			} catch (IOException e) {

			}
		}
	}

	@Test
	public void testRestistCommonCode() {

		int limitChurchCode = 6181;

		for (int i = 1; i < limitChurchCode; i++) {

			try {
				Integer churchCode = i;
				String name = "전화심방";
				// List<Map<String, String>> commonCodeList =
				// toolsService.getCommonCodeByName(churchCode, name);

				// if(commonCodeList.size() == 0 ) {
				// String ord = String.valueOf(commonCodeList.get(0).get("ord")
				// + 1);
				// Map<String,String> telVisit = new HashMap<>();
				// telVisit.put("depth1_name", name);
				// telVisit.put("depth2_name", "");
				// telVisit.put("depth", "1");
				// telVisit.put("name", name);
				// telVisit.put("kind", "visit");
				// telVisit.put("level", "0");
				// boolean registResult =
				// toolsService.registCommonCode(churchCode, telVisit );
				boolean modifyResult = toolsService.modifyCommonCodeDepth(churchCode, name);
				// }

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

	/**
	 * // Integer churchCode = 10181; // Integer churchCode = 1690; // Integer
	 * churchCode = 3986; // 목동반석교회 // Integer churchCode = 6216; // 하늘빛우리교회 //
	 * Integer churchCode = 2196; // 순복음진주초대교회-2196 // Integer churchCode =
	 * 6318; // 산성교회 6318 // Integer churchCode = 4308; // 높은뜻푸른교회-4308 //
	 * Integer churchCode = 5059; // 일심교회-5059 // Integer churchCode = 4995; //
	 * 반포교회 4995, banpo2 // Integer churchCode = 6432; // 용호남교회 6432, // Integer
	 * churchCode = 6328; // 영복교회 6328, yb2 // Integer churchCode = 6430; //
	 * 해운대제일교회 6430, hjeil2 // Integer churchCode = 2005; // 대길교회-2005, daegil3
	 * // Integer churchCode = 6329; // 서문교회 6329 // Integer churchCode = 1383;
	 * // 종암교회(1383) // Integer churchCode = 6332; // 만남의교회-6332 // Integer
	 * churchCode = 6370; // 성빈교회-6370 // Integer churchCode = 6326; //
	 * 정원교회-6326 // Integer churchCode = 6344; // 서북교회-6344, seobukchurch2 //
	 * Integer churchCode = 6335; // 수원명성교회-6335, swms2 // Integer churchCode =
	 * 6335; // 주님앞에제일교회-6346, jeil2033 // Integer churchCode = 6235; //
	 * 안양중앙교회-6235, ajch2 // Integer churchCode = 6235; // 금성교회-6325, keumsung2
	 * // Integer churchCode = 6389; // 현암교회-6389, hyunam2 // Integer churchCode
	 * = 6202; // 헤븐리터치-6202, htm06911 // Integer churchCode = 5561; //
	 * 연동교회-5561, ydplay2 // Integer churchCode = 3922; // 남군산교회-3922, ngs2 //
	 * Integer churchCode = 6537; // 이루는교회-6537, irnch2 // Integer churchCode =
	 * 6251; // 동은교회-6251, dongeunpeople1 // Integer churchCode = 4437; //
	 * 주내힘교회-4437, junahim_oc // Integer churchCode = 6431; // 성심교회 6431,
	 * sungsim_oc // Integer churchCode = 6060; // 시민교회-6060, simin // Integer
	 * churchCode = 2350; // 성현교회-2350, seonghyunmc_oc // Integer churchCode =
	 * 6518; // 군산사랑의교회-6518, gunsansarang_oc // Integer churchCode = 6289; //
	 * 미담교회-6289, midam_oc // Integer churchCode = 6402; // 군산세광교회-6402, kssk_oc
	 * // Integer churchCode = 6661; // 검단중앙교회-6661 // Integer churchCode =
	 * 6173; // 함께하는교회-6173 // Integer churchCode = 6587; // 신현교회-6587 //
	 * Integer churchCode = 6793; // 부평남부교회 6793, npch_oc // Integer churchCode
	 * = 6754; // 대흥교회-6754, daeheung_oc // Integer churchCode = 2836; // 수지방주교회
	 * 2836 sjbj_oc // Integer churchCode = 5375; // 에덴교회-5375, gasomun_oc //
	 * Integer churchCode = 5375; // 에덴교회-5375, gasomun_oc
	 * 
	 */
	@Test
	public void testAddGoodsAttCheck() {

		// Integer churchCode = 6734; // 대전제자들교회 6734, jejas_oc
		// Integer churchCode = 6425; // 동암교회-6425, dongamchurch_oc
		// Integer churchCode = 6503; // 유성교회-6503, yskmc_oc
		// Integer churchCode = 6506; // 부산제일감리교회 6506
		// Integer churchCode = 6319; // 서울중앙교회 6319, seouljungang_oc
		// Integer churchCode = 6838; // 대전예은교회 6838, yeeunch_oc
		// Integer churchCode = 6843; // 수원동산교회 6843, dsansarang_oc
		Integer churchCode = 6786; // 성암교회 6786, sa1967_oc

		GOODS goods = GOODS.att_check;
		String domain = "sa1967_oc";
		boolean result = toolsService.addGoods(churchCode, domain, goods);

		assertTrue(result);

	}

	@Test
	public void testAddGoodsSmartCall() {

		// Integer churchCode = 3986; // 목동반석교회
		// Integer churchCode = 4995; // 반포교회-4995
		// Integer churchCode = 479; // 명성교회교회학교-479
		// Integer churchCode = 6431; // 성심교회 6431
		// Integer churchCode = 2350; // 성현교회-2350
		// Integer churchCode = 6430; // 해운대제일교회-6430
		// Integer churchCode = 6289; // 미담교회-6289
		// Integer churchCode = 6754; // 대흥교회-6754
		// Integer churchCode = 6672; // 영광교회-6672
		// Integer churchCode = 601; // 해돋는교회-601
		// Integer churchCode = 6778; // 예일교회 6778
		// Integer churchCode = 6817; // 엘림교회 6817
		// Integer churchCode = 6811; // 금천선교교회-6811
		// Integer churchCode = 6838; // 대전예은교회-6838
		// Integer churchCode = 6778; // 예일교회-6778
		// Integer churchCode = 6851; // 도암교회 6851
		// Integer churchCode = 7310; // 에덴교회-7310
		// Integer churchCode = 7276; // 신천교회-7276
		// Integer churchCode = 7304; // 낮은마음교회-7304
		// Integer churchCode = 7313; // 생명나무교회 7313

		// Integer churchCode = 7607; //천안중부교회 7607
		// Integer churchCode = 7329; //CAM대학선교회 7329
		// Integer churchCode = 7345; //하늘누림교회 7345
//		Integer churchCode = 7368; // 스피릿교회-7368
//		Integer churchCode = 7338; // 성산교회-7338
//		Integer churchCode = 4325; // 대광교회-4325
//		Integer churchCode = 7343; // 드림교회-7343
//		Integer churchCode = 7424; // 북삼제일교회-7424
		Integer churchCode = 4411; // 수원순복음교회-4411




		GOODS goods = GOODS.smart_call;
		String domain = "";
		boolean result = toolsService.addGoods(churchCode, domain, goods);

		assertTrue(result);

	}

	@Test
	public void test소천2depth() {

		List<Map<String, Object>> exsistedList = new ArrayList<>();
		List<Map<String, Object>> resultList = new ArrayList<>();

		String groupName = "소천";

		for (int i = 6210; i < 6293; i++) {
			Integer churchCode = i;
			try {
				Map<String, Object> result = toolsService.getCgroupByGroupName(churchCode, groupName);
				// result.put("churchCode", String.valueOf(churchCode));

				// System.out.println(result.toString());
				if (result != null) {
					result.put("churchCode", String.valueOf(churchCode));
					exsistedList.add(result);
				} else {
					Map<String, Object> tmp = null;
					if (toolsService.registSocheon(churchCode)) {
						tmp = new HashMap<>();
						tmp.put("churchCode", churchCode);
						resultList.add(tmp);
					}
				}

			} catch (Exception e) {

			}
		}

		String fileName = "C:\\Users\\ohjic\\Documents\\ohjic_exsited_socheon.txt";
		toJsonFile(exsistedList, fileName);

		String fileName2 = "C:\\Users\\ohjic\\Documents\\ohjic_add_socheon.txt";
		toJsonFile(resultList, fileName2);
	}

	@Test
	public void test소천1depth() {

		List<Map<String, Object>> exsistedList = new ArrayList<>();
		List<Map<String, Object>> resultList = new ArrayList<>();

		String groupName = "소천";

		for (int i = 0; i < 6300; i++) {
			Integer churchCode = i;
			try {
				Map<String, Object> result = toolsService.getCgroupByGroupName(churchCode, groupName);
				// result.put("churchCode", String.valueOf(churchCode));

				// System.out.println(result.toString());
				if (result != null) {
					result.put("churchCode", String.valueOf(churchCode));
					exsistedList.add(result);
				} else {
					Map<String, Object> tmp = null;
					if (toolsService.registSocheon1(churchCode)) {
						tmp = new HashMap<>();
						tmp.put("churchCode", churchCode);
						resultList.add(tmp);
					}
				}

			} catch (Exception e) {

			}
		}

		String fileName = "C:\\Users\\ohjic\\Documents\\ohjic_exsited_socheon.txt";
		toJsonFile(exsistedList, fileName);

		String fileName2 = "C:\\Users\\ohjic\\Documents\\ohjic_add_socheon.txt";
		toJsonFile(resultList, fileName2);
	}

	@Autowired
	private NextYearSettingService nextYearSettingService;

	@Test
	public void testGetEndDateForGroupLog() {

		List<Map<String, Object>> exsistedList = new ArrayList<>();
		List<Object> resultList = new ArrayList<>();

		List<Churchinfo> churchInfoList = nextYearSettingService.getChurchInfoList();

		for (Churchinfo churchInfo : churchInfoList) {
			Integer churchCode = churchInfo.getChurchCode();

			try {
				Integer year = 2016;
				List<Map<String, Object>> result = toolsService.getEndDateForGroupLog(churchCode, year);

				if (result != null) {
					resultList.add(churchCode);
				}

			} catch (Exception e) {

			}
		}

		for (Churchinfo churchInfo : churchInfoList) {
			Integer churchCode = churchInfo.getChurchCode();

			try {
				Integer year = 2016;
				int result = toolsService.modifyEndDateForGroupLog(churchCode, year);

				if (result > 0) {
					resultList.add(churchCode);
				}

			} catch (Exception e) {

			}
		}

		String fileName2 = "C:\\Users\\ohjic\\Documents\\ohjic_kgrou_enddate.txt";
		toJsonFile(resultList, fileName2);
	}

	@Test
	public void testModifyEndDateForGroupLog() {

		List<Map<String, Object>> exsistedList = new ArrayList<>();
		List<Object> resultList = new ArrayList<>();

		List<Churchinfo> churchInfoList = nextYearSettingService.getChurchInfoList();

		for (Churchinfo churchInfo : churchInfoList) {
			Integer churchCode = churchInfo.getChurchCode();

			try {
				Integer year = 2016;
				int result = toolsService.modifyEndDateForGroupLog(churchCode, year);

				if (result > 0) {
					resultList.add(churchCode);
				}

			} catch (Exception e) {

			}
		}

		String fileName2 = "C:\\Users\\ohjic\\Documents\\ohjic_kgrou_enddate.txt";
		toJsonFile(resultList, fileName2);
	}

	@Test
	public void test한글이름_영문이름() {

		List<List<Map<String, Object>>> resultList = new ArrayList<>();

		for (int i = 0; i < 6210; i++) {
			Integer churchCode = i;
			try {
				List<Map<String, Object>> result = toolsService.getMemberNameHanAndEnCount(churchCode);

				resultList.add(result);
				// for (Map<String, Object> map : result) {
				//
				// System.out.println("han: "+ (int)map.get("name"));
				// System.out.println("en: "+ (int)map.get("name"));
				// //if((int)map.get("name") >0 ||(int)map.get("name")>0) {
				// map.put("churchCode", churchCode);
				// resultList.add(map);
				// //}
				//
				// }

			} catch (Exception e) {

			}
		}

		String fileName = "C:\\Users\\ohjic\\Documents\\ohjic_han_en_member_list.txt";
		toJsonFile(resultList, fileName);
	}

	@Test
	public void testGetCgroupByChurch() {
		Integer churchCode = 6;
		List<Cgroup> cGroupList = toolsService.getCgroupByChurch(churchCode);

		assertTrue(cGroupList.size() == 30);
	}

	@Test
	public void testGetCgroupByAllChurch() {
		List<Churchinfo> churchInfoList = nextYearSettingService.getChurchInfoList();

		List<Cgroup> cGroupListAll = new ArrayList<>();
		Set<String> cGroupNameSet = new HashSet<>();
		for (Churchinfo churchinfo : churchInfoList) {
			Integer churchCode = churchinfo.getChurchCode();
			try {
				List<Cgroup> cGroupList = toolsService.getCgroupByChurch(churchCode);
				cGroupListAll.addAll(cGroupList);

				for (Cgroup cgroup : cGroupList) {
					cGroupNameSet.add(cgroup.getGroupname());
				}
			} catch (Exception e) {

			}
		}

		String fileName = "C:\\Users\\ohjic\\Documents\\ohjic_cGroup_list.txt";
		toJsonFile(cGroupNameSet, fileName);

		assertTrue(cGroupNameSet.size() > 0);
	}

	@Test
	public void testModifyPartnerNameOfFinmemberByDeath() {

		List<Churchinfo> churchInfoList = nextYearSettingService.getChurchInfoList();
		List<Object> resultList = new ArrayList<>();

		for (Churchinfo churchinfo : churchInfoList) {

			Kyo kyo = new Kyo();
			Integer churchCode = churchinfo.getChurchCode();
			kyo.setChurchCode(churchCode);

			try {
				int result = toolsService.modifyPartnerNameOfFinmemberByDeath(kyo);
				if (result > 0) {
					resultList.add(churchCode);
				}
			} catch (Exception e) {

			}

		}

		String fileName = "C:\\Users\\ohjic\\Documents\\ohjic_finMember_partner_list.txt";
		toJsonFile(resultList, fileName);

	}

	/**
	 * 교회 관리자에서 삭제된 관리자를 church_user에서도 일괄삭제시킨다.
	 */
	@Test
	public void testRemoveChurchUserByDeletedManager() {

		List<Churchinfo> churchInfoList = nextYearSettingService.getChurchInfoList();
		List<Object> resultList = new ArrayList<>();

		for (Churchinfo churchinfo : churchInfoList) {

			Kyo kyo = new Kyo();
			Integer churchCode = churchinfo.getChurchCode();
			kyo.setChurchCode(churchCode);

			try {
				int result = toolsService.removeChurchUserByRemovedManager(kyo);
				if (result > 0) {
					resultList.add(churchCode);
				}
			} catch (Exception e) {

			}

		}

		String fileName = "C:\\Users\\ohjic\\Documents\\ohjic_deleted_church_userlist.txt";
		toJsonFile(resultList, fileName);

	}

	/**
	 * member 테이블과 finMember의 성도이름 이 다른 경우 같도록 변경
	 */
	@Test
	public void testModifyFimMemberNameByMemberName1() {

		List<Churchinfo> churchInfoList = nextYearSettingService.getChurchInfoList();
		List<Object> resultList = new ArrayList<>();

		Kyo kyo = new Kyo();
		Integer churchCode = 3094;
		kyo.setChurchCode(churchCode);

		try {
			int result = toolsService.modifyFimMemberNameByMemberName(kyo);
			if (result > 0) {
				resultList.add(churchCode);
			}
		} catch (Exception e) {

		}

		String fileName = "C:\\Users\\ohjic\\Documents\\ohjic_modified_userlist.txt";
		toJsonFile(resultList, fileName);

	}

	/**
	 * member 테이블과 finMember의 성도이름 이 다른 경우 같도록 변경
	 */
	@Test
	public void testModifyFimMemberNameByMemberName() {

		List<Churchinfo> churchInfoList = nextYearSettingService.getChurchInfoList();
		List<Object> resultList = new ArrayList<>();

		for (Churchinfo churchinfo : churchInfoList) {

			Kyo kyo = new Kyo();
			Integer churchCode = churchinfo.getChurchCode();
			kyo.setChurchCode(churchCode);

			try {
				int result = toolsService.modifyFimMemberNameByMemberName(kyo);
				if (result > 0) {
					resultList.add(churchCode);
				}
			} catch (Exception e) {

			}

		}

		String fileName = "C:\\Users\\ohjic\\Documents\\ohjic_modified_userlist.txt";
		toJsonFile(resultList, fileName);

	}
	
	
	@Test
	public void testLatestChristening() {
		
		Integer churchCode = 3227;
		Kyo kyo = new Kyo(churchCode);
		toolsService.getLatestChrstening(kyo) ;
	}
	
	@Test
	public void modifyMemberImageByFile() {
		
//		Integer churchCode = 7657;
		Integer churchCode = 7905;
		
//		String dir = "C:\\filepath";
		String dir = "C:\\Users\\ohjic\\Desktop\\id_photo";
		boolean result = toolsService.modifyMemberImageByFile(churchCode, dir);
		
		assertTrue(result);
	}
	
	
	@Test
	public void modifyMemberImageByFileName() {
		
		Integer churchCode = 5195;
		
		String dir = "C:\\Users\\ohjic\\Desktop\\교적용 사진";
		boolean result = toolsService.modifyMemberImageByFileName(churchCode, dir);
		
		assertTrue(result);
	}
	
	@Autowired
	ChurchInfoService churchInfoService;
	
	@Test
	public void testSyncMemberCantacts() {
		
		boolean result = true;
		
		List<Churchinfo> churchList = churchInfoService.getChurchList();
		
		for (Churchinfo churchinfo : churchList) {
			
			try {
				
				Integer churchCode = churchinfo.getChurchCode();
				Kyo kyo = new Kyo();
				kyo.setChurchCode(churchCode);
				toolsService.syncMemberCantacts(kyo);		
				
				
			}catch (Exception e) {
				// TODO: handle exception
				result = false;
			}
			
		}

		
		assertTrue(result);
	}
}
