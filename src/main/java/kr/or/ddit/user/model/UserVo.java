package kr.or.ddit.user.model;

import java.util.Date;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserVo implements HttpSessionBindingListener {
	
	private Logger logger = LoggerFactory.getLogger(UserVo.class);
	
	private String userId;		// 사용자 아이디
	private String name;		// 사용자 이름
	private String pass;		// 사용자 비밀번호
	private String addr1;		// 사용자 주소
	private String addr2;		// 사용자 상세주소
	private String zipcd;		// 사용자 우편번호
	private String email;		// 사용자 이메일
	private String tel;			// 사용자 전화번호
	private String profile;		// 사용자 프로필
	private Date   birth;		// 사용자 생년월일
	private int	   rnum;		// 사용자 번호
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getAddr1() {
		return addr1;
	}
	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}
	public String getAddr2() {
		return addr2;
	}
	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}
	public String getZipcd() {
		return zipcd;
	}
	public void setZipcd(String zipcd) {
		this.zipcd = zipcd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public int getRnum() {
		return rnum;
	}
	public void setRnum(int rnum) {
		this.rnum = rnum;
	}
	
	@Override
	public String toString() {
		return "UserVo [userId=" + userId + ", name=" + name + ", pass=" + pass
				+ ", addr1=" + addr1 + ", addr2=" + addr2 + ", zipcd=" + zipcd
				+ ", email=" + email + ", tel=" + tel + ", profile=" + profile
				+ ", birth=" + birth + ", rnum=" + rnum + "]";
	}
	
	/**
	* Method : authPass
	* 작성자 : pc18
	* 변경이력 :
	* @param encrytPass
	* @return
	* Method 설명 : 비밀번호 검증
	 */
	public boolean authPass(String encrytPass){
		return getPass().equals(encrytPass);
	}
	
	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		// session객체에서 session.setAttribute("userVo", userVo)가 호출 되었을 때
		logger.debug("httpSessionBinding valueBound : " + event.getName());
		
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		// session객체에서 session.removeAttribute("userVo", userVo)가 호출 되었을 때
		logger.debug("httpSessionUnBinding valueUnBound : " + event.getName());
		
	}
}
