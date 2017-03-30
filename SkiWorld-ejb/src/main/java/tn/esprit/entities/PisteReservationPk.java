package tn.esprit.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class PisteReservationPk implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int pisteId;
	private int playerId;
	public int getPisteId() {
		return pisteId;
	}
	public void setPisteId(int pisteId) {
		this.pisteId = pisteId;
	}
	public int getPlayerId() {
		return playerId;
	}
	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + pisteId;
		result = prime * result + playerId;
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
		PisteReservationPk other = (PisteReservationPk) obj;
		if (pisteId != other.pisteId)
			return false;
		if (playerId != other.playerId)
			return false;
		return true;
	}
	public PisteReservationPk() {
		super();
	}
	public PisteReservationPk(int pisteId, int playerId) {
		super();
		this.pisteId = pisteId;
		this.playerId = playerId;
	}
	
	

}
