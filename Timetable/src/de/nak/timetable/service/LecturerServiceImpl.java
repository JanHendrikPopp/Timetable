package de.nak.timetable.service;

import java.util.List;

import de.nak.timetable.dao.LecturerDAO;
import de.nak.timetable.model.Lecturer;

/**
 * The lecturer service implementation class.
 *
 * @author Jan-Hendrik Popp
 */
public class LecturerServiceImpl implements LecturerService{
	/** The lecturer DAO. */
	private LecturerDAO lecturerDAO;		
	
	@Override
	public void saveLecuter(Lecturer lecturer) {
		lecturerDAO.save(lecturer);
	}

	@Override
	public Lecturer loadLecturer(Long id) {
		return lecturerDAO.load(id);
	}

	@Override
	public void deleteLecturer(Lecturer lecturer) {
		lecturerDAO.delete(lecturer);
	}

	@Override
	public List<Lecturer> loadAllLecturers() {
		return lecturerDAO.loadAll();
	}

	@Override
	public Boolean lecturerExists(Lecturer lecturer) {
		List<Lecturer> lecturers = lecturerDAO.loadAll();
		for (Lecturer lec : lecturers) {
			if(lecturer.equals(lec)) {
				if(lecturer.getId() != null && lecturer.getId().equals(lec.getId()))
					return false;
				else
					return true;
			}
		}
		return false;
	}
	
	public void setLecturerDAO(LecturerDAO lecturerDAO) {
		this.lecturerDAO = lecturerDAO;
	}

}
