package de.nak.timetable.action;

import java.util.Set;

import com.opensymphony.xwork2.Action;

import de.nak.timetable.model.Century;
import de.nak.timetable.model.Event;
import de.nak.timetable.service.CenturyService;

/**
 * Action for Century Calender Events View.
 * 
 * @author Hendrik Heers
 */
public class AjaxGetCenturyEventsAction implements Action {
	/** The century Id */
	private Long centuryId;
	/** The Set of events */
	private Set<Event> centuryEvents;
	/** The century Service */
	private CenturyService centuryService;

	@Override
	public String execute() throws Exception {
		Century century = centuryService.loadCentury(centuryId);
		if (century != null) {
			centuryEvents = century.getEvents();
		}
		return SUCCESS;
	}

	public Long getCenturyId() {
		return centuryId;
	}

	public void setCenturyId(Long centuryId) {
		this.centuryId = centuryId;
	}

	public Set<Event> getCenturyEvents() {
		return centuryEvents;
	}

	public void setCenturyEvents(Set<Event> centuryEvents) {
		this.centuryEvents = centuryEvents;
	}

	public void setCenturyService(CenturyService centuryService) {
		this.centuryService = centuryService;
	}

}
