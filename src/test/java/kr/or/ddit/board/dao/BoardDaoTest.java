package kr.or.ddit.board.dao;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import kr.or.ddit.board.model.BoardVo;

import org.junit.Test;

public class BoardDaoTest {
	
	private BoardDaoInf boardDao;
	
	/**
	* Method : selectAllBoardTest
	* 작성자 : iks
	* 변경이력 :
	* Method 설명 : 전체 게시판 조회 테스트
	*/
	@Test
	public void selectAllBoardTest() {
		/***Given***/
		int board_id = 22;

		/***When***/
		List<BoardVo> boardList = boardDao.selectAllBoard();
		
		/***Then***/
		assertEquals(board_id, boardList.get(0).getBoard_id());
	}
	
	/**
	* Method : selectBoardTest
	* 작성자 : iks
	* 변경이력 :
	* Method 설명 : 특정 게시판 조회 테스트
	*/
	@Test
	public void selectBoardTest() {
		/***Given***/
		int board_id = 22;

		/***When***/
		BoardVo boardVo = boardDao.selectBoard(board_id);
		
		/***Then***/
		assertEquals(board_id, boardVo.getBoard_id());
		assertEquals("자유게시판", boardVo.getBoard_name());
	}
	
	/**
	* Method : insertBoardTest
	* 작성자 : iks
	* 변경이력 :
	* Method 설명 : 게시판 추가 테스트
	*/
	@Test
	public void insertBoardTest() {
		/***Given***/
		BoardVo paramVo = new BoardVo();
		paramVo.setBoard_id(22);
		paramVo.setUserId("brown");
		paramVo.setBoard_name("test");
		paramVo.setBoard_use("N");
		paramVo.setBoard_date(new Date());

		/***When***/
		int cnt = boardDao.insertBoard(paramVo);

		/***Then***/
		assertEquals(1, cnt);

	}
	
	/**
	* Method : updateBoardTest
	* 작성자 : iks
	* 변경이력 :
	* Method 설명 : 게시판 수정 테스트
	*/
	@Test
	public void updateBoardTest() {
		/***Given***/
		BoardVo paramVo = new BoardVo();
		paramVo.setBoard_id(41);
		paramVo.setUserId("brown");
		paramVo.setBoard_name("test");
		paramVo.setBoard_use("N");
		paramVo.setBoard_date(new Date());

		/***When***/
		int cnt = boardDao.updateBoard(paramVo);

		/***Then***/
		assertEquals(1, cnt);

		
	}

}
