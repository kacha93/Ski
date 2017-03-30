package tn.esprit.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import tn.esprit.entities.User;

/**
 * Entity implementation class for Entity: EventManager
 *
 */
@Entity

public class EventManager extends User implements Serializable {

	
	private int experienceYears;
	private List<Player> players ;
	private List<Event> events;
	private static final long serialVersionUID = 1L;

	public EventManager() {
		super();
	}   
	public int getExperienceYears() {
		return this.experienceYears;
	}

	public void setExperienceYears(int experienceYears) {
		this.experienceYears = experienceYears;
	}
	
	@OneToMany(mappedBy="eventManager",
			cascade=CascadeType.ALL)
	public List<Player> getPlayers() {
		return players;
	}
	public void setPlayers(List<Player> players) {
		this.players = players;
	}
	@OneToMany(mappedBy="eventManager",
			cascade=CascadeType.ALL)
	public List<Event> getEvents() {
		return events;
	}
	public void setEvents(List<Event> events) {
		this.events = events;
	}
	
	
   
}
