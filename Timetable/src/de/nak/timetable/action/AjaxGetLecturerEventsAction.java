package de.nak.timetable.action;

import java.util.List;
import java.util.Set;

import com.opensymphony.xwork2.Action;

import de.nak.timetable.model.Event;
import de.nak.timetable.model.Lecturer;
import de.nak.timetable.service.LecturerService;

public class AjaxGetLecturerEventsAction implements Action{

	private Long lecturerId;
	
	private Set<Event> lecturerEvents;
	
	private LecturerService lecturerService;

	@Override
	public String execute() throws Exception {
		Lecturer lecturer = lecturerService.loadLecturer(lecturerId);
		if(lecturer != null) {
			lecturerEvents = lecturer.getEvents();
		}
		return SUCCESS;
	}

	public Long getLecturerId() {
		return lecturerId;
	}

	public void setLecturerId(Long lecturerId) {
		this.lecturerId = lecturerId;
	}

	public Set<Event> getLecturerEvents() {
		return lecturerEvents;
	}

	public void setLecturerEvents(Set<Event> lecturerEvents) {
		this.lecturerEvents = lecturerEvents;
	}

	public void setLecturerService(LecturerService lecturerService) {
		this.lecturerService = lecturerService;
	}
	
	
	

}
