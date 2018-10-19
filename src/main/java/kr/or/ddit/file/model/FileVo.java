package kr.or.ddit.file.model;

public class FileVo {
	private int file_no;			// 첨부파일 번호
	private int post_no;			// 게시글 번호
	private String file_up_name;	// 업로드 파일명
	private String file_path;		// 파일경로
	private String file_name;		// 파일명
	
	public int getFile_no() {
		return file_no;
	}
	public void setFile_no(int file_no) {
		this.file_no = file_no;
	}
	public int getPost_no() {
		return post_no;
	}
	public void setPost_no(int post_no) {
		this.post_no = post_no;
	}
	public String getFile_up_name() {
		return file_up_name;
	}
	public void setFile_up_name(String file_up_name) {
		this.file_up_name = file_up_name;
	}
	public String getFile_path() {
		return file_path;
	}
	public void setFile_path(String file_path) {
		this.file_path = file_path;
	}
	public String getFile_name() {
		return file_name;
	}
	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}
	
	@Override
	public String toString() {
		return "FileVo [file_no=" + file_no + ", post_no=" + post_no
				+ ", file_up_name=" + file_up_name + ", file_path=" + file_path
				+ ", file_name=" + file_name + "]";
	}
}
