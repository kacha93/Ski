package tn.esprit.services;

import java.util.List;

import javax.ejb.Singleton;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.entities.RestaurantTableReservation;

/**
 * Session Bean implementation class RestaurantTableReservationService
 */
@Singleton
public class RestaurantTableReservationService implements RestaurantTableReservationServiceLocal {
	@PersistenceContext
	EntityManager em;
    /**
     * Default constructor. 
     */
    public RestaurantTableReservationService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void AddRestaurantTableReservation(RestaurantTableReservation res) {
		em.persist(res);
		
	}

	@Override
	public void UpdateRestaurantTableReservation(RestaurantTableReservation res) {
		em.merge(res);
		
	}

	@Override
	public void DeleteRestaurantTableReservation(RestaurantTableReservation res) {
		em.remove(em.merge(res));
		
	}

	@Override
	public List<RestaurantTableReservation> findAll() {
		javax.persistence.Query q=em.createQuery("select e from RestaurantTableReservation e");
		return q.getResultList();
	}

}
