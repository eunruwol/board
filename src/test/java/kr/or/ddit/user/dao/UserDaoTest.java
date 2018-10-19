package kr.or.ddit.user.dao;

import static org.junit.Assert.*;
import kr.or.ddit.user.model.UserVo;

import org.junit.Before;
import org.junit.Test;

public class UserDaoTest {
	
	private UserDaoInf userDao;
	
	@Before
	public void setup(){
		userDao = new UserDao();
	}

	/**
	* Method : test
	* 작성자 : pc18
	* 변경이력 :
	* Method 설명 : 사용자 조회 테스트
	*/
	@Test
	public void selectUserTest() {
		/***Given***/
		String password = "brownpass";

		/***When***/
		UserVo userVo = userDao.selectUser(password);

		/***Then***/
		assertNotNull(userVo);
		assertEquals("brown", userVo.getUserId());
		assertEquals("브라운", userVo.getName());
		assertEquals("brownpass", userVo.getPass());
	}
}