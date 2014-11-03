package de.nak.timetable.validators;

import java.util.Calendar;

import de.nak.timetable.model.Event;

public class TimeCollisionValidator {

	
	private Calendar getEventStart(Event event) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(event.getEventStart());
		return cal;
	}
	
	private Calendar getEventEnd(Event event) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(event.getEventStart());
		cal.add(Calendar.MINUTE, event.getDuration());
		cal.add(Calendar.MINUTE, event.getChangeoverTime());
		return cal;
	}
	
	public Boolean checkTimeCollision(Event event, Calendar start, Calendar end) {
		Calendar eventStart = getEventStart(event);
		Calendar eventEnd = getEventEnd(event);
		
		if(eventStart.equals(start) || eventEnd.equals(end)) {
			return true;
		}	
		if(eventStart.after(start) && eventStart.before(end)) {
			return true;
		}
		if(eventEnd.after(start) && eventEnd.before(end)) {
			return true;
		}
		return false;
	}
}
