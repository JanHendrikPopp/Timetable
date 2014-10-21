package de.nak.timetable.model;

import javax.persistence.*;

/**
 * Lecturer entity.
 *
 * @author Jan-Hendrik Popp
 */
@Entity
public class Lecturer {
	/** The identifier. */
	private Long id;
	/** The lecturer's gender. */
	private String gender;
	/** The lecturer's title. */
	private String title;
	/** The lecturer's name. */
	private String name;
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
	
	@Column(length = 10, nullable = false)
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
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
	
	
}
