/**
 * 
 */
package org.ohjic.flower.web;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Locale;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.ohjic.flower.model.User;
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

	@Autowired
	private UserService userServcie;
	
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
	      
		  String imgName = "";
		  String saveName = null;
		  
		  System.out.println("user: " + id);
		  
		  MultipartFile multipartFile = user.getMultipartFile();
		  imgName = multipartFile.getOriginalFilename();
		  System.out.println("imgName: "+imgName);
		  
		  if(imgName != ""){
			  
			 String realPath = request.getRealPath("resources/img");
			 logger.info("method realPath = {}", realPath);
			 
			 long nowTime = System.currentTimeMillis();
			 saveName = nowTime + imgName;
			 
			 File origin_img = new File(realPath + "/" + saveName);
			 multipartFile.transferTo(origin_img);
			 
			 	//// create thumbnail image/////////
				BufferedImage original_buffer_img = ImageIO.read(origin_img);
				BufferedImage thumb_buffer_img = new BufferedImage(90, 100, BufferedImage.TYPE_3BYTE_BGR);
				Graphics2D graphic = thumb_buffer_img.createGraphics();
				graphic.drawImage(original_buffer_img, 0, 0, 90, 100, null);
	
				File thumb_file = new File(realPath + "/thumb_" + saveName);
				ImageIO.write(thumb_buffer_img, "jpg", thumb_file);
		  }
		  
		  user.setUserId(id);
		  user.setImgName(saveName);
		  
	      boolean flag = userServcie.regist(user);
	      
	      System.out.println("flag: "+ flag);

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
	      
	      return "update";
	  }
	  
	  
	  
	  /*
	   * 사진 미리보기 팝업
	   */
	  @RequestMapping(value = "/preImg", method = RequestMethod.GET)
	  public String preImg(HttpServletRequest request, Model model,
	          HttpSession session) {
	      logger.info("id = {}", session.getAttribute("user"));
	      String userId = (String)session.getAttribute("user");
	      
//	      User user = new User();
//	      user.setUserId(userId);
	      
	      
	      
	      User user2 = userServcie.getUser(userId);
	      
	      System.out.println("user2.getUserId: "+user2.getUserId());
	      System.out.println("user2.getImgName: "+user2.getImgName());
	      
	      model.addAttribute("user2", user2);
	      
	      return "preImg";
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
