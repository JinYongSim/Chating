package com.scit.Chating;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scit.Chating.DAO.RoomDAO;
import com.scit.Chating.VO.Chat;
import com.scit.Chating.VO.Room;

@Controller
public class RoomController {
	@Autowired
	RoomDAO dao;
		
	@RequestMapping(value="/goChattingList", method=RequestMethod.GET)
	public String goChattingList(Model model) {
		chattingList(model);
		return "chattingList";
	}
	
	
	@RequestMapping(value="/makeRoom", method=RequestMethod.POST)
	public String makeRoom(Room room, HttpSession session,Model model) {
		int result = 0;
		result = dao.insertRoom(room,model);
		if(result == 0) {
			return "chattingList";
		}
		room = chattingList(model).get(0);
		return "redirect:/entrance?roomSeq="+room.getRoomSeq();
	}
	
	public ArrayList<Room> chattingList(Model model) {
		ArrayList<Room> list = null;
		list = dao.chattingRoomListAll();
		model.addAttribute("list", list);
		return list;
	}
	
	@RequestMapping(value="/entrance", method=RequestMethod.GET)
	public String entrance(String roomSeq, Model model) {
		Room room  = null;
		room = dao.entrance(roomSeq);
		chatList(roomSeq,model);
		model.addAttribute("room", room);
		return "chattingRoom";
	}
	
	@RequestMapping(value="/insertMessage", method=RequestMethod.POST)
	public String insertMessage(Chat chat, Model model, HttpSession session) {
		chat.setUserId((String)session.getAttribute("loginId"));
		dao.insertMessage(chat);
		chatList(chat.getRoomSeq(),model);
		return "redirect:/entrance?roomSeq="+chat.getRoomSeq();
	}
	
	
	public void chatList(String roomSeq,Model model) {
		ArrayList<Chat> list = null;
		list = dao.chattingList(roomSeq);
		model.addAttribute("cList",list);
	}
	
	
}
