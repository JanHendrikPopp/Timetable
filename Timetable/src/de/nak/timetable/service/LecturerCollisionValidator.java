package de.nak.timetable.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import de.nak.timetable.model.Event;
import de.nak.timetable.model.Lecturer;
import de.nak.timetable.validators.TimeCollisionValidator;

public class LecturerCollisionValidator {

	private TimeCollisionValidator timeCollisionValidator;
	
	public List<String> validate(Event event, Lecturer lecturer) {
		List<String> errors = new ArrayList<String>();
		
		for(Event lecturerEvent : lecturer.getEvents()) {
			Calendar start = Calendar.getInstance();
			Calendar end = Calendar.getInstance();
			
			start.setTime(lecturerEvent.getEventStart());
			end.setTime(lecturerEvent.getEventStart());
			end.add(Calendar.MINUTE, lecturerEvent.getDuration());
			end.add(Calendar.MINUTE, lecturerEvent.getChangeoverTime());
			
			if(timeCollisionValidator.checkTimeCollision(event, start, end)) {
				errors.add("Der Dozent " + lecturer.getName() + "hält bereits folgende Veranstaltung: " + lecturerEvent.getName());
			}
		}
		return errors;
	}

	public void setTimeCollisionValidator(TimeCollisionValidator timeCollisionValidator) {
		this.timeCollisionValidator = timeCollisionValidator;
	}
	
	
}
