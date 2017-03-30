package tn.esprit.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import tn.esprit.entities.User;

/**
 * Entity implementation class for Entity: RestaurantManager
 *
 */
@Entity

public class RestaurantManager extends User implements Serializable {

	
	private static final long serialVersionUID = 1L;
	private List<Restaurant>restaurants;

	public RestaurantManager() {
		super();
	}

	@OneToMany(mappedBy="restaurantManager",
			cascade=CascadeType.ALL)
	public List<Restaurant> getRestaurants() {
		return restaurants;
	}

	public void setRestaurants(List<Restaurant> restaurants) {
		this.restaurants = restaurants;
	}
	
	
   
}
