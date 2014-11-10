package de.nak.timetable.service;

import de.nak.timetable.model.Room;

import java.util.Calendar;
import java.util.List;

/**
 * Room service interface.
 * 
 * @author Paul Becker
 */
public interface RoomService {

	/**
	 * Creates or updates a room.
	 * 
	 * @param room
	 *            The room.
	 */
	void saveRoom(Room room);

	/**
	 * Loads a single room.
	 * 
	 * @param id
	 *            The identifier.
	 * @return a room or null.
	 */
	Room loadRoom(Long id);

	/**
	 * Deletes the given room.
	 * 
	 * @param room
	 *            The room.
	 */
	void deleteRoom(Room room);

	/**
	 * Loads a list of all rooms.
	 * 
	 * @return a list which is empty if no room was found.
	 */
	List<Room> loadAllRooms();

	/**
	 * Returns free rooms out of rooms List.
	 * 
	 * @return a list which is empty if no free room was found.
	 */
	List<Room> getFreeRooms(List<Room> rooms, Calendar eStart, Calendar eEnd);

	/**
	 * Checkfs if a room exists.
	 * 
	 * @return a boolean.
	 */
	Boolean roomExists(Room room);

	/**
	 * Checkfs if a rooms changeovertime is valid.
	 * 
	 * @return a boolean.
	 */
	Boolean changeOverTimeIsValid(Room room);
}
