package kr.or.ddit.post.model;

import java.util.Date;

public class PostVo {
	private int post_no;		// 게시글 번호
	private int board_id;		// 게시판 번호
	private int pno;			// 부모게시글 번호
	private int gno;			// 게시글그룹 번호
	private String post_tit;	// 게시글 제목
	private String post_con;	// 게시글 내용
	private	Date post_date;		// 작성일시
	private String post_del;	// 삭제여부
	private String userId;		// 작성자
	
	public int getPost_no() {
		return post_no;
	}
	public void setPost_no(int post_no) {
		this.post_no = post_no;
	}
	public int getBoard_id() {
		return board_id;
	}
	public void setBoard_id(int board_id) {
		this.board_id = board_id;
	}
	public int getPno() {
		return pno;
	}
	public void setPno(int pno) {
		this.pno = pno;
	}
	public int getGno() {
		return gno;
	}
	public void setGno(int gno) {
		this.gno = gno;
	}
	public String getPost_tit() {
		return post_tit;
	}
	public void setPost_tit(String post_tit) {
		this.post_tit = post_tit;
	}
	public String getPost_con() {
		return post_con;
	}
	public void setPost_con(String post_con) {
		this.post_con = post_con;
	}
	public Date getPost_date() {
		return post_date;
	}
	public void setPost_date(Date post_date) {
		this.post_date = post_date;
	}
	public String getPost_del() {
		return post_del;
	}
	public void setPost_del(String post_del) {
		this.post_del = post_del;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	@Override
	public String toString() {
		return "PostVo [post_no=" + post_no + ", board_id=" + board_id
				+ ", pno=" + pno + ", gno=" + gno + ", post_tit=" + post_tit
				+ ", post_con=" + post_con + ", post_date=" + post_date
				+ ", post_del=" + post_del + ", userId=" + userId + "]";
	}
}