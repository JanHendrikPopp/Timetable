package de.nak.timetable.service;

import de.nak.timetable.model.Lecturer;

import java.util.List;

/**
 * Lecturer service interface.
 *
 * @author Jan-Hendrik Popp
 */
public interface LecturerService {


	/**
	 * Creates or updates a lecturer.
	 *
	 * @param lecturer The lecturer.
	 */
	void saveLecuter(Lecturer lecturer);

	/**
	 * Loads a single lecturer.
	 *
	 * @param id The identifier.
	 * @return a lecturer or null.
	 */
	Lecturer loadLecturer(Long id);

	/**
	 * Deletes the given lecturer.
	 *
	 * @param lecturer The lecturer.
	 */
	void deleteLecturer(Lecturer lecturer);

	/**
	 * Loads a list of all lecturers.
	 *
	 * @return a list which is empty if no lecturer was found.
	 */
	List<Lecturer> loadAllLecturers();
}
