package kr.or.ddit.comment.model;

import java.util.Date;

public class CommentVo {
	private int comment_id;			// 댓글 번호
	private int post_no;			// 게시글 번호
	private String re_con;			// 댓글 내용
	private Date re_date;			// 작성일시
	private String re_del;			// 댓글 삭제여부
	private String userId;			// 작성자
	
	public int getComment_id() {
		return comment_id;
	}
	public void setComment_id(int comment_id) {
		this.comment_id = comment_id;
	}
	public int getPost_no() {
		return post_no;
	}
	public void setPost_no(int post_no) {
		this.post_no = post_no;
	}
	public String getRe_con() {
		return re_con;
	}
	public void setRe_con(String re_con) {
		this.re_con = re_con;
	}
	public Date getRe_date() {
		return re_date;
	}
	public void setRe_date(Date re_date) {
		this.re_date = re_date;
	}
	public String getRe_del() {
		return re_del;
	}
	public void setRe_del(String re_del) {
		this.re_del = re_del;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	@Override
	public String toString() {
		return "CommentVo [comment_id=" + comment_id + ", post_no=" + post_no
				+ ", re_con=" + re_con + ", re_date=" + re_date + ", re_del="
				+ re_del + ", userId=" + userId + "]";
	}	
}