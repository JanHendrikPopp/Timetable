package de.nak.timetable.service;

import java.util.List;

import de.nak.timetable.model.Event;

/**
 * Event service interface.
 *
 * @author Jan-Hendrik Popp
 */
public interface EventService {

	/**
	 * Creates or updates an event.
	 *
	 * @param event The event.
	 */
	void saveEvent(Event event);
	
	/**
	 * Loads a single event.
	 *
	 * @param id The identifier.
	 * @return a event or null.
	 */
	Event loadEvent(Long id);
	
	/**
	 * Deletes the given event.
	 *
	 * @param event The event.
	 */
	void deleteEvent(Event event);
	
	/**
	 * Loads a list of all events.
	 *
	 * @return a list which is empty if no event was found.
	 */
	List<Event> loadAllEvents();
}
