package org.ohjic.flower.model;

public class ArticleSearch {
	public static final int PAGESIZE = 3; // 게시판 하단에 보이게 될 페이지 개수 ==> (1 2 3 다음) 이런식으로 
	public static final int ARTICLESIZE = 2; // 한 페이지 당 보이게 될 게시글의 수
	
	private int startRow; // 화면에 보이게 될 게시글이 디비에서 몇번째인지
	private String keyList;
	private String keyword;
	private int articleSize;

	public ArticleSearch(int pageNo, String keyList, String keyword) {
		setStartRow(pageNo);
		this.keyList = keyList;
		this.keyword = keyword;
		this.articleSize = ARTICLESIZE;
	}
	
	public int getStartRow() {
		return startRow;
	}
	public void setStartRow(int pageNo) { // 디비에서 가져올 게시물의 시작 위치
		this.startRow = (pageNo-1) * ARTICLESIZE;
	}
	public String getKeyList() {
		return keyList;
	}
	public void setKeyList(String keyList) {
		this.keyList = keyList;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public int getArticleSize() {
		return articleSize;
	}
	public void setArticleSize(int articleSize) {
		this.articleSize = articleSize;
	}
	
}
