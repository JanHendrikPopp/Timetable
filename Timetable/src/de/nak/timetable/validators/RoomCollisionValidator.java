package de.nak.timetable.validators;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import de.nak.timetable.model.Event;
import de.nak.timetable.model.Lecturer;
import de.nak.timetable.model.Room;

/**
 * The Room Validator
 * 
 * @author Hendrik Heers
 */
public class RoomCollisionValidator {
	/** The time collision validator */
	private TimeCollisionValidator timeCollisionValidator;
	
	/**
	 * Validates the event <> room
	 * 
	 * @param event
	 *            The event.
	 * @param room
	 *            The room.
	 */
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
	
	
	/**
	 * Generates an error message.
	 * 
	 * @param event
	 *            The event.
	 * @param room
	 *            The room.
	 */
	private String generateErrorMessage(Event event, Room room) {
		Locale locale = Locale.getDefault();
		ResourceBundle bundle = ResourceBundle.getBundle("messages", locale);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		String error = bundle.getString("error.timeValidation.RoomMessage");
		error = error + " " + bundle.getString("error.timeValidation.Room");
		error = error + " " + room.getBuilding() + " " + room.getNumber() + ". ";
		error = error + bundle.getString("error.timeValidation.Event");
		error = error + " " + event.getName() + " - " + sdf.format(event.getEventStart());
		return error;
	}
	
}
