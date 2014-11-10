package de.nak.timetable.action;

import java.util.List;

import com.opensymphony.xwork2.Action;

import de.nak.timetable.model.Room;
import de.nak.timetable.service.RoomService;

/**
 * Ajax Action for Room List.
 * 
 * @author Paul Becker
 */
public class AjaxPostRoomListAction implements Action {
	/** The Room List */
	private List<Room> roomList;
	/** The Room Service */
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
