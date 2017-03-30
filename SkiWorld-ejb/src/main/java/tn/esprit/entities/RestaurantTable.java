package tn.esprit.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: RestaurantTable
 *
 */
@Entity

public class RestaurantTable implements Serializable {

	
	private int id;
	private int number;
	
	private Restaurant restaurant;
	private List<RestaurantTableReservation> restaurantTableReservations;
	private static final long serialVersionUID = 1L;

	public RestaurantTable() {
		super();
	}   
	@Id    
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	
	@ManyToOne
	public Restaurant getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
	
	@OneToMany(mappedBy="restaurantTable",
			cascade=CascadeType.ALL)
	public List<RestaurantTableReservation> getRestaurantTableReservations() {
		return restaurantTableReservations;
	}
	public void setRestaurantTableReservations(List<RestaurantTableReservation> restaurantTableReservations) {
		this.restaurantTableReservations = restaurantTableReservations;
	}
	
	
   
}
