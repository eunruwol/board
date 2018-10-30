package kr.or.ddit.user.service;

import static org.junit.Assert.*;
import kr.or.ddit.user.model.UserVo;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class UserServiceTest {
	
	private UserServiceInf userService;
	
	@BeforeClass
	public static void beforeClass(){
		System.out.println("beforeClass");
	}
	
	@AfterClass
	public static void afterClass(){
		System.out.println("afterClass");
	}
	
	@Before
	public void before(){
		System.out.println("before");
		userService = new UserService();
	}
	
	@After
	public void after(){
		System.out.println("after");
	}
	
	/**
	* Method : test
	* 작성자 : iks
	* 변경이력 :
	* Method 설명 : 사용자 조회 테스트
	*/
	@Test
	public void test() {
		/***Given***/
		String userId = "brown";
		/***When***/
		UserVo result = userService.selectUser(userId);
		
		/***Then***/
		assertEquals("브라운", result.getName());
	}

}
