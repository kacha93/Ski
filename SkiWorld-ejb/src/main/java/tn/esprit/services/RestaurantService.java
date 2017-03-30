package tn.esprit.services;

import java.util.List;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.entities.Restaurant;

/**
 * Session Bean implementation class RestaurantService
 */
@Singleton
public class RestaurantService implements RestaurantServiceLocal {
	@PersistenceContext
	EntityManager em;

    /**
     * Default constructor. 
     */
    public RestaurantService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void AddRestaurant(Restaurant r) {
		em.persist(r);
		
	}

	@Override
	public void UpdateRestaurant(Restaurant r) {
		em.merge(r);
	}

	@Override
	public void DeleteRestaurant(Restaurant r) {
		em.remove(em.merge(r));
		
	}

	@Override
	public List<Restaurant> findAll() {
		javax.persistence.Query q=em.createQuery("select e from Restaurant e");
		return q.getResultList();
	}

	@Override
	public Restaurant findById(Integer id) {
		Restaurant r=em.find(Restaurant.class,id);
		return r;
	}

	@Override
	public List<Restaurant> findByName(String name) {
		javax.persistence.Query query = em.createQuery("SELECT c FROM Restaurant c where c.name like:delice ")
				.setParameter("delice", name);
		List<Restaurant> neg = query.getResultList();
		return neg;
	}

}
