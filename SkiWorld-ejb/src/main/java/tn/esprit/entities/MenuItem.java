package tn.esprit.entities;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: MenuItem
 *
 */
@Entity

public class MenuItem implements Serializable {

	
	private int id;
	private String name;
	private String price;
	private boolean isAvailable;
	
	private Restaurant restaurant ;
	private static final long serialVersionUID = 1L;

	public MenuItem() {
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
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}   
	public String getPrice() {
		return this.price;
	}

	public void setPrice(String price) {
		this.price = price;
	}   
	public boolean getIsAvailable() {
		return this.isAvailable;
	}

	public void setIsAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	
	@ManyToOne
	public Restaurant getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
   
	
}
