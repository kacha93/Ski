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

import tn.esprit.entities.MenuItem;
import tn.esprit.entities.Restaurant;
import tn.esprit.services.MenuItemServiceLocal;

@ManagedBean
@ViewScoped
public class MenuItemBean {
	
	private MenuItem menuItem = new MenuItem();
	private List<MenuItem> menuItems = new ArrayList<MenuItem>();
	private List<MenuItem> filtredMenuItems;
	
	private List<SelectItem> selectItemsForRestaurant;
	private int selectedRestaurantId = -1;
	
	private boolean visible=false;
	
	@EJB
	MenuItemServiceLocal myService;


	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	
	public String ajouter()
	{
		myService.AddMenuItem(menuItem);
	init();
	return null ;
		}

	public String modifier()
	{ 
		menuItem.setRestaurant(myService.findRestaurantById(selectedRestaurantId));
		myService.UpdateMenuItem(menuItem);
		setVisible(false);
		init();
		return null;
		}


	public String supprimer(MenuItem item){
		 myService.DeleteMenuItem(item);
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
		
		
		menuItems=new ArrayList<MenuItem>();
	List<MenuItem> item=myService.findAll();
	if(item!=null){
		for(MenuItem mi:item){
			if(mi instanceof MenuItem){
				menuItems.add((MenuItem) mi);
			}
		}
	}
	}
	
	public String initialiser(){
		menuItem=new MenuItem();
		selectedRestaurantId = -1 ;
		setVisible(true);
		return null;
		
	}

	

	public MenuItem getMenuItem() {
		return menuItem;
	}

	public void setMenuItem(MenuItem menuItem) {
		this.menuItem = menuItem;
	}

	public List<MenuItem> getMenuItems() {
		return menuItems;
	}

	public void setMenuItems(List<MenuItem> menuItems) {
		this.menuItems = menuItems;
	}

	public List<MenuItem> getFiltredMenuItems() {
		return filtredMenuItems;
	}

	public void setFiltredMenuItems(List<MenuItem> filtredMenuItems) {
		this.filtredMenuItems = filtredMenuItems;
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

	

	

