package de.nak.timetable.action;

import java.util.List;

import com.opensymphony.xwork2.Action;

import de.nak.timetable.model.Room;
import de.nak.timetable.service.RoomService;

/**
 * Action that shows a list of rooms.
 *
 * @author Paul Becker
 */
public class ShowRoomListAction implements Action{
	/** The list of rooms. */
	private List<Room> roomList;
	
	/** The room service. */
	private RoomService roomService;

	@Override
	public String execute() throws Exception {
		roomList = roomService.loadAllRooms();
		return SUCCESS;
	}

	public List<Room> getRoomList() {
		return roomList;
	}

	public void setRoomService(RoomService roomService) {
		this.roomService = roomService;
	}
}
