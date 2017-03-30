package tn.esprit.services;

import java.util.List;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.entities.RestaurantTable;

/**
 * Session Bean implementation class RestaurantTableService
 */
@Singleton
public class RestaurantTableService implements  RestaurantTableServiceLocal {
	@PersistenceContext
	EntityManager em;
    /**
     * Default constructor. 
     */
    public RestaurantTableService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void AddRestaurant(RestaurantTable rt) {
		em.persist(rt);
		
	}

	@Override
	public void UpdateRestauran(RestaurantTable rt) {
		em.merge(rt);
		
	}

	@Override
	public void DeleteRestaurant(RestaurantTable rt) {
		em.remove(em.merge(rt));
		
	}

	@Override
	public List<RestaurantTable> findAll() {
		javax.persistence.Query q=em.createQuery("select e from RestaurantTable e");
		return q.getResultList();
	}

	@Override
	public RestaurantTable findById(Integer id) {
		RestaurantTable rt=em.find(RestaurantTable.class,id);
		return rt;
	}

	@Override
	public List<RestaurantTable> findByNumber(Integer number) {
		// TODO Auto-generated method stub
		return null;
	}

}
