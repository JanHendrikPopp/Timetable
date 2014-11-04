package de.nak.timetable.service;

import java.util.List;

import de.nak.timetable.dao.RoomDAO;
import de.nak.timetable.model.Room;

/**
 * The room service implementation class.
 *
 * @author Paul Becker
 */
public class RoomServiceImpl implements RoomService{
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
			if(room.equals(ro)) {
				if(room.getId() != null && room.getId().equals(ro.getId()))
					return false;
				else
					return true;
			}
		}
		return false;
	}
	
	@Override
	public Boolean changeOverTimeIsValid(Room room) {
		if(room.getChangeoverTime() != null && room.getType() != null) {
			return room.changeOverTimeIsValid();
		}
		return false;
	}
	
	public void setRoomDAO(RoomDAO roomDAO) {
		this.roomDAO = roomDAO;
	}

}
