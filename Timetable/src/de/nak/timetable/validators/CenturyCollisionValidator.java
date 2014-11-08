package de.nak.timetable.validators;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import de.nak.timetable.model.Century;
import de.nak.timetable.model.Event;
import de.nak.timetable.model.Room;

public class CenturyCollisionValidator {

	private TimeCollisionValidator timeCollisionValidator;
	
	public List<String> validate(Event event, Century century) {
		List<String> errors = new ArrayList<String>();
		
		for(Event centuryEvent : century.getEvents()) {
			Calendar start = timeCollisionValidator.getEventStart(centuryEvent);
			Calendar end = timeCollisionValidator.getEventEnd(centuryEvent);
			
			Integer chOvTimeEvent = centuryEvent.getChangeoverTime();
			Integer chOvTimeCentury = century.getChangeoverTime();
			if(chOvTimeEvent < chOvTimeEvent) {
				end.add(Calendar.MINUTE, chOvTimeCentury - chOvTimeEvent);
			}
			
			Integer rec = centuryEvent.getWeeklyRecurrence();
			start.add(Calendar.DATE, -7);
			end.add(Calendar.DATE, -7);
			
			for(int i = 0; i<= rec; i++) {
				start.add(Calendar.DATE, 7);
				end.add(Calendar.DATE, 7);
				if(timeCollisionValidator.checkTimeCollision(event, start, end)) {
					if(!event.equals(centuryEvent)) {
						errors.add(generateErrorMessage(centuryEvent, century));
					}
				}
			}
		}		
		return errors;
	}
	
	private String generateErrorMessage(Event event, Century century) {
		Locale locale = Locale.getDefault();
		ResourceBundle bundle = ResourceBundle.getBundle("messages", locale);
		
		String error = bundle.getString("error.timeValidation.CenturyMessage");
		error = error + " " + bundle.getString("error.timeValidation.Century");
		error = error + " " + century.getMajor() + " " + century.getYear() + century.getCenturyChar() + ". ";
		error = error + bundle.getString("error.timeValidation.Event");
		error = error + " " + event.getName();
		return error;
	}

	public void setTimeCollisionValidator(
			TimeCollisionValidator timeCollisionValidator) {
		this.timeCollisionValidator = timeCollisionValidator;
	}
	
}
