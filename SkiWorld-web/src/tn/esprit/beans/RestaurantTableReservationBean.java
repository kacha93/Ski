package tn.esprit.beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import tn.esprit.entities.RestaurantTableReservation;
import tn.esprit.services.RestaurantTableReservationServiceLocal;



@ManagedBean(name = "restaurantTableReservationBean")
@ViewScoped

public class RestaurantTableReservationBean {
	public RestaurantTableReservationBean() {
    }
	
	@EJB
	RestaurantTableReservationServiceLocal ejb;
	
private RestaurantTableReservation restaurantTableReservation= new RestaurantTableReservation();
	
	
private List<RestaurantTableReservation> restaurantResList;

private boolean isAddVisble = false ;
private boolean isEditVisible = false;

@PostConstruct
public void init() {
	restaurantResList=(ejb.findAll());
	restaurantTableReservation = new RestaurantTableReservation();
	
}

public void prepareAddRestaurantTableReservation() {
	setAddVisble(true);
	init();
	
}

public void AddRestaurantTableReservation() {
	ejb.AddRestaurantTableReservation(restaurantTableReservation);
	setAddVisble(false);
	init();
	
}

public void prepareUpdateRestaurantTableReservation(RestaurantTableReservation item){
	restaurantTableReservation = item;
	setEditVisible(true);
	
	
}

public void UpdateRestaurantTableReservation(){
	
	ejb.UpdateRestaurantTableReservation(restaurantTableReservation);
	setEditVisible(false);
	
}


public void DeleteRestaurantTableReservation(RestaurantTableReservation restaurantTableReservation) {

	
	ejb.DeleteRestaurantTableReservation(restaurantTableReservation);
	init();
	
}

public RestaurantTableReservation getRestaurantTableReservation() {
	return restaurantTableReservation;
}

public void setRestaurantTableReservation(RestaurantTableReservation restaurantTableReservation) {
	this.restaurantTableReservation = restaurantTableReservation;
}

public List<RestaurantTableReservation> getRestaurantResList() {
	return restaurantResList;
}

public void setRestaurantResList(List<RestaurantTableReservation> restaurantResList) {
	this.restaurantResList = restaurantResList;
}

public boolean isAddVisble() {
	return isAddVisble;
}

public void setAddVisble(boolean isAddVisble) {
	this.isAddVisble = isAddVisble;
}

public boolean isEditVisible() {
	return isEditVisible;
}

public void setEditVisible(boolean isEditVisible) {
	this.isEditVisible = isEditVisible;
}

	
	
	
	
	

}
