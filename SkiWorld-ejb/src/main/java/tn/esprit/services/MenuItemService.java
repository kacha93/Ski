package tn.esprit.services;

import java.awt.MenuItem;
import java.util.List;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


/**
 * Session Bean implementation class MenuItemService
 */
@Singleton
public class MenuItemService implements MenuItemServiceLocal {
	@PersistenceContext
	EntityManager em;

    /**
     * Default constructor. 
     */
    public MenuItemService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void AddMenuItem(MenuItem mi) {
		em.persist(mi);
		
	}

	@Override
	public void UpdateMenuItem(MenuItem mi) {
		em.merge(mi);
		
	}

	@Override
	public void DeleteMenuItem(MenuItem mi) {
		em.remove(em.merge(mi));
		
	}

	@Override
	public List<MenuItem> findAll() {
		javax.persistence.Query q=em.createQuery("select e from MenuItem e");
		return q.getResultList();
	}

	@Override
	public MenuItem findById(Integer id) {
		MenuItem mi=em.find(MenuItem.class,id);
		return mi;
	}

	@Override
	public List<MenuItem> findByName(String name) {
		javax.persistence.Query query = em.createQuery("SELECT c FROM MenuItem c where c.name like:Mjour ")
				.setParameter("Mjour", name);
		List<MenuItem> neg = query.getResultList();
		return neg;
	}

}
