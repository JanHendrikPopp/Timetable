package de.nak.timetable.action;

import java.util.Set;

import com.opensymphony.xwork2.Action;

import de.nak.timetable.model.Event;
import de.nak.timetable.model.Lecturer;
import de.nak.timetable.model.Room;
import de.nak.timetable.service.LecturerService;
import de.nak.timetable.service.RoomService;

/**
 * Action for Room Calender Events View.
 * 
 * @author Hendrik Heers
 */
public class AjaxGetRoomEventsAction implements Action {
	/** The Room Id */
	private Long roomId;
	/** The Set of Events */
	private Set<Event> events;
	/** The Room Service */
	private RoomService roomService;

	@Override
	public String execute() throws Exception {
		Room room = roomService.loadRoom(roomId);
		if (room != null) {
			events = room.getEvents();
		}
		return SUCCESS;
	}

	public Long getRoomId() {
		return roomId;
	}

	public void setRoomId(Long roomId) {
		this.roomId = roomId;
	}

	public Set<Event> getEvents() {
		return events;
	}

	public void setEvents(Set<Event> events) {
		this.events = events;
	}

	public void setRoomService(RoomService roomService) {
		this.roomService = roomService;
	}

}
