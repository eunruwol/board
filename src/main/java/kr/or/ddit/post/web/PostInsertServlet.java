package kr.or.ddit.post.web;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceInf;
import kr.or.ddit.file.model.FileVo;
import kr.or.ddit.file.service.FileService;
import kr.or.ddit.file.service.FileServiceInf;
import kr.or.ddit.file.web.FileUtil;
import kr.or.ddit.post.model.PostVo;
import kr.or.ddit.post.service.PostService;
import kr.or.ddit.post.service.PostServiceInf;
import kr.or.ddit.user.model.UserVo;

@MultipartConfig(maxFileSize=1024*1024*5, maxRequestSize=1024*1024*5*5)
@WebServlet("/postInsert")
public class PostInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		// 전체 게시판 조회
		BoardServiceInf boardService = new BoardService();
		List<BoardVo> boardList = boardService.selectAllBoard();
		
		request.setAttribute("boardList", boardList);
		
		request.getRequestDispatcher("/post/postInsert.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		System.out.println("board_id : " + request.getParameter("board_id"));
		int board_id = Integer.parseInt(request.getParameter("board_id"));
		String post_tit = request.getParameter("post_tit");
		String post_con = request.getParameter("post_con");
		String userId = ((UserVo)request.getSession().getAttribute("userVo")).getUserId();
		System.out.println("USERID : " + userId);
		
		PostVo postVo = new PostVo();
		postVo.setBoard_id(board_id);
		postVo.setPost_tit(post_tit);
		postVo.setPost_con(post_con);
		postVo.setUserId(userId);
		
		PostServiceInf postService = new PostService();
		System.out.println(postVo.getUserId());
		int insertCnt = postService.insertPost(postVo);
		
		int post_no = postService.selectPostNum(postVo);
		
		if(insertCnt > 0) { // 게시글 등록 성공 시
			
			// 첨부파일 설정
			int listSize = Integer.parseInt(request.getParameter("listSize")); // 첨부파일 개수
			List<Part> filePart = new ArrayList<Part>();
			FileVo fileVo = new FileVo();
			FileServiceInf fileService = new FileService();
			
			// 신규 업데이트
			for(int i=0; i<listSize; i++){
				int fno = i+1;
				filePart.add(request.getPart("file-" + fno));
				
				if(filePart.get(i).getSize() > 0){
					String contentDisposition = filePart.get(i).getHeader("Content-Disposition");
					String fileUpName = UUID.randomUUID().toString();
					String filePath = FileUtil.fileUploadPath;
					String fileName = FileUtil.getFileName(contentDisposition);
					
					fileVo.setPost_no(post_no);
					fileVo.setFile_up_name(fileUpName);
					fileVo.setFile_path(filePath);
					fileVo.setFile_name(fileName);
					
					filePart.get(i).write(filePath + File.separator + fileName);
					filePart.get(i).delete();
					
					// 저장
					fileService.insertFile(fileVo);
				}
			}
			
			response.sendRedirect("/postDetail?post_no=" + post_no);
		} else {
			String msg = "게시글 등록에 실패하였습니다.";
			request.setAttribute("msg", msg);
			
			response.sendRedirect("/post/postInsert.jsp");
		}
	}

}
