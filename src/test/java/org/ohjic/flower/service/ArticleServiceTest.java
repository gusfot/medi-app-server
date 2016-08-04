package org.ohjic.flower.service;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.ohjic.flower.common.ArticlePaging;
import org.ohjic.flower.model.Article;
import org.ohjic.flower.model.ArticleSearch;
import org.ohjic.flower.test.SpringTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class ArticleServiceTest extends SpringTest {

	private static final Logger logger = LoggerFactory.getLogger(ArticleServiceTest.class);
	
	@Autowired
	ArticleService articleService;
	
//	@Test
//	public void testRegist() {
//		Article article = new Article();
//		
//		article.setWriter("관리자");
//		article.setTitle("등록테스트");
//		article.setContent("내용 등록");
//		article.setCheckCount(1);
//		
//		boolean result = articleService.regist(article);
//		
//		assertTrue(result);
//	}
	
	@Test
	public void testGetList() {
//		int count = articleService.countList(articleSearch);
//		logger.info("count 확인 -> {}", count);
		
		ArticlePaging<Article> articlePaging = articleService.getList(1, "title", "");
		
		logger.info("pageSize = {}", articlePaging.getPageSize());
		logger.info("articleSize = {}", articlePaging.getArticleSize());
		logger.info("pageNo = {}", articlePaging.getPageNo());
		logger.info("totalArticle = {}", articlePaging.getTotalArticle());
		logger.info("totalPage = {}", articlePaging.getTotalPage());
		logger.info("startPage = {}", articlePaging.getStartPage());
		logger.info("endPage = {}", articlePaging.getEndPage());
		logger.info("articleList = {}", articlePaging.getArticleList().size());
		
		assertTrue(articlePaging != null);
	}
	
	
	
}
