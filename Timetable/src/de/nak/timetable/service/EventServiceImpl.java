package de.nak.timetable.service;

import java.util.List;

import de.nak.timetable.dao.EventDAO;
import de.nak.timetable.model.Event;

/**
 * The event service implementation class.
 *
 * @author Jan-Hendrik Popp
 */
public class EventServiceImpl implements EventService {
	/** The event DAO. */
	private EventDAO eventDAO;

	@Override
	public void saveEvent(Event event) {
		eventDAO.save(event);
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
	
	
}
