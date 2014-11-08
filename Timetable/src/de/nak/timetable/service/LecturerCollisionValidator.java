package de.nak.timetable.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import de.nak.timetable.model.Event;
import de.nak.timetable.model.Lecturer;
import de.nak.timetable.validators.TimeCollisionValidator;

public class LecturerCollisionValidator {

	private TimeCollisionValidator timeCollisionValidator;
	
	public List<String> validate(Event event, Lecturer lecturer) {
		List<String> errors = new ArrayList<String>();
		
		for(Event lecturerEvent : lecturer.getEvents()) {
			Calendar start = timeCollisionValidator.getEventStart(lecturerEvent);
			Calendar end = timeCollisionValidator.getEventEnd(lecturerEvent);
			
			Integer chOvTimeEvent = lecturerEvent.getChangeoverTime();
			Integer chOvTimeLecturer = lecturer.getChangeoverTime();
			if(chOvTimeEvent < chOvTimeLecturer) {
				end.add(Calendar.MINUTE, chOvTimeLecturer - chOvTimeEvent);
			}
			
			Integer rec = lecturerEvent.getWeeklyRecurrence();
			if(timeCollisionValidator.checkTimeCollision(event, start, end)) {
				if(!event.equals(lecturerEvent)) {
					errors.add(generateErrorMessage(lecturerEvent, lecturer));
				}
			}
			for(int i = 1; i<= rec; i++) {
				start.add(Calendar.DATE, 7);
				end.add(Calendar.DATE, 7);
				if(timeCollisionValidator.checkTimeCollision(event, start, end)) {
					if(!event.equals(lecturerEvent)) {
						errors.add(generateErrorMessage(lecturerEvent, lecturer));
					}
				}
			}
		}
		return errors;
	}

	public void setTimeCollisionValidator(TimeCollisionValidator timeCollisionValidator) {
		this.timeCollisionValidator = timeCollisionValidator;
	}
	
	private String generateErrorMessage(Event event, Lecturer lecturer) {
		Locale locale = Locale.getDefault();
		ResourceBundle bundle = ResourceBundle.getBundle("messages", locale);
		
		String error = bundle.getString("error.timeValidation.LecturerMessage");
		error = error + " " + bundle.getString("error.timeValidation.Lecturer");
		error = error + " " + bundle.getString("lbl." + lecturer.getGender());
		error = error + " " + lecturer.getTitle() + " " + lecturer.getName() + ". ";
		error = error + bundle.getString("error.timeValidation.Event");
		error = error + " " + event.getName();
		return error;
	}
	
	
}
