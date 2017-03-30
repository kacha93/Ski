package tn.esprit.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Restaurant
 *
 */
@Entity

public class Restaurant implements Serializable {

	
	private int id;
	private String name;
	private String category;
	private Adress adress;
	private byte[] logo;
	private RestaurantManager restaurantManager ;
	private List<Worker> workers;
	private List<MenuItem>menuItems;
	private List <RestaurantTable>restaurantTables;
	private static final long serialVersionUID = 1L;

	public Restaurant() {
		super();
	}   
	@Id    
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	@Lob
	public byte[] getLogo() {
		return logo;
	}
	public void setLogo(byte[] logo) {
		this.logo = logo;
	}
	
	@Embedded
	public Adress getAdress() {
		return adress;
	}
	public void setAdress(Adress adress) {
		this.adress = adress;
	}
	
	@ManyToOne
	public RestaurantManager getRestaurantManager() {
		return restaurantManager;
	}
	public void setRestaurantManager(RestaurantManager restaurantManager) {
		this.restaurantManager = restaurantManager;
	}
	@OneToMany(mappedBy="restaurant",
			cascade=CascadeType.ALL)
	public List<Worker> getWorkers() {
		return workers;
	}
	public void setWorkers(List<Worker> workers) {
		this.workers = workers;
	}
	@OneToMany(mappedBy="restaurant",
			cascade=CascadeType.ALL)
	public List<MenuItem> getMenuItems() {
		return menuItems;
	}
	public void setMenuItems(List<MenuItem> menuItems) {
		this.menuItems = menuItems;
	}
	@OneToMany(mappedBy="restaurant",
			cascade=CascadeType.ALL)
	public List<RestaurantTable> getRestaurantTables() {
		return restaurantTables;
	}
	public void setRestaurantTables(List<RestaurantTable> restaurantTables) {
		this.restaurantTables = restaurantTables;
	}
	
	
	
	
   
	
}
