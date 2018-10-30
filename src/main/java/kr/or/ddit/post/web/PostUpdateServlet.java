package kr.or.ddit.post.web;

import java.io.File;
import java.io.IOException;
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

@WebServlet("/postUpdate")
@MultipartConfig(maxFileSize=1024*1024*5, maxRequestSize=1024*1024*5*5)
public class PostUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// encoding
		request.setCharacterEncoding("utf-8");
		
		// 전체 게시판 조회
		BoardServiceInf boardService = new BoardService();
		List<BoardVo> boardList = boardService.selectAllBoard();
		
		request.setAttribute("boardList", boardList);
		
		// view
		request.getRequestDispatcher("/post/postUpdate.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// encoding
		request.setCharacterEncoding("utf-8");
		
		// 파라미터 값 확인
		int post_no = Integer.parseInt(request.getParameter("post_no"));
		String post_tit = request.getParameter("post_tit");
		String post_con = request.getParameter("post_con");
		
		// 게시글 조회
		PostServiceInf postService = new PostService();
		PostVo postVo = postService.getPost(post_no);
		
		// vo에 저장
		postVo.setPost_tit(post_tit);
		postVo.setPost_con(post_con);
		
		// 게시글 수정
		int updateCnt = postService.updatePost(postVo);
		
		if (updateCnt > 0) {
			
			// 첨부파일 업데이트 설정
			int listSize = Integer.parseInt(request.getParameter("listSize")); // 첨부파일 개수
			FileVo fileVo = new FileVo();
			FileServiceInf fileService = new FileService();
			
			// 신규로 업데이트 하는 경우
			for (int i = 0; i < listSize; i++) {
				
				Part filePart = request.getPart("file-" + i);
				System.out.println(filePart.getName());
				
				if (filePart.getSize() > 0) {
					String contentDisposition = filePart.getHeader("Content-Disposition");
					String fileUpName = UUID.randomUUID().toString();
					String filePath = FileUtil.fileUploadPath;
					String fileName = FileUtil.getFileName(contentDisposition);
					
					// vo에 저장
					fileVo.setPost_no(post_no);
					fileVo.setFile_up_name(fileUpName);
					fileVo.setFile_path(filePath);
					fileVo.setFile_name(fileName);
					
					filePart.write(filePath + File.separator + fileName);
					filePart.delete();
					
					// 저장
					fileService.insertFile(fileVo);
				}
				
			}
			
			// view
			response.sendRedirect("/postDetail?post_no=" + post_no);
		} else {
			// view
			response.sendRedirect("/post/postUpdate.jsp");
		}
	}

}
