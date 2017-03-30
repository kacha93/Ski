package tn.esprit.services;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.entities.Restaurant;

@Local
public interface RestaurantServiceLocal {
		public void AddRestaurant(Restaurant r);
		 public void UpdateRestaurant(Restaurant r);
		 public void DeleteRestaurant(Restaurant r);
		 public List<Restaurant> findAll();
		 public Restaurant findById(Integer id);
		 public List<Restaurant> findByName(String name);
	}



