package org.ohjic.flower.service;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.ohjic.flower.model.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/dao-context.xml"})
public class BoardServiceTest {

	@Autowired
	BoardService boardService;
	
	@Test
	public void testRegist() {
		
		Board board = new Board();
		
//		board.setTitle("테스트 제목");
		board.setContent("내용입니다.");
		board.setWriter("오직");
		boolean result = boardService.regist(board);
		
		assertTrue(result);
	}
	
	@Test
	public void testFailRegist() {
		
		Board board = new Board();
		
//		board.setTitle("테스트 제목");
		board.setContent("내용입니다.");
		board.setWriter("오직");
		boolean result = boardService.regist(board);
		
		assertTrue(!result);
	}
	
	@Test
	public void testGetBoard() {
		int boardSeq =1 ;
		Board board = boardService.getBoard(boardSeq);
		
		assertTrue(board != null);
	}
	
	@Test
	public void testModify() {
		Board board = new Board();
		boolean result= boardService.modify(board );
		
		assertTrue(result);
	}
}
