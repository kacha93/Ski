package tn.esprit.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import tn.esprit.entities.User;

/**
 * Entity implementation class for Entity: Instructor
 *
 */
@Entity

public class Instructor extends User implements Serializable {

	private int experienceYears;
	private float salary;
	private List<Planning >plannings;
	private static final long serialVersionUID = 1L;

	public Instructor() {
		super();
	}

	public int getExperienceYears() {
		return experienceYears;
	}

	public void setExperienceYears(int experienceYears) {
		this.experienceYears = experienceYears;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	@OneToMany(mappedBy="instructor",
			cascade=CascadeType.ALL)
	public List<Planning> getPlannings() {
		return plannings;
	}

	public void setPlannings(List<Planning> plannings) {
		this.plannings = plannings;
	}
	
	
   
}
