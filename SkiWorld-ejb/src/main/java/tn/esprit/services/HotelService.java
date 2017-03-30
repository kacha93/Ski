package tn.esprit.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.entities.Hotel;
import tn.esprit.entities.HotelRoom;

/**
 * Session Bean implementation class HotelService
 */
@Stateless
public class HotelService implements HotelServiceLocal {

	@PersistenceContext
	EntityManager em;
    public HotelService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void create(Hotel hotel) {
		em.persist(hotel);
		
	}

	@Override
	public void edit(Hotel hotel) {
		em.merge(hotel);
		
	}

	@Override
	public void delete(Hotel hotel) {
		em.remove(em.merge(em.merge(hotel)));
		
	}

	@Override
	public List<Hotel> findAll() {
		
		return em.createNamedQuery("Hotel.findAll", Hotel.class)
				.getResultList();
	}

	@Override
	public Hotel findById(int id) {
		
		return em.find(Hotel.class, id);
	}

}
