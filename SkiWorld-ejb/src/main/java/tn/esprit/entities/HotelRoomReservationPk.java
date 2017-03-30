package tn.esprit.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;
@Embeddable
public class HotelRoomReservationPk implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int userId ; 
	private int hotelRoomId ;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getHotelRoomId() {
		return hotelRoomId;
	}
	public void setHotelRoomId(int hotelRoomId) {
		this.hotelRoomId = hotelRoomId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + hotelRoomId;
		result = prime * result + userId;
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
		HotelRoomReservationPk other = (HotelRoomReservationPk) obj;
		if (hotelRoomId != other.hotelRoomId)
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}
	public HotelRoomReservationPk() {
		super();
	}
	public HotelRoomReservationPk(int userId, int hotelRoomId) {
		super();
		this.userId = userId;
		this.hotelRoomId = hotelRoomId;
	} 
	

}
