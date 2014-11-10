package de.nak.timetable.validators;

import java.util.Calendar;

import de.nak.timetable.model.Event;

/**
 * The Time Collision Validator
 * 
 * @author Jan-Hendrik Popp
 */
public class TimeCollisionValidator {

	/**
	 * Returns the event start.
	 * 
	 * @param event
	 *            The event.
	 */
	public Calendar getEventStart(Event event) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(event.getEventStart());
		return cal;
	}

	/**
	 * Returns the event end.
	 * 
	 * @param event
	 *            The event.
	 */
	public Calendar getEventEnd(Event event) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(event.getEventStart());
		cal.add(Calendar.MINUTE, event.getDuration());
		cal.add(Calendar.MINUTE, event.getChangeoverTime());
		return cal;
	}

	/**
	 * Checks a time collision
	 * 
	 * @param event
	 *            The event.
	 * @param start
	 *            startime.
	 * @param end
	 *            endtime.
	 * 
	 */
	public Boolean checkTimeCollision(Event event, Calendar start, Calendar end) {
		Calendar eventStart = getEventStart(event);
		Calendar eventEnd = getEventEnd(event);

		Integer rec = event.getWeeklyRecurrence();

		if (checkCollision(eventStart, eventEnd, start, end))
			return true;
		for (int i = 1; i <= rec; i++) {
			eventStart.add(Calendar.DATE, 7);
			eventEnd.add(Calendar.DATE, 7);
			if (checkCollision(eventStart, eventEnd, start, end))
				return true;
		}

		return false;
	}

	/**
	 * Checks a time collision
	 * 
	 * @param eStart
	 *            event start.
	 * @param eEnd
	 *            event end.
	 * @param start
	 *            startime.
	 * @param end
	 *            endtime.
	 * 
	 */
	private Boolean checkCollision(Calendar eStart, Calendar eEnd,
			Calendar start, Calendar end) {
		if (eStart.equals(start) || eEnd.equals(end)) {
			return true;
		}
		if (eStart.after(start) && eStart.before(end)) {
			return true;
		}
		if (eEnd.after(start) && eEnd.before(end)) {
			return true;
		}
		return false;
	}
}
