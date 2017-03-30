package tn.esprit.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.entities.Hotel;
import tn.esprit.entities.Parking;

/**
 * Session Bean implementation class ParkingService
 */
@Stateless
public class ParkingService implements ParkingServiceLocal {

    @PersistenceContext
    EntityManager em;
	/**
     * Default constructor. 
     */
    public ParkingService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void create(Parking parking) {
		em.persist(parking);
		
	}

	@Override
	public void edit(Parking parking) {
		em.merge(parking);
	}

	@Override
	public void delete(Parking parking) {
		em.remove(em.merge(parking));
	}

	@Override
	public List<Parking> findAll() {
		return em.createNamedQuery("Parkinf.findAll", Parking.class)
				.getResultList();
	}

	@Override
	public Parking findById(int id) {
		return em.find(Parking.class, id);
	}

	@Override
	public Parking findByHotel(Hotel hotel) {
		return null;
	}

}
