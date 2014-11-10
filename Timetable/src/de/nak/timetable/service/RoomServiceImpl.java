package de.nak.timetable.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import de.nak.timetable.dao.RoomDAO;
import de.nak.timetable.model.Event;
import de.nak.timetable.model.Room;

/**
 * The room service implementation class.
 * 
 * @author Paul Becker
 */
public class RoomServiceImpl implements RoomService {
	/** The room DAO. */
	private RoomDAO roomDAO;

	@Override
	public void saveRoom(Room room) {
		roomDAO.save(room);
	}

	@Override
	public Room loadRoom(Long id) {
		return roomDAO.load(id);
	}

	@Override
	public void deleteRoom(Room room) {
		roomDAO.delete(room);
	}

	@Override
	public List<Room> loadAllRooms() {
		return roomDAO.loadAll();
	}

	@Override
	public Boolean roomExists(Room room) {
		List<Room> rooms = roomDAO.loadAll();
		for (Room ro : rooms) {
			if (room.equals(ro)) {
				if (room.getId() != null && room.getId().equals(ro.getId()))
					return false;
				else
					return true;
			}
		}
		return false;
	}

	@Override
	public Boolean changeOverTimeIsValid(Room room) {
		if (room.getChangeoverTime() != null && room.getType() != null) {
			return room.changeOverTimeIsValid();
		}
		return false;
	}

	public void setRoomDAO(RoomDAO roomDAO) {
		this.roomDAO = roomDAO;
	}

	@Override
	public List<Room> getFreeRooms(List<Room> rooms, Calendar eStart,
			Calendar eEnd) {
		List<Room> toRemove = new ArrayList<Room>();

		for (Room currRoom : rooms) {
			for (Event event : currRoom.getEvents()) {
				Calendar start;
				Calendar end;
				start = Calendar.getInstance();
				end = Calendar.getInstance();

				start.setTime(event.getEventStart());
				end.setTime(event.getEventStart());
				end.add(Calendar.MINUTE, event.getDuration());
				end.add(Calendar.MINUTE, event.getChangeoverTime());

				if (checkCollision(eStart, eEnd, start, end)) {
					toRemove.add(currRoom);
				}
			}
		}
		for (Room room : toRemove) {
			if (rooms.contains(room)) {
				rooms.remove(room);
			}
		}

		return rooms;
	}

	/**
	 * Creates or updates an event.
	 * 
	 * @param eStart
	 *            The event's start.
	 * @param eEnd
	 *            The event's end.
	 * @param start
	 *            The start Time.
	 * @param end
	 *            The end Time.
	 * 
	 */
	private Boolean checkCollision(Calendar eStart, Calendar eEnd,
			Calendar start, Calendar end) {
		if (eStart.equals(start) || eEnd.equals(end)) {
			return true;
		}
		if (eStart.after(start) && eStart.before(end)) {
			return true;
		}
		if (eEnd.after(start) && eEnd.before(end)) {
			return true;
		}
		return false;
	}

}
