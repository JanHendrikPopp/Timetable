package de.nak.timetable.model;

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

}
