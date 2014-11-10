package de.nak.timetable.action;

import java.util.List;

import com.opensymphony.xwork2.Action;

import de.nak.timetable.model.Century;
import de.nak.timetable.service.CenturyService;

/**
 * Action that shows a list of centuries.
 * 
 * @author Paul Becker
 */
public class ShowCenturyListAction implements Action {
	/** The list of centuries. */
	private List<Century> centuryList;
	/** The century service. */
	private CenturyService centuryService;

	@Override
	public String execute() throws Exception {
		centuryList = centuryService.loadAllCenturies();
		return SUCCESS;
	}

	public List<Century> getCenturyList() {
		return centuryList;
	}

	public void setCenturyService(CenturyService centuryService) {
		this.centuryService = centuryService;
	}
}
