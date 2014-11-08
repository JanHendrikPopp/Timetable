package de.nak.timetable.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.validation.Errors;

import de.nak.timetable.dao.CenturyDAO;
import de.nak.timetable.dao.LecturerDAO;
import de.nak.timetable.dao.RoomDAO;
import de.nak.timetable.model.Event;
import de.nak.timetable.validators.CenturyCollisionValidator;
import de.nak.timetable.validators.RoomCollisionValidator;

/**
 * The collision service implementation class.
 *
 * @author Jan-Hendrik Popp
 */
public class CollisionServiceImpl implements CollisionService{

	private LecturerDAO lecturerDAO;
	
	private RoomDAO roomDAO;
	
	private CenturyDAO centuryDAO;
	
	private LecturerCollisionValidator lecturerValidator;
	
	private RoomCollisionValidator roomValidator;
	
	private CenturyCollisionValidator centuryValidator;
	
	@Override
	public List<String> getAllCollisions(Event event, Long lecturerId, List<Long> roomIds, List<Long> centuryIds) {
		List<String> errors = new ArrayList<String>();
		
		if(lecturerId != null) {
			errors.addAll(lecturerValidator.validate(event, lecturerDAO.load(lecturerId)));
		}
		
		if(roomIds != null) {
			for(Long id : roomIds) {
				errors.addAll(roomValidator.validate(event, roomDAO.load(id)));
			}
		}
		
		if(centuryIds != null) {
			for(Long id : centuryIds) {
				errors.addAll(centuryValidator.validate(event, centuryDAO.load(id)));
			}
		}
	
		return errors;
	}

	public void setLecturerDAO(LecturerDAO lecturerDAO) {
		this.lecturerDAO = lecturerDAO;
	}

	public void setRoomDAO(RoomDAO roomDAO) {
		this.roomDAO = roomDAO;
	}
	
	public void setCenturyDAO(CenturyDAO centuryDAO) {
		this.centuryDAO = centuryDAO;
	}

	public void setCenturyValidator(CenturyCollisionValidator centuryValidator) {
		this.centuryValidator = centuryValidator;
	}

	public void setRoomValidator(RoomCollisionValidator roomValidator) {
		this.roomValidator = roomValidator;
	}

	public void setLecturerValidator(LecturerCollisionValidator lecturerValidator) {
		this.lecturerValidator = lecturerValidator;
	}
	
	

}
