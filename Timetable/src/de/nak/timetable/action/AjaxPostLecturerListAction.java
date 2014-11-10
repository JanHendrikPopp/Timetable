package de.nak.timetable.action;

import java.util.LinkedHashMap;
import java.util.List;

import java.util.Map;

import com.opensymphony.xwork2.Action;

import de.nak.timetable.model.Lecturer;
import de.nak.timetable.service.LecturerService;

/**
 * Ajax Action for Lecturer List.
 * 
 * @author Paul Becker
 */
public class AjaxPostLecturerListAction implements Action {
	/** The Lecturer List */
	private List<Lecturer> lecturerListAjax;
	/** The Lecturer Service */
	private LecturerService lecturerService;

	@Override
	public String execute() throws Exception {
		List<Lecturer> lecturerList = lecturerService.loadAllLecturers();
		lecturerListAjax = lecturerService.loadAllLecturers();

		return SUCCESS;
	}

	public void setLecturerService(LecturerService lecturerService) {
		this.lecturerService = lecturerService;
	}

	public List<Lecturer> getLecturerListAjax() {
		return lecturerListAjax;
	}

	public void setLecturerListAjax(List<Lecturer> lecturerListAjax) {
		this.lecturerListAjax = lecturerListAjax;
	}

}
