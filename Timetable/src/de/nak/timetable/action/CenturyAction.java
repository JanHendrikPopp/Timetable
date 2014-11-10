package de.nak.timetable.action;

import com.opensymphony.xwork2.ActionSupport;

import de.nak.timetable.model.Century;
import de.nak.timetable.service.CenturyService;

/**
 * Action for a single century.
 * 
 * @author Paul Becker
 */
public class CenturyAction extends ActionSupport {
	/** Serial version UID. */
	private static final long serialVersionUID = 4484094623773750744L;
	/** The current century. */
	private Century century;
	/** The century's identifier selected by the user. */
	private Long centuryId;
	/** The century service. */
	private CenturyService centuryService;

	/**
	 * Initializes a new Century.
	 * 
	 * @return the result string.
	 */
	public String add() {
		century = new Century();
		return SUCCESS;
	}

	/**
	 * Saves the century to the database.
	 * 
	 * @return the result string.
	 */
	public String save() {
		centuryService.saveCentury(century);
		return SUCCESS;
	}

	/**
	 * Deletes the selected century from the database.
	 * 
	 * @return the result string.
	 */
	public String delete() {
		century = centuryService.loadCentury(centuryId);
		if (century != null) {
			centuryService.deleteCentury(century);
		}
		return SUCCESS;
	}

	/**
	 * Displays the selected century in the century form.
	 * 
	 * @return the result string.
	 */
	public String load() {
		century = centuryService.loadCentury(centuryId);
		return SUCCESS;
	}

	/**
	 * Cancels the editing. This method is implemented in order to avoid
	 * problems with parameter submit and validation. A direct link to the
	 * "ShowCenturyList" action does work but results in multiple stack traces
	 * in the application's log.
	 * 
	 * @return the result string.
	 */
	public String cancel() {
		return SUCCESS;
	}

	@Override
	public void validate() {
		if (century != null) {
			if (centuryService.centuryExists(century)) {
				addActionError(getText("msg.validator.exists.century"));
			}
		}
	}

	public Century getCentury() {
		return century;
	}

	public void setCentury(Century century) {
		this.century = century;
	}

	public Long getCenturyId() {
		return centuryId;
	}

	public void setCenturyId(Long centuryId) {
		this.centuryId = centuryId;
	}

	public void setCenturyService(CenturyService centuryService) {
		this.centuryService = centuryService;
	}

}
