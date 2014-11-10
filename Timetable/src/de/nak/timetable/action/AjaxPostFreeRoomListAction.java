package de.nak.timetable.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.opensymphony.xwork2.Action;

import de.nak.timetable.model.Event;
import de.nak.timetable.model.Room;
import de.nak.timetable.service.RoomService;
import de.nak.timetable.validators.RoomCollisionValidator;

/**
 * Ajax Action for Free Room List.
 * 
 * @author Paul Becker
 */
public class AjaxPostFreeRoomListAction implements Action {
	/** The room list */
	private List<Room> roomList;
	/** The event duration */
	private Integer eventDuration;
	/** The event change over time */
	private Integer eventChangeOverTime;
	/** The event recurrence */
	private Integer eventWeeklyRecurrence;
	/** The event start */
	private String eventStart;
	/** The Room Service */
	private RoomService roomService;

	@Override
	public String execute() throws Exception {

		roomList = roomService.loadAllRooms();

		if (eventChangeOverTime == null) {
			eventChangeOverTime = 0;
		}
		if (eventDuration == null) {
			eventDuration = 0;
		}
		if (eventWeeklyRecurrence == null) {
			eventWeeklyRecurrence = 0;
		}

		SimpleDateFormat formatter;
		formatter = new SimpleDateFormat("dd.MM.yyyy HH:mm");
		Date date;

		try {
			date = formatter.parse(eventStart);
		} catch (ParseException e) {
			roomList = roomService.loadAllRooms();
			return SUCCESS;
		}

		Calendar eStart;
		Calendar eEnd;
		eStart = Calendar.getInstance();
		eEnd = Calendar.getInstance();
		eStart.setTime(date);
		eEnd.setTime(date);
		eEnd.add(Calendar.MINUTE, eventDuration);
		eEnd.add(Calendar.MINUTE, eventChangeOverTime);

		while (eventWeeklyRecurrence >= 0) {
			roomList = roomService.getFreeRooms(roomList, eStart, eEnd);
			eStart.add(Calendar.DATE, 7);
			eStart.add(Calendar.DATE, 7);
			eventWeeklyRecurrence--;
		}

		return SUCCESS;
	}

	public List<Room> getRoomList() {
		return roomList;
	}

	public void setRoomList(List<Room> roomList) {
		this.roomList = roomList;
	}

	public Integer getEventDuration() {
		return eventDuration;
	}

	public void setEventDuration(Integer eventDuration) {
		this.eventDuration = eventDuration;
	}

	public Integer getEventChangeOverTime() {
		return eventChangeOverTime;
	}

	public void setEventChangeOverTime(Integer eventChangeOverTime) {
		this.eventChangeOverTime = eventChangeOverTime;
	}

	public String getEventStart() {
		return eventStart;
	}

	public void setEventStart(String eventStart) {
		this.eventStart = eventStart;
	}

	public void setRoomService(RoomService roomService) {
		this.roomService = roomService;
	}

	public Integer getEventWeeklyRecurrence() {
		return eventWeeklyRecurrence;
	}

	public void setEventWeeklyRecurrence(Integer eventWeeklyRecurrence) {
		this.eventWeeklyRecurrence = eventWeeklyRecurrence;
	}

}
