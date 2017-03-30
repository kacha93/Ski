package tn.esprit.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: RestaurantTableReservation
 *
 */
@Entity

public class RestaurantTableReservation implements Serializable {

	

	private RestaurantTableReservationPk pk;
	private Date reservationDate;
	private int customersNumber;
	
	private RestaurantTable restaurantTable;
	private Client client;
	private static final long serialVersionUID = 1L;

	public RestaurantTableReservation() {
		super();
	}
	
	@EmbeddedId
	public RestaurantTableReservationPk getPk() {
		return pk;
	}

	public void setPk(RestaurantTableReservationPk pk) {
		this.pk = pk;
	}

	public Date getReservationDate() {
		return reservationDate;
	}

	public void setReservationDate(Date reservationDate) {
		this.reservationDate = reservationDate;
	}

	public int getCustomersNumber() {
		return customersNumber;
	}

	public void setCustomersNumber(int customersNumber) {
		this.customersNumber = customersNumber;
	}

	@ManyToOne
	public RestaurantTable getRestaurantTable() {
		return restaurantTable;
	}

	public void setRestaurantTable(RestaurantTable restaurantTable) {
		this.restaurantTable = restaurantTable;
	}

	@ManyToOne
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	
	
	
   
}
