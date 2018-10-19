package kr.or.ddit.board.service;

import java.util.List;

import kr.or.ddit.board.dao.BoardDao;
import kr.or.ddit.board.dao.BoardDaoInf;
import kr.or.ddit.board.model.BoardVo;

public class BoardService implements BoardServiceInf{

	private BoardDaoInf boardDao = new BoardDao();
	
	/**
	* Method : insertBoard
	* 작성자 : iks
	* 변경이력 :
	* @param boardVo
	* @return
	* Method 설명 : 게시판 추가
	*/
	@Override
	public int insertBoard(BoardVo boardVo) {
		return boardDao.insertBoard(boardVo);
	}
	
	/**
	* Method : selectAllBoard
	* 작성자 : iks
	* 변경이력 :
	* @return
	* Method 설명 : 전체 게시판 조회
	*/
	@Override
	public List<BoardVo> selectAllBoard() {
		return boardDao.selectAllBoard();
	}
	
	/**
	* Method : updateBoard
	* 작성자 : iks
	* 변경이력 :
	* @param boardVo
	* @return
	* Method 설명 : 게시판 수정
	*/
	@Override
	public int updateBoard(BoardVo boardVo) {
		return boardDao.updateBoard(boardVo);
	}

	@Override
	public BoardVo selectBoard(int board_id) {
		return boardDao.selectBoard(board_id);
	}
}