package de.nak.timetable.service;

import java.util.ArrayList;
import java.util.List;

import de.nak.timetable.model.Event;

/**
 * The collision service implementation class.
 *
 * @author Jan-Hendrik Popp
 */
public class CollisionServiceImpl implements CollisionService{

	@Override
	public List<String> getAllCollisions(Event event) {
		List<String> errors = new ArrayList<String>();
		errors.add("Testfehler");
		return errors;
	}

}
