package tn.esprit.services;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.entities.RestaurantTableReservation;

@Local
public interface RestaurantTableReservationServiceLocal {
	public void AddRestaurantTableReservation(RestaurantTableReservation res);
	 public void UpdateRestaurantTableReservation(RestaurantTableReservation res);
	 public void DeleteRestaurantTableReservation(RestaurantTableReservation res);
	 public List<RestaurantTableReservation> findAll();
	

}
