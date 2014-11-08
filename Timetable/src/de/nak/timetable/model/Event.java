	package de.nak.timetable.model;

import java.util.Calendar;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;


/**
 * Event entity.
 *
 * @author Jan-Hendrik Popp
 */
@Entity
public class Event {
	
	public enum EventType {
		LECT(0), SEM(0), EXAM(30);
		
		private Integer minChangeOverTime;
		
		private EventType(Integer time) {
			this.minChangeOverTime = time;
		}
		
		public Integer getMinChangeOverTime() {
			return minChangeOverTime;
		}
	}
	
	/** The identifier. */
	private Long id;
	/** The event's name. */
	private String name;
	private EventType type;
	/** The event's start. */
	private Date eventStart;
	/** The event's duration. */
	private Integer duration;
	/** The lecturer's changeover Time. */
	private Integer changeoverTime;
	/** wöch. Wiederhl. */
	private Integer weeklyRecurrence;
	/** The lecturer */
	private Lecturer lecturer;
	
	private Set<Room> rooms;
	
	private Set<Century> centuries;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(length = 20, nullable = false)
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Enumerated(EnumType.STRING)
	public EventType getType() {
		return type;
	}

	public void setType(EventType type) {
		this.type = type;
	}

	@Type(type="timestamp")
	@Column(name = "event_start", nullable = false)
	public Date getEventStart() {
		return eventStart;
	}
	
	public void setEventStart(Date eventStart) {
		this.eventStart = eventStart;
	}
	
	@Column(nullable = false)
	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	@Column(name = "changeover_time", scale = 15, nullable = false)
	public Integer getChangeoverTime() {
		return changeoverTime;
	}
	
	public void setChangeoverTime(Integer changeoverTime) {
		this.changeoverTime = changeoverTime;
	}
	
	@Column(name = "weekly_recurrence", scale = 2, nullable = false)
	public Integer getWeeklyRecurrence() {
		return weeklyRecurrence;
	}

	public void setWeeklyRecurrence(Integer weeklyRecurrence) {
		this.weeklyRecurrence = weeklyRecurrence;
	}

	@ManyToOne
	@JoinColumn(name = "LECTURER_ID")
	public Lecturer getLecturer() {
		return lecturer;
	}

	public void setLecturer(Lecturer lecturer) {
		this.lecturer = lecturer;
	}
	
	@ManyToMany(fetch = FetchType.EAGER, mappedBy="events")
	public Set<Room> getRooms() {
		return rooms;
	}

	public void setRooms(Set<Room> rooms) {
		this.rooms = rooms;
	}

	@ManyToMany(fetch = FetchType.EAGER, mappedBy="events")
	public Set<Century> getCenturies() {
		return centuries;
	}

	public void setCenturies(Set<Century> centuries) {
		this.centuries = centuries;
	}

	
	public boolean changeOverTimeIsValid() {
		return(this.changeoverTime >= this.type.getMinChangeOverTime());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		if(obj == null)
			return false;
		if(getClass() != obj.getClass())
			return false;
		final Event other = (Event) obj;
		if(id == null) {
			if(other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
