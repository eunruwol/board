package kr.or.ddit.file.dao;

import java.util.List;

import kr.or.ddit.file.model.FileVo;

public interface FileDaoInf {
	
	/**
	* Method : selectFile
	* 작성자 : iks
	* 변경이력 :
	* @param post_no
	* @return
	* Method 설명 : 파일 조회
	 */
	List<FileVo> selectFile(int post_no);
	
	/**
	* Method : insertFile
	* 작성자 : iks
	* 변경이력 :
	* @param fileVo
	* @return
	* Method 설명 : 첨부파일 추가
	*/
	int insertFile(FileVo fileVo);
}