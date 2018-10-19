package kr.or.ddit.board.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceInf;

@WebServlet("/boardUpdate")
public class BoardUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String userId = request.getParameter("userId");
		String board_name = request.getParameter("board_name");
		String board_use = request.getParameter("board_use");
		int board_id = Integer.parseInt(request.getParameter("board_id"));
		
		BoardVo boardVo = new BoardVo();
		boardVo.setUserId(userId);
		boardVo.setBoard_name(board_name);
		boardVo.setBoard_use(board_use);
		boardVo.setBoard_id(board_id);
		
		BoardServiceInf boardService = new BoardService();
		int updateCnt = boardService.updateBoard(boardVo);
		
		if(updateCnt > 0) {
			System.out.println("success");
		}else{
			System.out.println("fail");
		}
		
		List<BoardVo> boardList = boardService.selectAllBoard();
		request.setAttribute("boardList", boardList);
		
		response.sendRedirect("/boardList");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}
