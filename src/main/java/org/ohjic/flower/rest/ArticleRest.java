package org.ohjic.flower.rest;

import org.ohjic.flower.exception.common.ResponseCode;
import org.ohjic.flower.model.Article;
import org.ohjic.flower.rest.common.RestResponse;
import org.ohjic.flower.service.ArticleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ArticleRest {
	private static final Logger logger = LoggerFactory.getLogger(AdminRest.class);
	
	@Autowired
	ArticleService articleService;
	
//	@RequestMapping(value = {"/rest/article/articleAll"}, method=RequestMethod.POST, produces = "application/json")
//	public @ResponseBody Object article() {
//		
//	}
	
	@RequestMapping(value = {"/rest/article/regist"}, method=RequestMethod.POST, produces = "application/json")
	public @ResponseBody Object article(
			@RequestParam("writer")String writer,
			@RequestParam("title")String title,
			@RequestParam("content")String content,
			Model model) {
		
		logger.info("/admin/article 진입 체크");
		
		Article article = new Article();
		article.setWriter(writer);
		article.setTitle(title);
		article.setContent(content);
		
		ResponseCode responseCode = ResponseCode.SUCCESS; // 디폴트로 성공 ResponseCode를 넣어놓는다.
		RestResponse res = new RestResponse();
		
		if (!articleService.regist(article)) { // 등록 실패이면
			res.setSuccess(false);
			res.setResCode(ResponseCode.UNKOWN);
		} 
		
		model.addAttribute("article", article);
		
		return res;
	}
}
