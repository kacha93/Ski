package tn.esprit.services;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.entities.RestaurantTable;

@Local
public interface RestaurantTableServiceLocal {
	public void AddRestaurant(RestaurantTable rt);
	 public void UpdateRestauran(RestaurantTable rt);
	 public void DeleteRestaurant(RestaurantTable rt);
	 public List<RestaurantTable> findAll();
	 public RestaurantTable findById(Integer id);
	 public List<RestaurantTable> findByNumber(Integer number);

}
