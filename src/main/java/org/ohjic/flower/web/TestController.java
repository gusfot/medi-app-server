/**
 * 
 */
package org.ohjic.flower.web;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.ohjic.flower.model.Image;
import org.ohjic.flower.model.User;
import org.ohjic.flower.service.ImageService;
import org.ohjic.flower.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * 메인 controller
 * @author gusfot
 *
 */
//@RequestMapping("")
@Controller
public class TestController {
	
	private static final Logger logger = LoggerFactory.getLogger(TestController.class);
	
	// 실제 파일 업로드 경로(로컬)
//    private final String UPLOAD_PATH = "D:\\javaProject\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\pilot\\resources\\uploadImg"; 
    // 실제 파일 업로드 경로(운영)
//    private final String UPLOAD_PATH = PropertyHelper.getPropertyValue("system.upload.root", "");
    
    @Autowired
	private UserService userServcie;
    @Autowired
	private ImageService imageServcie;
	
    
	@RequestMapping(value = {"/","/index"}, method = RequestMethod.GET)
    public String home(Locale locale, Model model) {
        
        return "login";
    }
    
	@RequestMapping(value = "/loginOk", method = RequestMethod.GET)
	public String login(
			Model model,
			HttpSession session) {
		logger.info("id = {}", session.getAttribute("user"));
		
		return "main";
	}
  
	  @RequestMapping(value = "/insert", method = RequestMethod.GET)
	  public String insert(
	          Model model,
	          HttpSession session) {
	      logger.info("id = {}", session.getAttribute("user"));
	      
	      return "insert";
	  }
	  
	  /*
	   * 화원가입
	   */
	  @RequestMapping(value = "/insertOk", method = RequestMethod.POST)
	  public void insertOk(HttpServletRequest request, HttpServletResponse response, 
			  @ModelAttribute User user, @RequestParam(value="userId",defaultValue="admin")String id) 
			  throws IllegalStateException, IOException {
	      
		  user.setUserId(id);
		  
	      boolean flag = userServcie.regist(user);
	      
	      logger.info("flag: "+ flag);

			if(flag==true){
				response.sendRedirect("success");
			}else{
				response.sendRedirect("fail");
			}
	  }
	  
	  
	  @RequestMapping(value = "/update", method = RequestMethod.GET)
	  public String update(
	          Model model,
	          HttpSession session) {
	      logger.info("id = {}", session.getAttribute("user"));
	      
	      String userId = (String)session.getAttribute("user");
	      
	      User user2 = userServcie.getUser(userId);
	      Image img2 = imageServcie.getImage(userId);
	      
	      model.addAttribute("user2", user2);
	      model.addAttribute("img2", img2);
	      
	      return "update";
	  }
	  
	  
	  @RequestMapping(value = "/updateOk", method = RequestMethod.POST)
	  public @ResponseBody ModelAndView test(@ModelAttribute("user") User user, MultipartHttpServletRequest multi) throws Exception  {
		  
		  logger.info("[pilot] TestController.test >>>>>>>>>>> ");
		  MultipartFile pFile = null;
		  List<MultipartFile> sFile = null;
		  
		  pFile = multi.getFile("profileFile");
		  sFile = (List<MultipartFile>) multi.getFiles("storeFile");
		  logger.info("[pilot] file >>>>>>>>>>> " + pFile );
		  logger.info("[pilot] file >>>>>>>>>>> " + sFile );
		  
		  String id = multi.getParameter("userId");
		  logger.info(">>>>>>>>>>>>. user.getUserId:" + user.getUserId());

		  user.setUserId(id);
		  
		  boolean flag = userServcie.modifyUser(user, pFile, sFile); // fileupload 함수는 파일저장만 하고 파일이름 리턴하는 함수
		  
		  logger.info("flag: "+ flag);
		  
		  ModelAndView mav = new ModelAndView();
		  
		  if(flag == true){
			  mav.setViewName("/success");
		  }
		  else{
			  mav.setViewName("/fail");
		  }
		  
		  return mav;
		  
	  }
	  
	  
	  /*
	   * 사진 미리보기 팝업
	   */
	  @RequestMapping(value = "/preImg", method = RequestMethod.GET)
	  public String preImg(@RequestParam(value="img") String img, HttpServletRequest request, Model model,
	          HttpSession session) {
		  
	      model.addAttribute("img", img);
	      
	      return "preImg";
	  }
	  
