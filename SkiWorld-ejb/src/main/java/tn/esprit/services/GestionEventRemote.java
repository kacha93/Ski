package tn.esprit.services;

import java.util.List;

import tn.esprit.entities.Event;

public interface GestionEventRemote {
	public Boolean add(Event ev);
	public Boolean update(Event ev);
	public Event findById(int id);
	public Boolean delete(Event ev);
	public List<Event> findAll();

}
