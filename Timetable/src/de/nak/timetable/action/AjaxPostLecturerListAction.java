package de.nak.timetable.action;

import java.util.LinkedHashMap;
import java.util.List;





import java.util.Map;

import com.opensymphony.xwork2.Action;

import de.nak.timetable.model.Lecturer;
import de.nak.timetable.service.LecturerService;

public class AjaxPostLecturerListAction implements Action {

	private Map<String, String> lecturerMaps = new LinkedHashMap<String, String>();
	
	private LecturerService lecturerService;

	@Override
	public String execute() throws Exception {
		List<Lecturer> lecturerList = lecturerService.loadAllLecturers();
		
		
		return SUCCESS;
	}

	public Map<String, String> getLecturerMap() {
		return lecturerMaps;
	}

	public void setLecturerMap(Map<String, String> lecturerMap) {
		this.lecturerMaps = lecturerMap;
	}

	public void setLecturerService(LecturerService lecturerService) {
		this.lecturerService = lecturerService;
	}
	
	
}
