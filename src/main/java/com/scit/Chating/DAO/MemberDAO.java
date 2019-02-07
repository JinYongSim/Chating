package com.scit.Chating.DAO;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {
	@Autowired
	SqlSession sqlSession;
	// 회원가입
	public int insertUser(HashMap<String,Object> Hmap) {
		int result = 0;
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		try {
			result = mapper.insertUser(Hmap);
		} catch (Exception e) {
			System.out.println("회원 등록 에러");
			e.printStackTrace();
		}
		return result;
	}
	// 로그인
	public HashMap<String,Object> login(HashMap<String,Object> Hmap){
		HashMap<String,Object> map = new HashMap<String,Object>();
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		try {
			map = mapper.login(Hmap);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("로그인 에러");
		}
		return map;
	}
}
