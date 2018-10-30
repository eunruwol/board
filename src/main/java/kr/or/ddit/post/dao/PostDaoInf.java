package kr.or.ddit.post.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.post.model.PostVo;

public interface PostDaoInf {
	
	/**
	* Method : getPostPageList
	* 작성자 : iks
	* 변경이력 :
	* @param map
	* @return
	* Method 설명 : 게시글 페이지 리스트 조회
	*/
	List<PostVo> getPostPageList(Map<String, Integer> map);
	
	
	/**
	* Method : getPostTotalCnt
	* 작성자 : iks
	* 변경이력 :
	* @param board_id
	* @return
	* Method 설명 : 게시글 상세 조회
	*/
	int getPostTotalCnt(int board_id);
	
	/**
	* Method : getPost
	* 작성자 : pc18
	* 변경이력 :
	* @param post_no
	* @return
	* Method 설명 : 게시글 상세 조회
	*/
	PostVo getPost(int post_no);
	
	/**
	* Method : insertPost
	* 작성자 : iks
	* 변경이력 :
	* @param postVo
	* Method 설명 : 게시글 등록
	 */
	int insertPost(PostVo postVo);
	
	/**
	* Method : selectPostNum
	* 작성자 : iks
	* 변경이력 :
	* @param postVo
	* @return
	* Method 설명 : 게시글 번호 조회
	 */
	int selectPostNum(PostVo postVo);
	
	/**
	* Method : updatePost
	* 작성자 : iks
	* 변경이력 :
	* @param postVo
	* @return
	* Method 설명 : 게시글 수정
	 */
	int updatePost(PostVo postVo);
	
	/**
	* Method : deletePost
	* 작성자 : iks
	* 변경이력 :
	* @param post_no
	* @return
	* Method 설명 : 게시글 삭제 (삭제여부만)
	 */
	int deletePost(int post_no);
	
	/**
	* Method : insertAnswerPost
	* 작성자 : iks
	* 변경이력 :
	* @param postVo
	* @return
	* Method 설명 : 답글 등록
	 */
	int insertAnswerPost(PostVo postVo);
}