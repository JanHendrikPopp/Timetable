package de.nak.timetable.model;

import java.util.Set;

import javax.persistence.*;

/**
 * Lecturer entity.
 *
 * @author Jan-Hendrik Popp
 */
@Entity
public class Lecturer {
	
	public enum Gender {
        MALE, FEMALE
    }
	
	/** The identifier. */
	private Long id;
	/** The lecturer's gender. */
	private Gender gender;
	/** The lecturer's title. */
	private String title;
	/** The lecturer's name. */
	private String name;
	/** The lecturer's changeover Time. */
	private Integer changeoverTime;
	/** The set of events */
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
	public Gender getGender() {
		return gender;
	}
	
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	
	@Column(length = 10, nullable = false)
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	@Column(length = 50, nullable = false)
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "changeover_time", scale = 15, nullable = false)
	public Integer getChangeoverTime() {
		return changeoverTime;
	}
	
	public void setChangeoverTime(Integer changeoverTime) {
		this.changeoverTime = changeoverTime;
	}
	
	@OneToMany(mappedBy = "lecturer")
	public Set<Event> getEvents() {
		return events;
	}

	public void setEvents(Set<Event> events) {
		this.events = events;
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
		final Lecturer other = (Lecturer) obj;
		if(title == null) {
			if(other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if(gender == null) {
			if(other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if(name == null) {
			if(other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	/**
	 * Associates the given event to the lecturer.
	 * 
	 * @param event
	 *            The event to associate.
	 */
	public void associateEvent(Event event) {
		if(event == null) {
			throw new IllegalArgumentException();
		}
		if(event.getLecturer() != null && event.getLecturer().getEvents() != null) {
			event.getLecturer().getEvents().remove(event);
		}
		if(!this.equals(event.getLecturer())) {
			event.setLecturer(this);
		}
		if(!events.contains(event)) {
			events.add(event);
		}
	}
	
	/**
	 * Detaches event from this lecturer.
	 */
	public void detachEvent(Event event) {
		if(event == null) {
			throw new IllegalArgumentException();
		}
		if(this.equals(event.getLecturer())) {
			event.setLecturer(null);
		}
		events.remove(event);
	}
	
	
}
