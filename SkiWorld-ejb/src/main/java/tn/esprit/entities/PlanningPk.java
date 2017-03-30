package tn.esprit.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class PlanningPk implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int instructorId;
	private int eventId;
	public int getInstructorId() {
		return instructorId;
	}
	public void setInstructorId(int instructorId) {
		this.instructorId = instructorId;
	}
	public int getEventId() {
		return eventId;
	}
	public void setEventId(int eventId) {
		this.eventId = eventId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + eventId;
		result = prime * result + instructorId;
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
		PlanningPk other = (PlanningPk) obj;
		if (eventId != other.eventId)
			return false;
		if (instructorId != other.instructorId)
			return false;
		return true;
	}
	public PlanningPk(int instructorId, int eventId) {
		super();
		this.instructorId = instructorId;
		this.eventId = eventId;
	}
	public PlanningPk() {
		super();
	}
	
	
	
	
}
