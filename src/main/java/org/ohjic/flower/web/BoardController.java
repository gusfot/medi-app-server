package org.ohjic.flower.web;

import org.ohjic.flower.model.Board;
import org.ohjic.flower.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BoardController {

	@Autowired
	BoardService boardService;
	
	@RequestMapping(value = "/board/regist", method=RequestMethod.POST)
	public String regist(@ModelAttribute Board board) {
		boardService.regist(board);
				
		return "detail/"+board.getBoardSeq();
	}
}
