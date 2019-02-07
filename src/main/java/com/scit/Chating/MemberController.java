package com.scit.Chating;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scit.Chating.DAO.MemberDAO;
@Controller
public class MemberController {
	@Autowired
	MemberDAO dao;
	
	// 회원가입 페이지 이동
	@RequestMapping(value="/goSignUp", method=RequestMethod.GET)
	public String goSignUp() {
		return "signUp";
	}
	
	// 회원가입
	@RequestMapping(value="/signUp", method=RequestMethod.POST)
	public String signUp(String userId,String userPw, Model model) {
		int result = 0;
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("userId", userId);
		map.put("userPw", userPw);
		result = dao.insertUser(map);
		if(result == 0) {
			return "signUp";
		}
		return "redirect:/";
	}
	
	// 로그인 페이지 이동
	@RequestMapping(value="/goLogin", method=RequestMethod.GET)
	public String goLogin() {
		return "login";
	}
	
	// 로그인
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login(String userId, String userPw, Model model, HttpSession session) {
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("userId", userId);
		map.put("userPw",userPw);
		map = dao.login(map);
		if(map == null) {
			model.addAttribute("loginErrorMessage", "아이디 혹은 비밀번호를 확인해주세요.");
			return "login";
		}
		session.setAttribute("loginId", userId);
		return "home";
	}
	
	// 로그아웃
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(HttpSession session) {
		session.setAttribute("loginId", null);
		return "home";
	}
}
