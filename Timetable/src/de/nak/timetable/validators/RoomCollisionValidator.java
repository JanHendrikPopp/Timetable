package de.nak.timetable.validators;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import de.nak.timetable.model.Event;
import de.nak.timetable.model.Lecturer;
import de.nak.timetable.model.Room;

public class RoomCollisionValidator {

	private TimeCollisionValidator timeCollisionValidator;
	
	public List<String> validate(Event event, Room room) {
		List<String> errors = new ArrayList<String>();
		
		for(Event roomEvent : room.getEvents()) {
			Calendar start = timeCollisionValidator.getEventStart(roomEvent);
			Calendar end = timeCollisionValidator.getEventEnd(roomEvent);
			
			Integer chOvTimeEvent = roomEvent.getChangeoverTime();
			Integer chOvTimeRoom = room.getChangeoverTime();
			if(chOvTimeEvent < chOvTimeEvent) {
				end.add(Calendar.MINUTE, chOvTimeRoom - chOvTimeEvent);
			}
			
			Integer rec = roomEvent.getWeeklyRecurrence();
			start.add(Calendar.DATE, -7);
			end.add(Calendar.DATE, -7);
			
			for(int i = 0; i<= rec; i++) {
				start.add(Calendar.DATE, 7);
				end.add(Calendar.DATE, 7);
				if(timeCollisionValidator.checkTimeCollision(event, start, end)) {
					if(!event.equals(roomEvent)) {
						errors.add(generateErrorMessage(roomEvent, room));
					}
				}
			}
		}		
		return errors;
	}

	public void setTimeCollisionValidator(
			TimeCollisionValidator timeCollisionValidator) {
		this.timeCollisionValidator = timeCollisionValidator;
	}
	
	private String generateErrorMessage(Event event, Room room) {
		Locale locale = Locale.getDefault();
		ResourceBundle bundle = ResourceBundle.getBundle("messages", locale);
		
		String error = bundle.getString("error.timeValidation.RoomMessage");
		error = error + " " + bundle.getString("error.timeValidation.Room");
		error = error + " " + room.getBuilding() + " " + room.getNumber() + ". ";
		error = error + bundle.getString("error.timeValidation.Event");
		error = error + " " + event.getName();
		return error;
	}
	
}
