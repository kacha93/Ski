package tn.esprit.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Parking
 *
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Parking.findAll", query = "SELECT p FROM Parking p")})

public class Parking implements Serializable {

	
	private int id;
	private int placesNumber;
	private int occupiedPlaces;
	private Hotel hotel;
	private static final long serialVersionUID = 1L;

	public Parking() {
		super();
	}   
	@Id    
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public int getPlacesNumber() {
		return placesNumber;
	}
	public void setPlacesNumber(int placesNumber) {
		this.placesNumber = placesNumber;
	}
	public int getOccupiedPlaces() {
		return occupiedPlaces;
	}
	public void setOccupiedPlaces(int occupiedPlaces) {
		this.occupiedPlaces = occupiedPlaces;
	}
	
	@OneToOne(mappedBy="parking")
	public Hotel getHotel() {
		return hotel;
	}
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((hotel == null) ? 0 : hotel.hashCode());
		result = prime * result + id;
		result = prime * result + occupiedPlaces;
		result = prime * result + placesNumber;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Parking other = (Parking) obj;
		if (hotel == null) {
			if (other.hotel != null)
				return false;
		} else if (!hotel.equals(other.hotel))
			return false;
		if (id != other.id)
			return false;
		if (occupiedPlaces != other.occupiedPlaces)
			return false;
		if (placesNumber != other.placesNumber)
			return false;
		return true;
	}
	 
	
	
	
   
	
}
