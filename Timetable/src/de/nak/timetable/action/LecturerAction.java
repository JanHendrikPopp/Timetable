package de.nak.timetable.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import de.nak.timetable.model.Lecturer;
import de.nak.timetable.service.LecturerService;

/**
 * Action for a single lecturer.
 * 
 * @author Paul Becker
 */
public class LecturerAction extends ActionSupport {
	/** Serial version UID. */
	private static final long serialVersionUID = -6774504095899695654L;
	/** The current lecturer. */
	private Lecturer lecturer;
	/** The lecturer's identifier selected by the user. */
	private Long lecturerId;
	/** The lecturer service. */
	private LecturerService lecturerService;

	/**
	 * Initializes a new Lecturer.
	 * 
	 * @return the result string.
	 */
	public String add() {
		lecturer = new Lecturer();
		return SUCCESS;
	}

	/**
	 * Saves the lecturer to the database.
	 * 
	 * @return the result string.
	 */
	public String save() {
		lecturerService.saveLecuter(lecturer);
		return SUCCESS;
	}

	/**
	 * Deletes the selected lecturer from the database.
	 * 
	 * @return the result string.
	 */
	public String delete() {
		lecturer = lecturerService.loadLecturer(lecturerId);
		if (lecturer != null) {
			lecturerService.deleteLecturer(lecturer);
		}
		return SUCCESS;
	}

	/**
	 * Displays the selected lecturer in the lecturer form.
	 * 
	 * @return the result string.
	 */
	public String load() {
		lecturer = lecturerService.loadLecturer(lecturerId);
		return SUCCESS;
	}

	/**
	 * Cancels the editing. This method is implemented in order to avoid
	 * problems with parameter submit and validation. A direct link to the
	 * "ShowLecturerList" action does work but results in multiple stack traces
	 * in the application's log.
	 * 
	 * @return the result string.
	 */
	public String cancel() {
		return SUCCESS;
	}

	@Override
	public void validate() {
		if (lecturer != null) {
			if (lecturerService.lecturerExists(lecturer)) {
				addActionError(getText("msg.validator.exists.lecturer"));
			}
		}
	}

	public Lecturer getLecturer() {
		return lecturer;
	}

	public void setLecturer(Lecturer lecturer) {
		this.lecturer = lecturer;
	}

	public Long getLecturerId() {
		return lecturerId;
	}

	public void setLecturerId(Long lecturerId) {
		this.lecturerId = lecturerId;
	}

	public void setLecturerService(LecturerService lecturerService) {
		this.lecturerService = lecturerService;
	}

}
