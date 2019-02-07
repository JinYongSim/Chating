package com.scit.Chating.VO;

public class Room {
	private String RoomSeq;
	private String userId;
	private String name;
	private String indate;
	
	public Room() {
	
	}

	public Room(String roomSeq, String userId, String name, String indate) {
		super();
		RoomSeq = roomSeq;
		this.userId = userId;
		this.name = name;
		this.indate = indate;
	}

	public String getRoomSeq() {
		return RoomSeq;
	}

	public void setRoomSeq(String roomSeq) {
		RoomSeq = roomSeq;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIndate() {
		return indate;
	}

	public void setIndate(String indate) {
		this.indate = indate;
	}

	@Override
	public String toString() {
		return "RoomVO [RoomSeq=" + RoomSeq + ", userId=" + userId + ", name=" + name + ", indate=" + indate + "]";
	}
	
	
}
