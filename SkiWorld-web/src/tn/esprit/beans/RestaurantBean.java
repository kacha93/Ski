package tn.esprit.beans;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.servlet.http.Part;
import javax.sql.rowset.serial.SerialException;

import org.apache.commons.io.IOUtils;

import tn.esprit.entities.Restaurant;
import tn.esprit.entities.RestaurantTable;
import tn.esprit.services.RestaurantServiceLocal;


@ManagedBean
@ViewScoped
public class RestaurantBean {

	private Restaurant restaurant = new Restaurant();
	private List<Restaurant> restaurants = new ArrayList<Restaurant>();

	private List<RestaurantTable> list=new ArrayList<RestaurantTable>();
	private List<Restaurant> restaurantfiltred;
	
	
	

	private boolean visible=false;
	private Part picFile;
	private Blob updateImage;
	@EJB
	RestaurantServiceLocal myService;
	
	
	
	public boolean isVisible() {
		return visible;
	}
	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	
	public String ajouter()
	{
		myService.AddRestaurant(restaurant);
		init();
		return null ;
		}

	public String modifier() throws IOException, SerialException, SQLException
	{ 
		
		if(picFile!=null){
		InputStream is=picFile.getInputStream();
        byte[] content = IOUtils.toByteArray(is);
        Blob blob = new javax.sql.rowset.serial.SerialBlob(content);
        restaurant.setPicture(blob);
		}
		else{
			restaurant.setPicture(updateImage);
		}
		
        
        	myService.UpdateRestaurant(restaurant);
    		setVisible(false);
    		init();
    		return null;
        
		
		}

	public String supprimer(Restaurant item){
		 myService.DeleteRestaurant(item);
		 init();
		 return null ;
	 }

	@PostConstruct
	public void init(){ 
		restaurant=new Restaurant();
    restaurants=new ArrayList<Restaurant>();
	List<Restaurant> item=myService.findAll();
	if(item!=null){
		for(Restaurant r:item){
			if(r instanceof Restaurant){
				restaurants.add((Restaurant) r);
			}
		}
	}
	}
	public String initialiser(){
		restaurant=new Restaurant();
		
		setVisible(true);
		return null;
	}
	
	public byte[] afficherPic(Blob blob) throws SQLException{
		return blob.getBytes(1, (int) blob.length());
	}
	
	public String listerRestaurantTable(){
		list=myService.ListRestaurantTable();
		
		return "/Restaurant/ListeRestaurantTable?faces-redirect=true";
	}
	
	
	public Part getPicFile() {
		return picFile;
	}
	public void setPicFile(Part picFile) {
		this.picFile = picFile;
	}

	public Blob getUpdateImage() {
		return updateImage;
	}
	public void setUpdateImage(Blob updateImage) {
		this.updateImage = updateImage;
	}
	public List<Restaurant> getRestaurantfiltred() {
		return restaurantfiltred;
	}
	public void setRestaurantfiltred(List<Restaurant> restaurantfiltred) {
		this.restaurantfiltred = restaurantfiltred;
	}
	public Restaurant getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
	public List<Restaurant> getRestaurants() {
		return restaurants;
	}
	public void setRestaurants(List<Restaurant> restaurants) {
		this.restaurants = restaurants;
	}
	public List<RestaurantTable> getList() {
		return list;
	}
	public void setList(List<RestaurantTable> list) {
		this.list = list;
	}
	
	
}
