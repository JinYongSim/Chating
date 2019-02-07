package com.scit.Chating.DAO;

import java.util.ArrayList;

import com.scit.Chating.VO.Chat;
import com.scit.Chating.VO.Room;

public interface RoomMapper {
	public int insertRoom(Room room); // 채팅방 만들기
	public ArrayList<Room> chattingRoomListAll(); // 채팅방 목록
	public Room entrance(String roomSeq); // 채팅방 입장
	
	public int insertMessage(Chat chat);
	public ArrayList<Chat> chattingList(String roomSeq);
}
