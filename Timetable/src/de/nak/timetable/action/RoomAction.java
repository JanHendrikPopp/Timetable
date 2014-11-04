package de.nak.timetable.action;

import com.opensymphony.xwork2.ActionSupport;

import de.nak.timetable.model.Room;
import de.nak.timetable.service.RoomService;


/**
 * Action for a single room.
 *
 * @author Paul Becker
 */
public class RoomAction extends ActionSupport{

	/** Serial version UID. */
	private static final long serialVersionUID = -5222756984777493393L;

	/** The current room. */
	private Room room;
	
	/** The room's identifier selected by the user. */
	private Long roomId;
	
	/** The room service. */
	private RoomService roomService;
	
	public String add() {
		room = new Room();
		return SUCCESS;
	}
	
	/**
	 * Saves the room to the database.
	 *
	 * @return the result string.
	 */
	public String save() {
		roomService.saveRoom(room);
		return SUCCESS;
	}
	
	/**
	 * Deletes the selected room from the database.
	 *
	 * @return the result string.
	 */
	public String delete() {
		room = roomService.loadRoom(roomId);
		if (room != null) {
			roomService.deleteRoom(room);
		}
		return SUCCESS;
	}
	
	/**
	 * Displays the selected room in the room form.
	 *
	 * @return the result string.
	 */
	public String load() {
		room = roomService.loadRoom(roomId);
		return SUCCESS;
	}
	
	
	/**
	 * Cancels the editing.
	 * This method is implemented in order to avoid problems with parameter submit and validation.
	 * A direct link to the "ShowRoomList" action does work but results in multiple stack traces in the
	 * application's log.
	 *
	 * @return the result string.
	 */
	public String cancel() {
		return SUCCESS;
	}
	
	@Override
	public void validate() {
		if(room != null) {
			if(roomService.roomExists(room)) {
				addActionError(getText("msg.validator.exists.room"));
			}
			if(!roomService.changeOverTimeIsValid(room)) {
				addActionError(getText("msg.validator.incorrect.pc.changeOverTime"));
			}
		}
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public Long getRoomId() {
		return roomId;
	}

	public void setRoomId(Long roomId) {
		this.roomId = roomId;
	}

	public void setRoomService(RoomService roomService) {
		this.roomService = roomService;
	}
	
}
