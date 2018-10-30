package kr.or.ddit.comment.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.comment.model.CommentVo;
import kr.or.ddit.comment.service.CommentService;
import kr.or.ddit.comment.service.CommentServiceInf;

@WebServlet("/commentInsert")
public class CommentInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// encoding
		request.setCharacterEncoding("utf-8");
		
		// 파라미터 확인
		String userId = request.getParameter("userId");
		int post_no = Integer.parseInt(request.getParameter("post_no"));
		String re_con = request.getParameter("re_con");
		
		// 파라미터 값 셋팅
		CommentVo commentVo = new CommentVo();
		commentVo.setPost_no(post_no);
		commentVo.setRe_con(re_con);
		commentVo.setRe_del("N");
		commentVo.setUserId(userId);
		
		// 댓글 입력
		CommentServiceInf commentService = new CommentService();
		int insertCnt = commentService.insertComment(commentVo);
		
		if (insertCnt > 0) {
			System.out.println("성공");
		} else {
			System.out.println("실패");
		}
		
		// 게시글 상세페이지로 이동
		response.sendRedirect("/postDetail?post_no=" + post_no);
	}

}
