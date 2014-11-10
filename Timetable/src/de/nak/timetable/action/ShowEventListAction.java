package de.nak.timetable.action;

import java.util.List;

import com.opensymphony.xwork2.Action;

import de.nak.timetable.model.Event;
import de.nak.timetable.service.EventService;

/**
 * Action that shows a list of events.
 * 
 * @author Jan-Hendrik Popp
 */
public class ShowEventListAction implements Action {
	/** The list of events. */
	private List<Event> eventList;
	/** The event service. */
	private EventService eventService;

	@Override
	public String execute() throws Exception {
		eventList = eventService.loadAllEvents();
		return SUCCESS;
	}

	public List<Event> getEventList() {
		return eventList;
	}

	public void setEventService(EventService eventService) {
		this.eventService = eventService;
	}

}
