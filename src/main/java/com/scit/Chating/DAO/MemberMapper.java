package com.scit.Chating.DAO;

import java.util.HashMap;

public interface MemberMapper {
	public int insertUser(HashMap<String,Object> Hmap);
	public HashMap<String,Object> login(HashMap<String,Object> Hmap);
}
