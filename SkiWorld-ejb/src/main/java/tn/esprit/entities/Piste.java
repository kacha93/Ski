package tn.esprit.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Piste
 *
 */
@Entity

public class Piste implements Serializable {

	
	private int id;
	private Adress adress;
	private String difficuly;
	private int totalPlaces;
	
	
	private PisteType pisteType;
	private PisteManager pisteManager ;
	private static final long serialVersionUID = 1L;

	public Piste() {
		super();
	}   
	@Id    
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@Embedded
	public Adress getAdress() {
		return adress;
	}
	public void setAdress(Adress adress) {
		this.adress = adress;
	}
	public String getDifficuly() {
		return difficuly;
	}
	public void setDifficuly(String difficuly) {
		this.difficuly = difficuly;
	}
	public int getTotalPlaces() {
		return totalPlaces;
	}
	public void setTotalPlaces(int totalPlaces) {
		this.totalPlaces = totalPlaces;
	}

	
	
	
	@OneToOne
	public PisteType getPisteType() {
		return pisteType;
	}
	public void setPisteType(PisteType pisteType) {
		this.pisteType = pisteType;
	}
	
	@ManyToOne
	public PisteManager getPisteManager() {
		return pisteManager;
	}
	public void setPisteManager(PisteManager pisteManager) {
		this.pisteManager = pisteManager;
	}
	
	
	
	
   
	
}
