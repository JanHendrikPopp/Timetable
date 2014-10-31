package de.nak.timetable.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.validation.Errors;

import de.nak.timetable.dao.LecturerDAO;
import de.nak.timetable.model.Event;

/**
 * The collision service implementation class.
 *
 * @author Jan-Hendrik Popp
 */
public class CollisionServiceImpl implements CollisionService{

	private LecturerDAO lecturerDAO;
	
	private LecturerCollisionValidator lecturerValidator;
	
	@Override
	public List<String> getAllCollisions(Event event, Long lecturerId) {
		List<String> errors = new ArrayList<String>();
		
		if(lecturerId != null) {
			errors.addAll(lecturerValidator.validate(event, lecturerDAO.load(lecturerId)));
		}
		
		return errors;
	}

	public void setLecturerDAO(LecturerDAO lecturerDAO) {
		this.lecturerDAO = lecturerDAO;
	}

	public void setLecturerValidator(LecturerCollisionValidator lecturerValidator) {
		this.lecturerValidator = lecturerValidator;
	}
	
	

}
