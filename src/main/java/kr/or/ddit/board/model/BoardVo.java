package kr.or.ddit.board.model;

import java.util.Date;

public class BoardVo {
	private int board_id;		// 게시판 번호
	private String board_name;	// 게시판 이름
	private String board_use;	// 게시판 사용여부
	private Date   board_date;	// 게시판 작성일시
	private String userId;		// 작성자
	
	public int getBoard_id() {
		return board_id;
	}
	public void setBoard_id(int board_id) {
		this.board_id = board_id;
	}
	public String getBoard_name() {
		return board_name;
	}
	public void setBoard_name(String board_name) {
		this.board_name = board_name;
	}
	public String getBoard_use() {
		return board_use;
	}
	public void setBoard_use(String board_use) {
		this.board_use = board_use;
	}
	public Date getBoard_date() {
		return board_date;
	}
	public void setBoard_date(Date board_date) {
		this.board_date = board_date;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	@Override
	public String toString() {
		return "BoardVo [board_id=" + board_id + ", board_name=" + board_name
				+ ", board_use=" + board_use + ", board_date=" + board_date
				+ ", userId=" + userId + "]";
	}
}