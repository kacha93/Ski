package tn.esprit.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import tn.esprit.entities.User;

/**
 * Entity implementation class for Entity: PisteManager
 *
 */
@Entity

public class PisteManager extends User implements Serializable {

	
	
	
	private static final long serialVersionUID = 1L;
	
	private List<Piste> pistes;

	public PisteManager() {
		super();
	}

	@OneToMany(mappedBy="pisteManager")
	public List<Piste> getPistes() {
		return pistes;
	}

	public void setPistes(List<Piste> pistes) {
		this.pistes = pistes;
	}

	
	
	
	
	
   
}
