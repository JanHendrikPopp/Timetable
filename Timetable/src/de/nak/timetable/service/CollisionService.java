package de.nak.timetable.service;

import java.util.List;

import de.nak.timetable.model.Event;

/**
 * Collision service interface.
 *
 * @author Jan-Hendrik Popp
 */
public interface CollisionService {

	
	/**
	 * Loads a list of all collisions.
	 *
	 * @return a list which is empty if no collision was found.
	 */
	List<String> getAllCollisions(Event event, Long lecturerId);
}
