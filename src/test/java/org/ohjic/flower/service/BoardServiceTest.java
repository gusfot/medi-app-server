package org.ohjic.flower.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.ohjic.flower.model.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import junit.framework.Assert;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/dao-context.xml"})
public class BoardServiceTest {

	@Autowired
	BoardService boardService;
	
	@Test
	public void registBoard(){
		
		Board board = new Board();
		board.setBoardSeq(1);
		board.setTitle("title");
		board.setContent("contents");
		board.setWriter("name");
		
		boolean result = boardService.regist(board);
		
		Assert.assertTrue(result);
		
	}
	
}
