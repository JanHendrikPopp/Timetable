	package de.nak.timetable.model;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	/** The identifier. */
	private Long id;
	/** The event's name. */
	private String name;
	/** The event's start. */
	private Date eventStart;
	/** The event's duration. */
	private Integer duration;
	/** The lecturer's changeover Time. */
	private Integer changeoverTime;
	
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
	
}
