package kr.or.ddit.board.dao;

import java.util.List;

import kr.or.ddit.board.model.BoardVo;

public interface BoardDaoInf {
	
	/**
	* Method : insertBoard
	* 작성자 : iks
	* 변경이력 :
	* @param boardVo
	* @return
	* Method 설명 : 게시판 추가
	*/
	int insertBoard(BoardVo boardVo);
	
	/**
	* Method : selectAllBoards
	* 작성자 : iks
	* 변경이력 :
	* @return
	* Method 설명 : 전체 게시판 조회
	*/
	List<BoardVo> selectAllBoard();
	
	/**
	* Method : selectBoard
	* 작성자 : iks
	* 변경이력 :
	* @param board_id
	* @return
	* Method 설명 : 특정 게시판 조회
	*/
	BoardVo selectBoard(int board_id);
	
	/**
	* Method : updateBoard
	* 작성자 : iks
	* 변경이력 :
	* @param boardVo
	* @return
	* Method 설명 : 게시판 수정
	 */
	int updateBoard(BoardVo boardVo);
}