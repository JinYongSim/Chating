package com.scit.Chating.DAO;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import com.scit.Chating.VO.Chat;
import com.scit.Chating.VO.Room;

@Repository
public class RoomDAO {
	@Autowired
	SqlSession sqlSession;
	// 채팅방 만들기
	public int insertRoom(Room room,Model model) {
		int result = 0;
		RoomMapper mapper = sqlSession.getMapper(RoomMapper.class);
		try {
			result = mapper.insertRoom(room);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("채팅방 등록 에러");
		}
		return result;
	}
	// 채팅방 목록
	public ArrayList<Room> chattingRoomListAll() {
		ArrayList<Room> room = null;
		RoomMapper mapper = sqlSession.getMapper(RoomMapper.class);
		try {
			room = mapper.chattingRoomListAll();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("채팅방 전체 목록 출력 에러");
		}
		return room;
	}
	// 채팅방 입장
	public Room entrance(String roomSeq) {
		Room room = null;
		RoomMapper mapper = sqlSession.getMapper(RoomMapper.class);
		try {
			room = mapper.entrance(roomSeq);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("채팅방 입장 에러");
		}
		return room;
	}
	
	public int insertMessage(Chat chat) {
		int result = 0;
		RoomMapper mapper = sqlSession.getMapper(RoomMapper.class);
		try {
			result = mapper.insertMessage(chat);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("채팅메시지 입력 에러");
		}
		return result;
	}
	
	public ArrayList<Chat> chattingList(String roomSeq){
		ArrayList<Chat> list = null;
		RoomMapper mapper = sqlSession.getMapper(RoomMapper.class);
		try {
			list = mapper.chattingList(roomSeq);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("채팅리스트 출력 에러");
		}
		return list;
	}
}
