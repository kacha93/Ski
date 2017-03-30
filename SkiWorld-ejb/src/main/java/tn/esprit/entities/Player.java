package tn.esprit.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import tn.esprit.entities.User;

/**
 * Entity implementation class for Entity: Player
 *
 */
@Entity

public class Player extends User implements Serializable {
	
	private boolean isProfessional;
	private boolean isVip;
	private int experienceYears;
	
	private List<Claim>claims ;
	private List<PisteReservation>pisteReservations;
	
	private EventManager eventManager;

	
	private static final long serialVersionUID = 1L;

	public Player() {
		super();
	}

	public boolean isProfessional() {
		return isProfessional;
	}

	public void setProfessional(boolean isProfessional) {
		this.isProfessional = isProfessional;
	}

	public boolean isVip() {
		return isVip;
	}

	public void setVip(boolean isVip) {
		this.isVip = isVip;
	}

	public int getExperienceYears() {
		return experienceYears;
	}

	public void setExperienceYears(int experienceYears) {
		this.experienceYears = experienceYears;
	}

	@OneToMany(mappedBy="player",
			cascade=CascadeType.ALL)
	public List<Claim> getClaims() {
		return claims;
	}

	public void setClaims(List<Claim> claims) {
		this.claims = claims;
	}

	@OneToMany(mappedBy="player",
			cascade=CascadeType.ALL)
	public List<PisteReservation> getPisteReservations() {
		return pisteReservations;
	}

	public void setPisteReservations(List<PisteReservation> pisteReservations) {
		this.pisteReservations = pisteReservations;
	}

	@ManyToOne(cascade=CascadeType.ALL)
	public EventManager getEventManager() {
		return eventManager;
	}

	public void setEventManager(EventManager eventManager) {
		this.eventManager = eventManager;
	}

	
	
	
	
	
   
}
