package kr.or.ddit.post.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.post.dao.PostDao;
import kr.or.ddit.post.dao.PostDaoInf;
import kr.or.ddit.post.model.PostVo;

public class PostService implements PostServiceInf {
	private PostDaoInf postDao = new PostDao();

	@Override
	public Map<String, Object> getPostPageList(Map<String, Integer> map) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		// 게시글 페이지 리스트 조회
		List<PostVo> pageList = postDao.getPostPageList(map);
		resultMap.put("pageList", pageList);
		
		// 게시글 건수 조회
		int board_id = map.get("board_id");
		int totalCnt = postDao.getPostTotalCnt(board_id);
		resultMap.put("totalCnt", totalCnt);
		
		// 페이징
		int page = map.get("page");
		int pageSize = map.get("pageSize");
		
		resultMap.put("pageNavi", pageNavis(board_id, page, pageSize, totalCnt));
		
		return resultMap;
	}
	
	/**
	* Method : pageNavis
	* 작성자 : iks
	* 변경이력 :
	* @param board_id
	* @param page
	* @param pageSize
	* @param totalCnt
	* @return
	* Method 설명 : 페이지 네비게이션 생성
	*/
	private String pageNavis(int board_id, int page, int pageSize, int totalCnt){
		int cnt = totalCnt / pageSize;
		int mod = totalCnt % pageSize;
		
		if(mod > 0){
			cnt++;
		}
		
		StringBuffer pageNaviStr = new StringBuffer();
		
		int prevPage = page == 1 ? 1: page - 1;
		int nextPage = page == cnt ? page : page + 1;
		
		String prevCloseClass = "";
		if(page == 1){
			prevCloseClass = "class=\"close\"";
		}
		pageNaviStr.append("<li " + prevCloseClass + ">"
				+ "<a href=\"/postList?board_id=" + board_id + "&page=" + prevPage + "&pageSize=" + pageSize + "\" aria-label=\"Previous\">"
				+ "<span aria-hidden=\"true\">&laquo;</span></a></li>");
		
		// pagination number
		for(int i=1; i<=cnt; i++){
			String activeClass = "";
			if(i == page){
				activeClass = "class=\"active\"";
			}
			pageNaviStr.append("<li " + activeClass + "><a href=\"/postList?board_id=" + board_id + "&page=" + i + "&pageSize=" + pageSize + "\">" + i + "</a></li>");
		}
		
		String nextCloseClass = "";
		if(page == cnt){
			nextCloseClass = "class=\"close\"";
		}
		pageNaviStr.append("<li " + nextCloseClass + ">"
				+ "<a href=\"/postList?board_id=" + board_id + "&page=" + nextPage + "&pageSize=" + pageSize + "\" aria-label=\"Previous\">"
				+ "<span aria-hidden=\"true\">&raquo;</span></a></li>");
		
		return pageNaviStr.toString();		
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
		return postDao.getPost(post_no);
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
		return postDao.insertPost(postVo);
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
		return postDao.selectPostNum(postVo);
	}
	
	/**
	* Method : updatePost
	* 작성자 : iks
	* 변경이력 :
	* @param postVo
	* @return
	* Method 설명 : 게시글 수정
	*/
	@Override
	public int updatePost(PostVo postVo) {
		return postDao.updatePost(postVo);
	}

	/**
	* Method : deletePost
	* 작성자 : iks
	* 변경이력 :
	* @param post_no
	* @return
	* Method 설명 : 게시글 삭제 (삭제여부만)
	*/
	@Override
	public int deletePost(int post_no) {
		return postDao.deletePost(post_no);
	}
	
	/**
	* Method : insertAnswerPost
	* 작성자 : iks
	* 변경이력 :
	* @param postVo
	* @return
	* Method 설명 : 답글 등록
	 */
	@Override
	public int insertAnswerPost(PostVo postVo) {
		return postDao.insertAnswerPost(postVo);
	}
}