	  /*
	   * 엑셀 다운로드
	   */
	  @RequestMapping(value = "/excelDownload", method = RequestMethod.GET)
	  public String excelDownload(HttpServletRequest request, Model model, HttpSession session) throws Exception {
		  
		  int flag = 0;
		  //임의의 VO가 되주는 MAP 객체
		  Map<String, Object>map = null;
		  //가상 DB조회후 목록을 담을 LIST 객체
		  ArrayList<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		  ArrayList<String> columnList = new ArrayList<String>();
		  //DB조회후 데이터를 담았다는 가상의 데이터
		  for(int i=0; i<10; i++){
			  map = new HashMap<String,Object>();
			  map.put("seq", i+1);
			  map.put("title", "제목이다"+i);
			  map.put("content", "내용입니다"+i);
			  list.add(map);
		  }
		  //MAP의 KEY값을 담기위함
		  if(list != null &&list.size() > 0){
			  //LIST의 첫번째 데이터의 KEY값만 알면 되므로
			  Map<String,Object> m=list.get(0);
			  //MAP의 KEY값을 columnList객체에 ADD
			  for(String k : m.keySet()){
				  columnList.add(k);
			  }
		  }
		  //1차로 workbook을 생성
		  HSSFWorkbook workbook = new HSSFWorkbook();
		  //2차는 sheet생성
		  HSSFSheet sheet = workbook.createSheet("시트명");
		  //엑셀의 행
		  HSSFRow row = null;
		  //엑셀의 셀
		  HSSFCell cell = null;
		  //임의의 DB데이터 조회
		  if(list != null && list.size() > 0){
			  int i=0;
			  for(Map<String,Object> mapobject : list){
				  //시트에 하나의 행을 생성한다(i 값이 0이면 첫번째 줄에 해당)
				  row = sheet.createRow((short)i);
				  i++;
				  if(columnList != null && columnList.size() > 0){
					  for(int j=0; j<columnList.size(); j++){
						  //생성된 row에 컬럼을 생성한다
						  cell=row.createCell(j);
						  //map에 담긴 데이터를 가져와 cell에 add한다
						  cell.setCellValue(String.valueOf(mapobject.get(columnList.get(j))));
					  }
				  }
			  }
		  }
		  long x = System.currentTimeMillis();
		  FileOutputStream fileoutputstream = new FileOutputStream("D:\\excelFile\\keon_"+x+".xls");
		  //파일을 쓴다
		  workbook.write(fileoutputstream);
		  //필수로 닫아주어야함
		  fileoutputstream.close();
		  logger.info(">>>>>>>>>>>>>> 엑셀파일 생성 성공");
		  flag = 1;
		  
		  if(flag == 1){
			  return "success";  
		  }else {
			  return "fail";
		  }
	      
	  }
	  
	  
	  /*
	   * 엑셀 업로드
	   */
	  @RequestMapping(value = "/excelUpload", method = RequestMethod.GET)
	  public String excelUpload(HttpServletRequest request, Model model, HttpSession session) {
		  
		  int flag = 0;
		  
		  if(flag == 1){
			  return "success";  
		  }else {
			  return "fail";
		  }
	      
	  }
	  
	  
	  
  
    @ResponseBody
    @RequestMapping(value = "/jsonLogin", method = RequestMethod.POST)
    public String jsonLogin(
            @RequestParam("id")String id,
            @RequestParam("password")String password,
            Model model,
            HttpSession session) {
        logger.info("id = {}", id);
        logger.info("password = {}", password);
        
        session.setAttribute("user", id);
        
        Object obj = new Object();
        List<Object> list = null;

		model.addAttribute("list", list);
	    
	    return "{\"list\":null}";
    }
    
    @RequestMapping(value = "/sub")
    public String sub(
            Model model) {
        return "sub";
    }
    
    @RequestMapping(value = "/logout")
    public String logout(
            Model model,
            HttpSession session) {
            
        session.setAttribute("user", null);
        session.invalidate();
        
        
        return "login";
    }
    
    /*
	 * 화원가입 성공
	 */
    @RequestMapping(value = "/success")
    public String success() {
        return "success";
    }
    
    /*
	 * 화원가입 실패
	 */
    @RequestMapping(value = "/fail")
    public String fail() {
        return "fail";
    }
	
}
