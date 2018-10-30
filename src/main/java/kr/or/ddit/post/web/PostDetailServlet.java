package kr.or.ddit.post.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceInf;
import kr.or.ddit.comment.model.CommentVo;
import kr.or.ddit.comment.service.CommentService;
import kr.or.ddit.comment.service.CommentServiceInf;
import kr.or.ddit.file.model.FileVo;
import kr.or.ddit.file.service.FileService;
import kr.or.ddit.file.service.FileServiceInf;
import kr.or.ddit.post.model.PostVo;
import kr.or.ddit.post.service.PostService;
import kr.or.ddit.post.service.PostServiceInf;

@WebServlet("/postDetail")
public class PostDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		int post_no = Integer.parseInt(request.getParameter("post_no"));
		
		// 게시글 상세 조회
		PostServiceInf postService = new PostService();
		PostVo postVo = postService.getPost(post_no);
		
		// 게시글 첨부파일 조회
		FileServiceInf fileService = new FileService();
		List<FileVo> fileList = fileService.selectFile(post_no);
		
		// 게시글 댓글 조회
		CommentServiceInf commentService = new CommentService();
		List<CommentVo> commentList = commentService.selectComment(post_no);
		
		// 저장
		HttpSession session = request.getSession();
		session.setAttribute("postVo", postVo);
		session.setAttribute("fileList", fileList);
		session.setAttribute("commentList", commentList);
		
		// 전체 게시판 조회
		BoardServiceInf boardService = new BoardService();
		List<BoardVo> boardList = boardService.selectAllBoard();
		
		request.setAttribute("boardList", boardList);
		
		request.getRequestDispatcher("/post/postDetail.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
