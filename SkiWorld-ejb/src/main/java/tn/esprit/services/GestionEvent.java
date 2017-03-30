package tn.esprit.services;



import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.entities.Event;




@Stateless
public class GestionEvent implements GestionEventRemote {

	@PersistenceContext
	EntityManager em;
   
    public GestionEvent() {
        
    }

	@Override
	public Boolean add(Event ev) {
		try {
			em.persist(ev);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Boolean update(Event ev) {
		try {
			em.merge(ev);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Event findById(int id) {
		return em.find(Event.class, id);
		 
	}

	@Override
	public Boolean delete(Event ev) {
		try {
			em.remove(em.merge(ev));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<Event> findAll() {
		return em.createQuery("select e from Event e").getResultList();
	}

}
