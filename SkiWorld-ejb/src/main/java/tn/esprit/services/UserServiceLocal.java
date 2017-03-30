package tn.esprit.services;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.entities.User;

@Local
public interface UserServiceLocal {
	
	public void create(User user);
	public void edit (User user);
	public User findById(int id);
	public void delete(User user);
	public List<User> findAll();
	public User authenticate(String email,String password);

}
