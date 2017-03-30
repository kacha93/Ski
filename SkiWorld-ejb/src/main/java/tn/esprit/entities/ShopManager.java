package tn.esprit.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import tn.esprit.entities.User;

/**
 * Entity implementation class for Entity: ShopManager
 *
 */
@Entity

public class ShopManager extends User implements Serializable {

	
	private static final long serialVersionUID = 1L;
	private List<Shop>shops;

	public ShopManager() {
		super();
	}

	@OneToMany(mappedBy="shopManager")
	public List<Shop> getShops() {
		return shops;
	}

	public void setShops(List<Shop> shops) {
		this.shops = shops;
	}
   
	
}
