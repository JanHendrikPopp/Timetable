package de.nak.timetable.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import de.nak.timetable.model.Room;

/**
 * Room data access object.
 * 
 * @author Paul Becker
 */
public class RoomDAO {
	/** The Hibernate session factory. */
	private SessionFactory sessionFactory;

	/**
	 * Persists or merges the room into the database.
	 * 
	 * @param room
	 *            The room to persist. The given entity can be transient or
	 *            detached.
	 */
	public void save(Room room) {
		sessionFactory.getCurrentSession().saveOrUpdate(room);
	}

	/**
	 * Loads a single room entity from the database.
	 * 
	 * @param id
	 *            The identifier.
	 * @return a room or null if no room was found with the given identifier.
	 */
	public Room load(Long id) {
		return (Room) sessionFactory.getCurrentSession().get(Room.class, id);
	}

	/**
	 * Deletes the room from the database.
	 * 
	 * @param room
	 *            The room to be deleted.
	 */
	public void delete(Room room) {
		sessionFactory.getCurrentSession().delete(room);
	}

	/**
	 * Loads all rooms from the database.
	 * 
	 * @return a list or room which is empty if no room was found.
	 */
	@SuppressWarnings("unchecked")
	public List<Room> loadAll() {
		return sessionFactory.getCurrentSession().createQuery("from Room")
				.list();
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
