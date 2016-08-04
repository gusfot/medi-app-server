package org.ohjic.flower.service;

import org.ohjic.flower.model.Board;

public interface BoardService {

	boolean regist(Board board);

	Board getBoard(int boardSeq);

	boolean modify(Board board);

}
