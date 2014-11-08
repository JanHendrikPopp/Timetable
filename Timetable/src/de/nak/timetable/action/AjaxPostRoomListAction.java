package de.nak.timetable.action;

import java.util.List;

import com.opensymphony.xwork2.Action;

import de.nak.timetable.model.Room;
import de.nak.timetable.service.RoomService;

public class AjaxPostRoomListAction implements Action{

	private List<Room> roomList;
	
	private RoomService roomService;
	
	@Override
	public String execute() throws Exception {
		roomList = roomService.loadAllRooms();
		return SUCCESS;
	}

	public List<Room> getRoomList() {
		return roomList;
	}

	public void setRoomList(List<Room> roomList) {
		this.roomList = roomList;
	}

	public void setRoomService(RoomService roomService) {
		this.roomService = roomService;
	}
	
}
