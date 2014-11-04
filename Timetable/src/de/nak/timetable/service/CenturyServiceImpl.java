package de.nak.timetable.service;

import java.util.List;

import de.nak.timetable.dao.CenturyDAO;
import de.nak.timetable.model.Century;

/**
 * The century service implementation class.
 *
 * @author Paul Becker
 */
public class CenturyServiceImpl implements CenturyService{
	/** The century DAO. */
	private CenturyDAO centuryDAO;		
	
	@Override
	public void saveCentury(Century century) {
		centuryDAO.save(century);
	}

	@Override
	public Century loadCentury(Long id) {
		return centuryDAO.load(id);
	}

	@Override
	public void deleteCentury(Century century) {
		centuryDAO.delete(century);
	}

	@Override
	public List<Century> loadAllCenturies() {
		return centuryDAO.loadAll();
	}

	@Override
	public Boolean centuryExists(Century century) {
		List<Century> centuries = centuryDAO.loadAll();
		for (Century ctry : centuries) {
			if(century.equals(ctry)) {
				if(century.getId() != null && century.getId().equals(ctry.getId()))
					return false;
				else
					return true;
			}
		}
		return false;
	}
	
	public void setCenturyDAO(CenturyDAO centuryDAO) {
		this.centuryDAO = centuryDAO;
	}
	

}
