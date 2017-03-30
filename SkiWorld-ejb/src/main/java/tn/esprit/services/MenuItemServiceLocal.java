package tn.esprit.services;

import java.awt.MenuItem;
import java.util.List;

import javax.ejb.Local;

@Local
public interface MenuItemServiceLocal {
	public void AddMenuItem(MenuItem mi);
	 public void UpdateMenuItem(MenuItem mi);
	 public void DeleteMenuItem(MenuItem mi);
	 public List<MenuItem> findAll();
	 public MenuItem findById(Integer id);
	 public List<MenuItem> findByName(String name);
	

}
