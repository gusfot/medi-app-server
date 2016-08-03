/**
 * 
 */
package org.ohjic.flower.web;

import java.io.FileInputStream;
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
import javax.swing.text.View;

import org.apache.poi.hssf.model.InternalWorkbook;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.ohjic.flower.model.Board;
import org.ohjic.flower.model.Image;
import org.ohjic.flower.model.User;
import org.ohjic.flower.service.ExcelService;
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
	private ImageService imageService;
    @Autowired
   	private ExcelService excelService;
    
	
    
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
	  public String update(Model model, HttpSession session) {
	      logger.info("id = {}", session.getAttribute("user"));
	      
	      String userId = (String)session.getAttribute("user");
	      
	      User user2 = userServcie.getUser(userId);
	      Image img2 = imageService.getImage(userId);
	      
	      model.addAttribute("user2", user2);
	      model.addAttribute("img2", img2);
	      
	      return "update";
	  }
	  
	  
	  @RequestMapping(value = "/updateOk", method = RequestMethod.POST)
	  public @ResponseBody ModelAndView updateOk(@ModelAttribute("user") User user, MultipartHttpServletRequest multi) throws Exception  {
		  
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
	  @RequestMapping(value = "/preView", method = RequestMethod.GET)
	  public String preView(@RequestParam(value="img") String img, HttpServletRequest request, Model model,
	          HttpSession session) {
		  
	      model.addAttribute("img", img);
	      
	      return "preView";
	  }
	  
	  
	  /*
	   * 엑셀 업로드
	   */
	  @RequestMapping(value = "/excelUpload", method = RequestMethod.POST)
	  public ModelAndView excelUpload(HttpServletRequest request, Model model, MultipartHttpServletRequest multi) throws IOException {
		  
		  boolean flag = false;
		  
		  MultipartFile file = null;
		  ArrayList<Board> list = null;
		  
		  file = multi.getFile("excelUpload");
		  flag = excelService.excelUpload(file, request);
		  
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
	   * 엑셀 서버에 저장
	   */
//	  @RequestMapping(value = "/excelDownload", method = RequestMethod.GET)
//	  public String excelDownload() throws Exception {
//		  
//		  boolean flag = false;
//		  
//		  flag = excelService.excelDownload();
//		  
//		  if(flag == true){
//			  return "success";  
//		  }else {
//			  return "fail";
//		  }
//	      
//	  }
	  
	  
	  /*
	   * 엑셀 다운로드
	   */
	  @RequestMapping(value = "/excelDownload", method = RequestMethod.GET)
	  public GenericExcelView excelDownload(@RequestParam Map<String, String> params,
				Map<String, Object> modelMap) throws Exception {
		  
		  List<String> colName = new ArrayList<String>();
			colName.add("1번");
			colName.add("2번");
			colName.add("3번");
			colName.add("4번");
			colName.add("5번");

			List<String[]> colValue = new ArrayList<String[]>();

			String[] arr1 = { "11111", "22222", "33333", "44444", "55555" };
			String[] arr2 = { "aaaaa", "bbbbb", "ccccc", "ddddd", "eeeee" };
			String[] arr3 = { "가가가", "나나나", "다다다", "라라라", "마마마" };

			colValue.add(arr1);
			colValue.add(arr2);
			colValue.add(arr3);
			
			modelMap.put("excelName", "test");
			modelMap.put("colName", colName);
			modelMap.put("colValue", colValue);
		  
		  return new GenericExcelView();
	      
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
