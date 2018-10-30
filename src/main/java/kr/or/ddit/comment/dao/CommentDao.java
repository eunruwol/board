package kr.or.ddit.comment.dao;

import java.util.List;

import kr.or.ddit.comment.model.CommentVo;
import kr.or.ddit.db.SqlFactoryBuilder;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class CommentDao implements CommentDaoInf {
	private SqlSessionFactory sqlSessionFactory = SqlFactoryBuilder.getSqlSessionFactory();
	
	/**
	* Method : selectComment
	* 작성자 : iks
	* 변경이력 :
	* @param post_no
	* @return
	* Method 설명 : 댓글 리스트 조회
	*/
	@Override
	public List<CommentVo> selectComment(int post_no) {
		SqlSession session = sqlSessionFactory.openSession();
		List<CommentVo> commentList = session.selectList("comment.selectComment", post_no);
		session.close();
		
		return commentList;
	}
	
	/**
	* Method : insertComment
	* 작성자 : iks
	* 변경이력 :
	* @param commentVo
	* @return
	* Method 설명 : 댓글 등록
	*/
	@Override
	public int insertComment(CommentVo commentVo) {
		SqlSession session = sqlSessionFactory.openSession();
		int insertCnt = session.insert("comment.insertComment", commentVo);
		session.commit();
		session.close();
		
		return insertCnt;
	}

	/**
	* Method : deleteComment
	* 작성자 : iks
	* 변경이력 :
	* @param comment_id
	* @return
	* Method 설명 : 댓글 삭제
	*/
	@Override
	public int deleteComment(int comment_id) {
		SqlSession session = sqlSessionFactory.openSession();
		int deleteCnt = session.update("comment.deleteComment", comment_id);
		session.commit();
		session.close();
		
		return deleteCnt;
	}
}
