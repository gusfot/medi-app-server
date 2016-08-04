package org.ohjic.flower.service.impl;

import java.util.List;

import org.ohjic.flower.common.ArticlePaging;
import org.ohjic.flower.dao.ArticleMapper;
import org.ohjic.flower.model.Article;
import org.ohjic.flower.model.ArticleSearch;
import org.ohjic.flower.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleServiceImpl implements ArticleService {

	@Autowired
	ArticleMapper articleMapper;
	
	@Override
	public boolean regist(Article article) {
		// TODO Auto-generated method stub
		return articleMapper.insert(article) == 1; // 등록 성공 시 true 리턴, 실패 시 false 리턴
	}

	@Override
	public ArticlePaging<Article> getList(int pageNo, String keyList, String keyword) {
		// TODO Auto-generated method stub
		ArticleSearch articleSearch = new ArticleSearch(pageNo, keyList, keyword);
		
		int totalArticle = articleMapper.countList(articleSearch);
		List<Article> articleList = articleMapper.selectList(articleSearch);
		
		ArticlePaging<Article> articlePaging = new ArticlePaging<>(ArticleSearch.PAGESIZE, ArticleSearch.ARTICLESIZE, pageNo, totalArticle, articleList);
		
		return articlePaging;
	}

	@Override
	public int countList(ArticleSearch articleSearch) {
		// TODO Auto-generated method stub
		return articleMapper.countList(articleSearch);
	}




}
