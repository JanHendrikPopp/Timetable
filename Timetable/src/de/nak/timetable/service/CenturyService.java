package de.nak.timetable.service;

import de.nak.timetable.model.Century;

import java.util.List;

/**
 * Century service interface.
 *
 * @author Paul Becker
 */
public interface CenturyService {


	/**
	 * Creates or updates a century.
	 *
	 * @param century The century.
	 */
	void saveCentury(Century century);

	/**
	 * Loads a single century.
	 *
	 * @param id The identifier.
	 * @return a century or null.
	 */
	Century loadCentury(Long id);

	/**
	 * Deletes the given century.
	 *
	 * @param century The century.
	 */
	void deleteCentury(Century century);

	/**
	 * Loads a list of all centuries.
	 *
	 * @return a list which is empty if no century was found.
	 */
	List<Century> loadAllCenturies();
	
	/**
	 * Checkfs if a century exists.
	 *
	 * @return a boolean.
	 */
	Boolean centuryExists(Century century);
}
