package de.nak.timetable.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import de.nak.timetable.model.Event;
import de.nak.timetable.model.Lecturer;
import de.nak.timetable.service.CollisionService;
import de.nak.timetable.service.EventService;

public class EventAction extends ActionSupport{

	/** Serial version UID. */
	private static final long serialVersionUID = 1940905497184033698L;

	/** The current event. */
	private Event event;
	
	/** The event's identifier selected by the user. */
	private Long eventId;
	
	/** The event service. */
	private EventService eventService;
	
	/** The event service. */
	private CollisionService collisionService;
	
	/** */
	private Boolean proceed = false;
	
	/** */
	private Long lecturerId;
	
	/** */
	private String lecturerName;
	
	/**
	 * Saves the event to the database.
	 *
	 * @return the result string.
	 */
	public String save() {
		if(event.getId() != null) {
			Event dbEvent = eventService.loadEvent(event.getId());
			event.setLecturer(dbEvent.getLecturer());
		}
		
		eventService.saveEvent(event, lecturerId);
		return SUCCESS;
	}
	
	/**
	 * Deletes the selected event from the database.
	 *
	 * @return the result string.
	 */
	public String delete() {
		event = eventService.loadEvent(eventId);
		if(event != null) {
			eventService.deleteEvent(event);
		}
		return SUCCESS;
	}
	
	/**
	 * Displays the selected event in the event form.
	 *
	 * @return the result string.
	 */
	public String load() {
		event = eventService.loadEvent(eventId);
		if(event.getLecturer() != null) {
			Lecturer lecturer = event.getLecturer();
			lecturerId = lecturer.getId();
			lecturerName = lecturer.getTitle() + lecturer.getName();
		}
		return SUCCESS;
	}
	
	/**
	 * Cancels the editing.
	 * This method is implemented in order to avoid problems with parameter submit and validation.
	 * A direct link to the "ShowEventList" action does work but results in multiple stack traces in the
	 * application's log.
	 *
	 * @return the result string.
	 */
	public String cancel() {
		return SUCCESS;
	}
	
	@Override
	public void validate() {
		if(!proceed && event != null) {
			List<String> errors = collisionService.getAllCollisions(event, lecturerId);
			for (String error : errors) {
				addActionError(error);
			}
		}
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public Long getEventId() {
		return eventId;
	}

	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}

	public Boolean isProceed() {
		return proceed;
	}

	public void setProceed(Boolean proceed) {
		this.proceed = proceed;
	}

	public Long getLecturerId() {
		return lecturerId;
	}

	public String getLecturerName() {
		return lecturerName;
	}

	public void setLecturerName(String lecturerName) {
		this.lecturerName = lecturerName;
	}

	public void setLecturerId(Long lecturerId) {
		this.lecturerId = lecturerId;
	}

	public void setEventService(EventService eventService) {
		this.eventService = eventService;
	}

	public void setCollisionService(CollisionService collisionService) {
		this.collisionService = collisionService;
	}
	
	
	
}
