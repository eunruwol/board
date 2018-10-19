package kr.or.ddit.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.db.SqlFactoryBuilder;

public class BoardDao implements BoardDaoInf {
	private SqlSessionFactory sqlSessionFactory = SqlFactoryBuilder.getSqlSessionFactory();
	
	/**
	* Method : insertBoard
	* 작성자 : iks
	* 변경이력 :
	* @param boardVo
	* @return
	* Method 설명 : 게시판
	*/
	public int insertBoard(BoardVo boardVo){
		SqlSession session = sqlSessionFactory.openSession();
		int insertCnt = session.insert("board.insertBoard", boardVo);
		session.commit();
		session.close();
		
		return insertCnt;
	}
	
	/**
	* Method : selectAllBoard
	* 작성자 : iks
	* 변경이력 :
	* @return
	* Method 설명 : 게시판 전체 조회
	 */
	@Override
	public List<BoardVo> selectAllBoard() {
		SqlSession session = sqlSessionFactory.openSession();
		List<BoardVo> boardList = session.selectList("board.selectAllBoard");
		session.close();
		
		return boardList;
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
		SqlSession session = sqlSessionFactory.openSession();
		int updateCnt = session.update("board.updateBoard", boardVo);
		session.commit();
		session.close();
		
		return updateCnt;
	}
	
	/**
	* Method : selectBoard
	* 작성자 : iks
	* 변경이력 :
	* @param board_id
	* @return
	* Method 설명 : 특정 게시판 조회
	*/
	@Override
	public BoardVo selectBoard(int board_id) {
		SqlSession session = sqlSessionFactory.openSession();
		BoardVo boardVo = session.selectOne("board.selectBoard", board_id);
		session.close();
		
		return boardVo;
	}
}