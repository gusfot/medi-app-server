package org.ohjic.flower.common;

import java.util.List;

import org.ohjic.flower.model.Article;

public class ArticlePaging <T> {
	
	private int pageSize;
	private int articleSize;
	private int pageNo; // 현재 페이지 번호
	private int totalArticle; // 총 게시물 수
	private int totalPage; // 총 페이지 수
	private int startPage; // 현재 화면에 보이는 맨 처음 페이지 번호
	private int endPage; // 현재 화면에 보이는 맨 끝 페이지 번호
	private List<T> articleList;
	
	public ArticlePaging(int pageSize, int articleSize, int pageNo, int totalArticle, List<T> articleList) {
		this.pageSize = pageSize;
		this.articleSize = articleSize;
		this.pageNo = pageNo;
		this.totalArticle = totalArticle;
		setPageInfo (pageSize, articleSize, pageNo, totalArticle);
		this.articleList = articleList;
	}
	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getArticleSize() {
		return articleSize;
	}

	public void setArticleSize(int articleSize) {
		this.articleSize = articleSize;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getTotalArticle() {
		return totalArticle;
	}

	public void setTotalArticle(int totalArticle) {
		this.totalArticle = totalArticle;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public int getStartPage() {
		return startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setPageInfo (int pageSize, int articleSize, int pageNo, int totalArticle) {
		int nmg = totalArticle%articleSize;
		if (nmg != 0) {
			this.totalPage = (totalArticle / articleSize) + 1;
		} else {
			this.totalPage = totalArticle / articleSize;
		}
		
		this.startPage = pageNo - ((pageNo-1)%pageSize);
		
		int end = startPage + pageSize - 1;
		if (end > this.totalPage) {
			end = this.totalPage;
		}
		this.endPage = end;
	}

	public List<T> getArticleList() {
		return articleList;
	}

	public void setArticleList(List<T> articleList) {
		this.articleList = articleList;
	}
}
