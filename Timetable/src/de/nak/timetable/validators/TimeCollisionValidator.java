package de.nak.timetable.validators;

import java.util.Calendar;

import de.nak.timetable.model.Event;

public class TimeCollisionValidator {

	
	public Calendar getEventStart(Event event) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(event.getEventStart());
		return cal;
	}
	
	public Calendar getEventEnd(Event event) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(event.getEventStart());
		cal.add(Calendar.MINUTE, event.getDuration());
		cal.add(Calendar.MINUTE, event.getChangeoverTime());
		return cal;
	}
	
	public Boolean checkTimeCollision(Event event, Calendar start, Calendar end) {
		Calendar eventStart = getEventStart(event);
		Calendar eventEnd = getEventEnd(event);
		
		Integer rec = event.getWeeklyRecurrence();
		
		if(checkCollision(eventStart, eventEnd, start, end))
			return true;
		for (int i = 1; i <= rec; i++) {
			eventStart.add(Calendar.DATE, 7);
			eventEnd.add(Calendar.DATE, 7);
			if(checkCollision(eventStart, eventEnd, start, end))
				return true;
		}
		
		return false;
	}
	
	private Boolean checkCollision(Calendar eStart, Calendar eEnd, Calendar start, Calendar end) {
		if(eStart.equals(start) || eEnd.equals(end)) {
			return true;
		}	
		if(eStart.after(start) && eStart.before(end)) {
			return true;
		}
		if(eEnd.after(start) && eEnd.before(end)) {
			return true;
		}
		return false;
	}
}
