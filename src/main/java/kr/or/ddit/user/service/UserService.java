package kr.or.ddit.user.service;

import kr.or.ddit.user.dao.UserDao;
import kr.or.ddit.user.model.UserVo;

public class UserService implements UserServiceInf {
	UserDao userDao = new UserDao();
	
	/**
	* Method : selectUser
	* 작성자 : pc18
	* 변경이력 :
	* @param userId
	* @return
	* Method 설명 : 사용자 조회
	*/
	@Override
	public UserVo selectUser(String userId){
		return userDao.selectUser(userId);
	}
}