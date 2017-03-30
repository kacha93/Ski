package tn.esprit.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.entities.User;

/**
 * Session Bean implementation class UserService
 */
@Stateless
public class UserService implements UserServiceLocal {

	@PersistenceContext
    EntityManager em;
    public UserService() {
       
    }

	@Override
	public void create(User user) {
		em.persist(user);
		
	}

	@Override
	public void edit(User user) {
		em.merge(user);
		
	}

	@Override
	public User findById(int id) {
		return em.find(User.class, id);
	}

	@Override
	public void delete(User user) {
		em.remove(em.merge(user));
		
	}

	@Override
	public List<User> findAll() {
		return  em.createNamedQuery("User.findAll", User.class)
		.getResultList();
		
	}

	@Override
	public User authenticate(String email, String password) {
		
		return em.createNamedQuery("User.findByCredentials", User.class)
				.setParameter("email", email)
				.setParameter("password", password)
				.getSingleResult();
	}

}
