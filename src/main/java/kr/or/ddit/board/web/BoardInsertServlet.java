package kr.or.ddit.board.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceInf;

@WebServlet("/boardInsert")
public class BoardInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// encoding 설정
		request.setCharacterEncoding("UTF-8");
		
		String userId = request.getParameter("userId");
		String board_name = request.getParameter("board_name");
		String board_use = request.getParameter("board_use");
		
		BoardVo boardVo = new BoardVo();
		boardVo.setUserId(userId);
		boardVo.setBoard_name(board_name);
		boardVo.setBoard_use(board_use);
		
		BoardServiceInf boardService = new BoardService();
		boardService.insertBoard(boardVo);
		
		// 게시판 상세조회 이동
		response.sendRedirect("/boardList");
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}
