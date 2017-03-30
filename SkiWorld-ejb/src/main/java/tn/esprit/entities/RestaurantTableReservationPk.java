package tn.esprit.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class RestaurantTableReservationPk implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int tableId ;
	private int userId;
	public int getTableId() {
		return tableId;
	}
	public void setTableId(int tableId) {
		this.tableId = tableId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public RestaurantTableReservationPk() {
		super();
	}
	public RestaurantTableReservationPk(int tableId, int userId) {
		super();
		this.tableId = tableId;
		this.userId = userId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + tableId;
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
		RestaurantTableReservationPk other = (RestaurantTableReservationPk) obj;
		if (tableId != other.tableId)
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}
	
	

}
