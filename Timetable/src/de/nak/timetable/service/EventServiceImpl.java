package de.nak.timetable.service;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import de.nak.timetable.dao.CenturyDAO;
import de.nak.timetable.dao.EventDAO;
import de.nak.timetable.dao.LecturerDAO;
import de.nak.timetable.dao.RoomDAO;
import de.nak.timetable.model.Century;
import de.nak.timetable.model.Event;
import de.nak.timetable.model.Lecturer;
import de.nak.timetable.model.Room;

/**
 * The event service implementation class.
 *
 * @author Jan-Hendrik Popp
 */
public class EventServiceImpl implements EventService {
	/** The event DAO. */
	private EventDAO eventDAO;
	
	private LecturerDAO lecturerDAO;
	
	private RoomDAO roomDAO;
	
	private CenturyDAO centuryDAO;

	@Override
	public void saveEvent(Event event, Long lecturerId, List<Long> roomIds, List<Long> centuryIds) {
		if(event.getLecturer() != null) {
			event.getLecturer().detachEvent(event);
			eventDAO.save(event);
		}
		if(event.getRooms() != null) {
			detachRooms(event);
		}
		if(event.getCenturies() != null) {
			detachCenturies(event);
		}
		
		if(lecturerId != null) {
			Lecturer lecturer = lecturerDAO.load(lecturerId);
			if(lecturer != null) {
				lecturer.associateEvent(event);
				eventDAO.save(event);
			}
			eventDAO.save(event);
		}
		if(roomIds != null) {
			for(Long roomId : roomIds) {
				Room room = roomDAO.load(roomId);
				room.associateEvent(event);
			}
			eventDAO.save(event);
		}
		if(centuryIds != null) {
			for(Long centuryId : centuryIds) {
				Century century = centuryDAO.load(centuryId);
				century.associateEvent(event);
			}
		}
		eventDAO.save(event);
	}

	@Override
	public Event loadEvent(Long id) {
		return eventDAO.load(id);
	}

	@Override
	public void deleteEvent(Event event) {
		if(event.getRooms() != null) {
			detachRooms(event);
		}
		if(event.getCenturies() != null) {
			detachCenturies(event);
		}
		
		eventDAO.delete(event);
	}

	@Override
	public List<Event> loadAllEvents() {
		return eventDAO.loadAll();
	}
	
	private void detachRooms(Event event) {
		Set<Room> eventRooms = event.getRooms();
		Iterator<Room> roomIterator = eventRooms.iterator();
		
		while(roomIterator.hasNext()) {
			Room currentRoom = roomIterator.next();
			roomIterator.remove();
			currentRoom.detachEvent(event);
			roomDAO.save(currentRoom);
		}
		eventDAO.save(event);
	}

	private void detachCenturies(Event event) {
		Set<Century> eventCenturies = event.getCenturies();
		Iterator<Century> centuryIterator = eventCenturies.iterator();
		
		while(centuryIterator.hasNext()) {
			Century currentCentury = centuryIterator.next();
			centuryIterator.remove();
			currentCentury.detachEvent(event);
			centuryDAO.save(currentCentury);
		}
		eventDAO.save(event);
	}
	
	public void setEventDAO(EventDAO eventDAO) {
		this.eventDAO = eventDAO;
	}

	public void setLecturerDAO(LecturerDAO lecturerDAO) {
		this.lecturerDAO = lecturerDAO;
	}

	public void setRoomDAO(RoomDAO roomDAO) {
		this.roomDAO = roomDAO;
	}

	public void setCenturyDAO(CenturyDAO centuryDAO) {
		this.centuryDAO = centuryDAO;
	}

	@Override
	public Boolean changeOverTimeIsValid(Event event) {
		if(event.getChangeoverTime() != null && event.getType() != null) {
			return event.changeOverTimeIsValid();
		}
		return false;
	}
	
	
	
	
	
}
