/**
 * 
 */
package org.ohjic.flower.service.impl;

import org.ohjic.flower.dao.BoardMapper;
import org.ohjic.flower.model.Board;
import org.ohjic.flower.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ohjic
 *
 */
@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardMapper boardMapper;
	
	/* (non-Javadoc)
	 * @see org.ohjic.flower.service.BoardService#regist(org.ohjic.flower.model.Board)
	 */
	@Override
	public boolean regist(Board board) {
		// TODO Auto-generated method stub
		return boardMapper.insert(board) == 1;
	}

	/* (non-Javadoc)
	 * @see org.ohjic.flower.service.BoardService#getBoard(int)
	 */
	@Override
	public Board getBoard(int boardSeq) {
		// TODO Auto-generated method stub
		return boardMapper.selectByPrimaryKey(boardSeq);
	}

	/* (non-Javadoc)
	 * @see org.ohjic.flower.service.BoardService#modify(org.ohjic.flower.model.Board)
	 */
	@Override
	public boolean modify(Board board) {
		// TODO Auto-generated method stub
		return boardMapper.updateByPrimaryKey(board) == 1;
	}

}
