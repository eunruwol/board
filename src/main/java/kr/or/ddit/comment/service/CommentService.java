package kr.or.ddit.comment.service;

import java.util.List;

import kr.or.ddit.comment.dao.CommentDao;
import kr.or.ddit.comment.dao.CommentDaoInf;
import kr.or.ddit.comment.model.CommentVo;

public class CommentService implements CommentServiceInf {
	
	private CommentDaoInf commentDao = new CommentDao();
	
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
		return commentDao.selectComment(post_no);
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
		return commentDao.insertComment(commentVo);
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
		return commentDao.deleteComment(comment_id);
	}
}