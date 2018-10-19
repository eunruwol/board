package kr.or.ddit.post.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.db.SqlFactoryBuilder;
import kr.or.ddit.post.model.PostVo;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class PostDao implements PostDaoInf {
	private SqlSessionFactory sqlSessionFactory = SqlFactoryBuilder.getSqlSessionFactory();

	/**
	* Method : getPostPageList
	* 작성자 : iks
	* 변경이력 :
	* @param map
	* @return
	* Method 설명 : 게시글 페이지 리스트 조회
	*/
	@Override
	public List<PostVo> getPostPageList(Map<String, Integer> map) {
		SqlSession session = sqlSessionFactory.openSession();
		List<PostVo> postList = session.selectList("post.getPostPageList", map);
		session.close();
		
		return postList;
	}

	/**
	* Method : getPostTotalCnt
	* 작성자 : iks
	* 변경이력 :
	* @param board_id
	* @return
	* Method 설명 : 게시글 건수 조회
	*/
	@Override
	public int getPostTotalCnt(int board_id) {
		SqlSession session = sqlSessionFactory.openSession();
		int totalCnt = session.selectOne("post.getPostTotalCnt", board_id);
		session.close();
		
		return totalCnt;
	}
	
	/**
	* Method : getPost
	* 작성자 : iks
	* 변경이력 :
	* @param post_no
	* @return
	* Method 설명 : 게시글 상세 조회
	 */
	@Override
	public PostVo getPost(int post_no) {
		SqlSession session = sqlSessionFactory.openSession();
		PostVo postVo = session.selectOne("post.getPost", post_no);
		session.close();
		
		return postVo;
	}
	
	/**
	* Method : insertPost
	* 작성자 : iks
	* 변경이력 :
	* @param postVo
	* @return
	* Method 설명 : 게시글 등록
	*/
	@Override
	public int insertPost(PostVo postVo) {
		SqlSession session = sqlSessionFactory.openSession();
		int insertCnt = session.insert("post.insertPost", postVo);
		session.commit();
		session.close();
		
		return insertCnt;
	}
	
	/**
	* Method : selectPostNum
	* 작성자 : iks
	* 변경이력 :
	* @param postVo
	* @return
	* Method 설명 : 게시글 번호 조회
	 */
	@Override
	public int selectPostNum(PostVo postVo) {
		SqlSession session = sqlSessionFactory.openSession();
		int post_no = session.selectOne("post.selectPostNum", postVo);
		session.close();
		
		return post_no;
	}
}