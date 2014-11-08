package de.nak.timetable.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

/**
 * Century entity.
 *
 * @author Paul Becker
 */
@Entity
public class Century {
	
	public enum Major {
		A, I, B, W
	}
	
	public enum CenturyChar {
		A, B, C, D, E, F
	}
	
	/** The identifier. */
	private Long id;
	private Major major;
	private Integer year;
	private CenturyChar centuryChar;
	/** The century's size. */
	private Integer size;
	/** The century's changeover Time. */
	private Integer changeoverTime = 15;
	
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
	public Major getMajor() {
		return major;
	}

	public void setMajor(Major major) {
		this.major = major;
	}

	@Column(scale = 15, nullable = false)
	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	@Enumerated(EnumType.STRING)
	public CenturyChar getCenturyChar() {
		return centuryChar;
	}

	public void setCenturyChar(CenturyChar centuryChar) {
		this.centuryChar = centuryChar;
	}

	@Column(scale = 15, nullable = false)
	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}
	
	@Column(name = "changeover_time", scale = 15, nullable = false)
	public Integer getChangeoverTime() {
		return changeoverTime;
	}
	
	public void setChangeoverTime(Integer changeoverTime) {
		this.changeoverTime = changeoverTime;
	}
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinTable(name="CENTURY_EVENT",
                joinColumns={@JoinColumn(name="CENTURY_ID")},
                inverseJoinColumns={@JoinColumn(name="EVENT_ID")})
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
		result = prime * result + ((major == null) ? 0 : major.hashCode());
		result = prime * result + ((centuryChar == null) ? 0 : major.hashCode());
		result = prime * result + ((year == null) ? 0 : major.hashCode());
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
		final Century other = (Century) obj;
		if(major == null) {
			if(other.major != null)
				return false;
		} else if(!major.equals(other.major))
			return false;
		if(centuryChar == null) {
			if(other.centuryChar != null)
				return false;
		} else if(!centuryChar.equals(other.centuryChar))
			return false;
		if(year == null) {
			if(other.year != null)
				return false;
		} else if(!year.equals(other.year))
			return false;
		return true;
	}
	
	public void associateEvent(Event event) {
		if(event == null) {
			throw new IllegalArgumentException();
		}
		if(event.getCenturies() == null) {
			event.setCenturies(new HashSet<Century>());
		}
		if(event.getCenturies().contains(this)) {
			event.getCenturies().add(this);
		}
		if(!events.contains(event)) {
			events.add(event);
		}
	}
	
	public void detachEvent(Event event) {
		if(event == null) {
			throw new IllegalArgumentException();
		}
		if(event.getCenturies().contains(this)) {
			event.getCenturies().remove(this);
		}
		events.remove(event);
	}

}
