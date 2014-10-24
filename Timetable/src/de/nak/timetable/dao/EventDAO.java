package de.nak.timetable.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import de.nak.timetable.model.Event;
import de.nak.timetable.model.Lecturer;

/**
 * Event data access object.
 *
 * @author Jan-Hendrik Popp
 */
public class EventDAO {
	/** The Hibernate session factory. */
	private SessionFactory sessionFactory;
	
	private LecturerDAO lecturerDAO;
	
	/**
	 * Persists or merges the event into the database.
	 *
	 * @param event The event to persist. The given entity can be transient or detached.
	 */
	public void save(Event event) {
		Lecturer lecturer = lecturerDAO.load(event.getLecturer().getId());
		
		//associate the event to the lecturer
		lecturer.associateEvent(event);
		
		//save the event
		sessionFactory.getCurrentSession().saveOrUpdate(event);
	}
	
	/**
	 * Loads a single event entity from the database.
	 *
	 * @param id The identifier.
	 * @return a event or null if no event was found with the given identifier.
	 */
	public Event load(Long id) {
		return (Event) sessionFactory.getCurrentSession().get(Event.class, id);
	}
	
	/**
	 * Deletes the event from the database.
	 *
	 * @param event The event to be deleted.
	 */
	public void delete(Event event) {
		if(event.getLecturer() != null) {
			event.getLecturer().detachEvent(event);
		}
		sessionFactory.getCurrentSession().delete(event);
	}
	
	/**
	 * Loads all events from the database.
	 *
	 * @return a list or event which is empty if no event was found.
	 */
	@SuppressWarnings("unchecked")
	public List<Event> loadAll() {
		return sessionFactory.getCurrentSession().createQuery("from Event").list();
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void setLecturerDAO(LecturerDAO lecturerDAO) {
		this.lecturerDAO = lecturerDAO;
	}
	
	
}
