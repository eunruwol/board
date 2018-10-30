package kr.or.ddit.post.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceInf;
import kr.or.ddit.post.model.PostVo;
import kr.or.ddit.post.service.PostService;
import kr.or.ddit.post.service.PostServiceInf;

@WebServlet("/postList")
public class PostListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		String pageStr = request.getParameter("page");
		String pageSizeStr = request.getParameter("pageSize");
		int board_id = Integer.parseInt(request.getParameter("board_id"));
		
		int page = pageStr == null ? 1: Integer.parseInt(pageStr);
		int pageSize = pageSizeStr == null ? 10 : Integer.parseInt(pageSizeStr);
		
		Map<String, Integer> paramMap = new HashMap<String, Integer>();
		paramMap.put("page", page);
		paramMap.put("pageSize", pageSize);
		paramMap.put("board_id", board_id);
		
		// 특정 게시판 조회
		BoardServiceInf boardService = new BoardService();
		BoardVo boardVo = boardService.selectBoard(board_id);
		session.setAttribute("boardVo", boardVo);
		
		// 게시글 페이지 리스트, 전체 건수 조회
		PostServiceInf postService = new PostService();
		Map<String, Object> resultMap = postService.getPostPageList(paramMap);
		
		List<PostVo> postList = (List<PostVo>) resultMap.get("pageList");
		request.setAttribute("postList", postList);
		
		// 페이지 네비게이션 문자열
		String pageNavi = (String) resultMap.get("pageNavi");
		request.setAttribute("pageNavi", pageNavi);
		
		// 전체 게시판 조회
		List<BoardVo> boardList = boardService.selectAllBoard();
		request.setAttribute("boardList", boardList);
		
		request.getRequestDispatcher("/post/postList.jsp").forward(request, response);
		
		response.setContentType("text/html; charset=UTF-8");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
