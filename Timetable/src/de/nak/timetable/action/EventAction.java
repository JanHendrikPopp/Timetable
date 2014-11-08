package de.nak.timetable.action;

import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import com.opensymphony.xwork2.ActionSupport;

import de.nak.timetable.model.Century;
import de.nak.timetable.model.Event;
import de.nak.timetable.model.Lecturer;
import de.nak.timetable.model.Room;
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
	
	private List<Long> roomIds;
	
	private List<Long> centuryIds;
	
	/** */
	private String lecturerName = "";
	
	private String roomNames = "";
	
	private String centuryNames ="";
	
	/**
	 * Saves the event to the database.
	 *
	 * @return the result string.
	 */
	public String save() {
		if(event.getId() != null) {
			Event dbEvent = eventService.loadEvent(event.getId());
			event.setRooms(dbEvent.getRooms());
			event.setLecturer(dbEvent.getLecturer());
		}
		
		eventService.saveEvent(event, lecturerId, roomIds, centuryIds);
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
		setTextDependences(event);
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
		if(event != null) {
			if(event != null && !eventService.changeOverTimeIsValid(event)) {
				addActionError(getText("msg.validator.incorrect.event.changeOverTime"));
			} else if(!proceed) {
				List<String> errors = collisionService.getAllCollisions(event, lecturerId, roomIds, centuryIds);
				for (String error : errors) {
					addActionError(error);
				}
			}
		}
	}
	
	private void setTextDependences(Event event) {
		if(event.getLecturer() != null) {
			Lecturer lecturer = event.getLecturer();
			lecturerId = lecturer.getId();
			lecturerName = lecturer.getTitle() + " " + lecturer.getName();
		}
		if(event.getRooms() != null) {
			for(Room room : event.getRooms()) {
				String roomName = room.getBuilding() + room.getNumber();
				roomNames = roomNames + " " + roomName;
			}
		}
		if(event.getCenturies() != null) {
			for(Century century : event.getCenturies()) {
				String centuryName = century.getMajor() + century.getYear().toString() + century.getCenturyChar();
				centuryNames = centuryNames + " " + centuryName;
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

	public List<Long> getRoomIds() {
		return roomIds;
	}

	public void setRoomIds(List<Long> roomIds) {
		this.roomIds = roomIds;
	}

	public List<Long> getCenturyIds() {
		return centuryIds;
	}

	public void setCenturyIds(List<Long> centuryIds) {
		this.centuryIds = centuryIds;
	}

	public String getRoomNames() {
		return roomNames;
	}

	public void setRoomNames(String roomNames) {
		this.roomNames = roomNames;
	}
	
	public String getCenturyNames() {
		return centuryNames;
	}

	public void setCenturyNames(String centuryNames) {
		this.centuryNames = centuryNames;
	}

	public void setEventService(EventService eventService) {
		this.eventService = eventService;
	}

	public void setCollisionService(CollisionService collisionService) {
		this.collisionService = collisionService;
	}
	
	
	
}
