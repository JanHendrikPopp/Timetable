package de.nak.timetable.action;

import java.util.List;

import com.opensymphony.xwork2.Action;

import de.nak.timetable.model.Century;
import de.nak.timetable.service.CenturyService;

/**
 * Ajax Action for Century List.
 * 
 * @author Paul Becker
 */
public class AjaxPostCenturyListAction implements Action{
	/** The century List*/
	private List<Century> centuryList;
	/** The Century Service */
	private CenturyService centuryService;
	
	@Override
	public String execute() throws Exception {
		centuryList = centuryService.loadAllCenturies();
		return SUCCESS;
	}

	public List<Century> getCenturyList() {
		return centuryList;
	}

	public void setCenturyList(List<Century> centuryList) {
		this.centuryList = centuryList;
	}

	public void setCenturyService(CenturyService centuryService) {
		this.centuryService = centuryService;
	}

}
