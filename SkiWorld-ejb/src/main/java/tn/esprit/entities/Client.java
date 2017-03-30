package tn.esprit.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import tn.esprit.entities.User;

/**
 * Entity implementation class for Entity: Client
 *
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Client.findAll", query = "SELECT c FROM Client c"),
    @NamedQuery(name = "Client.findByCardNumber", query = "SELECT c FROM Client c WHERE c.cardNumber = :cardNumber"),
  })
public class Client extends User implements Serializable {

	
	private String cardNumber ;
	private List<PurchaseDetail> purchaseDetails;
	private List<Claim> claims;
	private List <HotelRoomReservation> hotelRoomReservations;
	private List<RestaurantTableReservation> restaurantTableReservations;
	private static final long serialVersionUID = 1L;

	public Client() {
		super();
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	
	@OneToMany(mappedBy="client",
			cascade=CascadeType.ALL)
	public List<PurchaseDetail> getPurchaseDetails() {
		return purchaseDetails;
	}

	public void setPurchaseDetails(List<PurchaseDetail> purchaseDetails) {
		this.purchaseDetails = purchaseDetails;
	}

	@OneToMany(mappedBy="client",
			cascade=CascadeType.ALL)
	public List<Claim> getClaims() {
		return claims;
	}

	public void setClaims(List<Claim> claims) {
		this.claims = claims;
	}

	@OneToMany(mappedBy="client",
			cascade=CascadeType.ALL)
	public List<HotelRoomReservation> getHotelRoomReservations() {
		return hotelRoomReservations;
	}

	public void setHotelRoomReservations(List<HotelRoomReservation> hotelRoomReservations) {
		this.hotelRoomReservations = hotelRoomReservations;
	}

	@OneToMany(mappedBy="client",
			cascade=CascadeType.ALL)
	public List<RestaurantTableReservation> getRestaurantTableReservations() {
		return restaurantTableReservations;
	}

	public void setRestaurantTableReservations(List<RestaurantTableReservation> restaurantTableReservations) {
		this.restaurantTableReservations = restaurantTableReservations;
	}
	
	
	
	
   
}
