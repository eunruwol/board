package kr.or.ddit.user.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceInf;
import kr.or.ddit.encrypt.sha.KISA_SHA256;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.user.service.UserServiceInf;

@WebServlet("/iksLogin")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserServiceInf userService;
	private UserVo userVo;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// encoding 설정
		request.setCharacterEncoding("UTF-8");
		
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		String rememberMe = request.getParameter("rememberMe");
		
		if(rememberMe == null){
			Cookie[] cookies = request.getCookies();
			for(Cookie cookie : cookies){
				if(cookie.getName().equals("remember") || cookie.getName().equals("userId")){
					cookie.setMaxAge(-1);
					response.addCookie(cookie);
				}
			}
		}else{
			Cookie cookie = new Cookie("remember", "Y");
			Cookie userIdCookie = new Cookie("userId", userId);
			
			response.addCookie(cookie);
			response.addCookie(userIdCookie);
		}
		
		// 로그인 성공시 UserVo 객체 저장, main.jsp에서 사용자 아이디 출력
		userService = new UserService();
		userVo = userService.selectUser(userId);
		
		String encryptPass = KISA_SHA256.encrypt(password);
		if(userVo != null && userVo.authPass(encryptPass)){
			HttpSession session = request.getSession();
			session.setAttribute("userVo", userVo);
			
			// 전체 게시판 조회
			BoardServiceInf boardService = new BoardService();
			List<BoardVo> boardList = boardService.selectAllBoard();
			
			request.setAttribute("boardList", boardList);
			
			request.getRequestDispatcher("main.jsp").forward(request, response);
		}else{
			response.sendRedirect("/index.jsp");
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}