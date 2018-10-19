package kr.or.ddit.user.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.db.SqlFactoryBuilder;
import kr.or.ddit.user.model.UserVo;

public class UserDao implements UserDaoInf {
	
	/**
	* Method : selectUser
	* 작성자 : pc18
	* 변경이력 :
	* @param userId
	* @return
	* Method 설명 : 사용자 조회
	*/
	public UserVo selectUser(String userId){
		SqlSessionFactory sqlFactory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = sqlFactory.openSession();
		
		UserVo userVo = session.selectOne("user.selectUser", userId);
		session.close();
		return userVo;
	}
}
