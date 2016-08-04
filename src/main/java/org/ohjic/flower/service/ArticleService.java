package org.ohjic.flower.service;

import java.util.List;

import org.ohjic.flower.common.ArticlePaging;
import org.ohjic.flower.model.Article;
import org.ohjic.flower.model.ArticleSearch;

public interface ArticleService {

	boolean regist(Article article);

	int countList(ArticleSearch articleSearch);

	ArticlePaging<Article> getList(int pageNo, String keyList, String keyword);
}
