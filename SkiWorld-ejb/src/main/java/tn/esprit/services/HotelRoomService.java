package tn.esprit.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.entities.HotelRoom;

/**
 * Session Bean implementation class HotelRoomService
 */
@Stateless
public class HotelRoomService implements HotelRoomServiceLocal{



	@PersistenceContext
	EntityManager em;
    public HotelRoomService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void create(HotelRoom hotelRoom) {
		em.persist(hotelRoom);
		
	}

	@Override
	public void edit(HotelRoom hotelRoom) {
		em.merge(hotelRoom);
		
	}

	@Override
	public void delete(HotelRoom hotelRoom) {
		em.remove(em.merge(hotelRoom));
		
	}

	@Override
	public HotelRoom findById(int id) {
		
		return em.find(HotelRoom.class, id);
	}

	@Override
	public List<HotelRoom> findAll() {


		return em.createNamedQuery("HotelRoom.findAll", HotelRoom.class)
				.getResultList();
	}

}
