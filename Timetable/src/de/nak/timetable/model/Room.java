package de.nak.timetable.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

/**
 * Room entity.
 * 
 * @author Paul Becker
 */
@Entity
public class Room {
	/** The enum building */
	public enum Building {
		A, B, C, D, H
	}

	/** The enum room type */
	public enum RoomType {
		PC(15), LAB(0), LECT(0);
		/** The min chOvTim of the RoomType */
		private Integer minChangeOverTime;

		private RoomType(Integer time) {
			this.minChangeOverTime = time;
		}

		public Integer getMinChangeOverTime() {
			return minChangeOverTime;
		}
	}

	/** The identifier. */
	private Long id;
	private Building building;
	/** The room's name. */
	private String number;
	/** The room's capacity. */
	private Integer capacity;
	/** The room's type. */
	private RoomType type;
	/** The room's changeover Time. */
	private Integer changeoverTime = 15;
	/** The events of this room */
	private Set<Event> events;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Enumerated(EnumType.STRING)
	public Building getBuilding() {
		return building;
	}

	public void setBuilding(Building building) {
		this.building = building;
	}

	@Column(length = 10, nullable = false)
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	@Column(scale = 15, nullable = false)
	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	@Column(nullable = false)
	public RoomType getType() {
		return type;
	}

	public void setType(RoomType type) {
		this.type = type;
	}

	@Column(name = "changeover_time", scale = 15, nullable = false)
	public Integer getChangeoverTime() {
		return changeoverTime;
	}

	public void setChangeoverTime(Integer changeoverTime) {
		this.changeoverTime = changeoverTime;
	}

	@ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
	@JoinTable(name = "ROOM_EVENT", joinColumns = { @JoinColumn(name = "ROOM_ID") }, inverseJoinColumns = { @JoinColumn(name = "EVENT_ID") })
	public Set<Event> getEvents() {
		return events;
	}

	public void setEvents(Set<Event> events) {
		this.events = events;
	}

	public boolean changeOverTimeIsValid() {
		return (this.changeoverTime >= this.type.getMinChangeOverTime());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((building == null) ? 0 : building.hashCode());
		result = prime * result + ((number == null) ? 0 : number.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final Room other = (Room) obj;
		if (building == null) {
			if (other.building != null)
				return false;
		} else if (!building.equals(other.building))
			return false;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		return true;
	}

	/**
	 * Associates the given event to the room.
	 * 
	 * @param event
	 *            The event to associate.
	 */
	public void associateEvent(Event event) {
		if (event == null) {
			throw new IllegalArgumentException();
		}
		if (event.getRooms() == null) {
			event.setRooms(new HashSet<Room>());
		}
		if (event.getRooms().contains(this)) {
			event.getRooms().add(this);
		}
		if (!events.contains(event)) {
			events.add(event);
		}
	}

	/**
	 * Detaches event from this room.
	 */
	public void detachEvent(Event event) {
		if (event == null) {
			throw new IllegalArgumentException();
		}
		if (event.getRooms().contains(this)) {
			event.getRooms().remove(this);
		}
		events.remove(event);
	}

}
