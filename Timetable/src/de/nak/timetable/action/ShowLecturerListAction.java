package de.nak.timetable.action;

import java.util.List;

import com.opensymphony.xwork2.Action;

import de.nak.timetable.model.Lecturer;
import de.nak.timetable.service.LecturerService;

/**
 * Action that shows a list of lecturers.
 * 
 * @author Paul Becker
 */
public class ShowLecturerListAction implements Action {
	/** The list of lecturers. */
	private List<Lecturer> lecturerList;
	/** The lecturer service. */
	private LecturerService lecturerService;

	@Override
	public String execute() throws Exception {
		lecturerList = lecturerService.loadAllLecturers();
		return SUCCESS;
	}

	public List<Lecturer> getLecturerList() {
		return lecturerList;
	}

	public void setLecturerService(LecturerService lecturerService) {
		this.lecturerService = lecturerService;
	}
}
