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

import kr.or.ddit.file.model.FileVo;
import kr.or.ddit.file.service.FileService;
import kr.or.ddit.file.service.FileServiceInf;
import kr.or.ddit.file.web.FileUtil;
import kr.or.ddit.post.model.PostVo;
import kr.or.ddit.post.service.PostService;
import kr.or.ddit.post.service.PostServiceInf;

@WebServlet("/postAnswer")
@MultipartConfig(maxFileSize=1024*1000*3, maxRequestSize=1024*1000*15)
public class PostAnswerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// encoding
		request.setCharacterEncoding("utf-8");
		
		// view
		request.getRequestDispatcher("/post/postAnswer.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// encoding
		request.setCharacterEncoding("utf-8");		
		
		// 파라미터 값 확인
		int board_id = Integer.parseInt(request.getParameter("board_id"));
		int pno = Integer.parseInt(request.getParameter("post_no"));
		int gno = Integer.parseInt(request.getParameter("gno"));
		String post_tit = request.getParameter("post_tit");
		String post_con = request.getParameter("post_con");
		String userId = request.getParameter("userId");
		
		// vo에 저장
		PostVo postVo = new PostVo();
		postVo.setBoard_id(board_id);
		postVo.setUserId(userId);
		postVo.setPno(pno);
		postVo.setGno(gno);
		postVo.setPost_tit(post_tit);
		postVo.setPost_con(post_con);
		
		// 답변 게시글 등록
		PostServiceInf postService = new PostService();
		int cnt = postService.insertAnswerPost(postVo);

		// 등록한 게시글 번호 조회
		int post_no = postService.selectPostNum(postVo);
		
		if (cnt > 0) {
			
			// 첨부파일 업데이트 설정
			int listSize = Integer.parseInt(request.getParameter("listSize")); // 첨부파일 개수
			List<Part> filePart = new ArrayList<Part>();
			FileVo fileVo = new FileVo();
			FileServiceInf fileService = new FileService();
			
			// 신규로 업데이트 하는 경우
			for (int i = 0; i < listSize; i++) {
				int fno = i + 1;
				filePart.add(request.getPart("file-" + fno));
				
				if (filePart.get(i).getSize() > 0) {
					String contentDisposition = filePart.get(i).getHeader("Content-Disposition");
					String fileUpName = UUID.randomUUID().toString();
					String filePath = FileUtil.fileUploadPath;
					String fileName = FileUtil.getFileName(contentDisposition);
					
					// vo에 저장
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
			
			// view
			response.sendRedirect("/postDetail?post_no=" + post_no);
			
		} else {
			
			// view
			response.sendRedirect("/post/postAnswer.jsp");
		}
	}

}
