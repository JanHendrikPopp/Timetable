package de.nak.timetable.service;

import java.util.List;

import de.nak.timetable.dao.EventDAO;
import de.nak.timetable.dao.LecturerDAO;
import de.nak.timetable.model.Event;
import de.nak.timetable.model.Lecturer;

/**
 * The event service implementation class.
 *
 * @author Jan-Hendrik Popp
 */
public class EventServiceImpl implements EventService {
	/** The event DAO. */
	private EventDAO eventDAO;
	
	private LecturerDAO lecturerDAO;

	@Override
	public void saveEvent(Event event, Long lecturerId) {
		if(event.getLecturer() != null) {
			event.getLecturer().detachEvent(event);
			eventDAO.save(event);
		}
		if(lecturerId != null) {
			Lecturer lecturer = lecturerDAO.load(lecturerId);
			if(lecturer != null) {
				lecturer.associateEvent(event);
				eventDAO.save(event);
			}
		}
	}

	@Override
	public Event loadEvent(Long id) {
		return eventDAO.load(id);
	}

	@Override
	public void deleteEvent(Event event) {
		eventDAO.delete(event);
	}

	@Override
	public List<Event> loadAllEvents() {
		return eventDAO.loadAll();
	}

	public void setEventDAO(EventDAO eventDAO) {
		this.eventDAO = eventDAO;
	}

	public void setLecturerDAO(LecturerDAO lecturerDAO) {
		this.lecturerDAO = lecturerDAO;
	}
	
	
	
}
