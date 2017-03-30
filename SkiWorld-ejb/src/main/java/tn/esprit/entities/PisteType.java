package tn.esprit.entities;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: PisteType
 *
 */
@Entity

public class PisteType implements Serializable {

	
	private int id;
	private String type;
	private Piste piste ;
	private static final long serialVersionUID = 1L;

	public PisteType() {
		super();
	}   
	@Id    
	@GeneratedValue
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	
	
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	@OneToOne(mappedBy="pisteType",
			cascade=CascadeType.ALL)
	public Piste getPiste() {
		return piste;
	}
	public void setPiste(Piste piste) {
		this.piste = piste;
	}
	
	
   
}
