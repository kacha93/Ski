package tn.esprit.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import tn.esprit.entities.User;

/**
 * Entity implementation class for Entity: HotelManager
 *
 */
@Entity

public class HotelManager extends User implements Serializable {

	private int exprinceYears;
	
	private List<Hotel> hotel ;
	
	private static final long serialVersionUID = 1L;

	public HotelManager() {
		super();
	}

	public int getExprinceYears() {
		return exprinceYears;
	}

	public void setExprinceYears(int exprinceYears) {
		this.exprinceYears = exprinceYears;
	}

	@OneToMany(mappedBy="hotelManager",
			cascade=CascadeType.ALL)
	public List<Hotel> getHotel() {
		return hotel;
	}

	public void setHotel(List<Hotel> hotel) {
		this.hotel = hotel;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + exprinceYears;
		result = prime * result + ((hotel == null) ? 0 : hotel.hashCode());
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
		HotelManager other = (HotelManager) obj;
		if (exprinceYears != other.exprinceYears)
			return false;
		if (hotel == null) {
			if (other.hotel != null)
				return false;
		} else if (!hotel.equals(other.hotel))
			return false;
		return true;
	}
	
	
   
}
