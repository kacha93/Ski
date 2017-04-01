package tn.esprit.beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.primefaces.event.ToggleEvent;

import tn.esprit.entities.Restaurant;
import tn.esprit.entities.RestaurantTable;
import tn.esprit.services.RestaurantTableServiceLocal;


@ManagedBean
@ViewScoped

public class RestaurantTableBean {
	private RestaurantTable restaurantTable = new RestaurantTable();
	private List<RestaurantTable> restaurantTables = new ArrayList<RestaurantTable>();
	private List<RestaurantTable> filtredrestaurantTables;
	
	private List<SelectItem> selectItemsForRestaurant;
	private int selectedRestaurantId = -1;
	
	private boolean visible=false;
	
	@EJB
	RestaurantTableServiceLocal myService;


	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	
	public String ajouter()
	{
		myService.AddRestaurantTable(restaurantTable);
	init();
	return null ;
		}

	public String modifier()
	{ 
		restaurantTable.setRestaurant(myService.findRestaurantById(selectedRestaurantId));
		myService.UpdateRestaurantTable(restaurantTable);;
		setVisible(false);
		init();
		return null;
		}


	public String supprimer(RestaurantTable item){
		 myService.DeleteRestaurantTable(item);
		 init();
		 return null ;
	 }

	@PostConstruct
	public void init(){ 
		List<Restaurant> restaurants = myService.getAllRestaurant();        
		selectItemsForRestaurant= new ArrayList<SelectItem>(restaurants.size());
		for(Restaurant restaurant:restaurants){
			selectItemsForRestaurant.add(new SelectItem(restaurant.getId(),restaurant.getName()));
		
		}
		
		
		restaurantTables=new ArrayList<RestaurantTable>();
	List<RestaurantTable> item=myService.findAll();
	if(item!=null){
		for(RestaurantTable rt:item){
			if(rt instanceof RestaurantTable){
				restaurantTables.add((RestaurantTable) rt);
			}
		}
	}
	}
	
	public String initialiser(){
		restaurantTable=new RestaurantTable();
		selectedRestaurantId = -1 ;
		setVisible(true);
		return null;
		
	}

	
	
	public RestaurantTable getRestaurantTable() {
		return restaurantTable;
	}


	public void setRestaurantTable(RestaurantTable restaurantTable) {
		this.restaurantTable = restaurantTable;
	}


	public List<RestaurantTable> getRestaurantTables() {
		return restaurantTables;
	}


	public void setRestaurantTables(List<RestaurantTable> restaurantTables) {
		this.restaurantTables = restaurantTables;
	}


	


	public List<RestaurantTable> getFiltredrestaurantTables() {
		return filtredrestaurantTables;
	}


	public void setFiltredrestaurantTables(List<RestaurantTable> filtredrestaurantTables) {
		this.filtredrestaurantTables = filtredrestaurantTables;
	}


	public List<SelectItem> getSelectItemsForRestaurant() {
		return selectItemsForRestaurant;
	}


	public void setSelectItemsForRestaurant(List<SelectItem> selectItemsForRestaurant) {
		this.selectItemsForRestaurant = selectItemsForRestaurant;
	}


	public int getSelectedRestaurantId() {
		return selectedRestaurantId;
	}


	public void setSelectedRestaurantId(int selectedRestaurantId) {
		this.selectedRestaurantId = selectedRestaurantId;
	}


	public void handleToggle(ToggleEvent event) {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Toggled", "Visibility:" + event.getVisibility());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
}

