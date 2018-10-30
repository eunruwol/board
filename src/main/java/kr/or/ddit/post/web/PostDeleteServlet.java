package kr.or.ddit.post.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.post.service.PostService;
import kr.or.ddit.post.service.PostServiceInf;

@WebServlet("/postDelete")
public class PostDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 파라미터 값 확인
		int post_no = Integer.parseInt(request.getParameter("post_no"));
		int board_id = Integer.parseInt(request.getParameter("board_id"));
		
		// 게시글 삭제(삭제여부 값만 업데이트)
		PostServiceInf postService = new PostService();
		int delCnt = postService.deletePost(post_no);
		
		// view
		response.sendRedirect("/postList?board_id=" + board_id);
	}

}
