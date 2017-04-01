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
import tn.esprit.entities.User;
import tn.esprit.entities.Worker;
import tn.esprit.services.UserServiceLocal;

@ManagedBean
@ViewScoped
public class WorkerBean {
	private Worker worker = new Worker();
	private List<User> workers = new ArrayList<User>();
	private List<User> filtredWorkers;
	
	private List<SelectItem> selectItemsForRestaurant;
	private int selectedRestaurantId = -1;
	
	private boolean visible=false;
	
	@EJB
	UserServiceLocal myService;


	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	
	public String ajouter()
	{
		myService.create(worker);;
	init();
	return null ;
		}

	public String modifier()
	{ 
		worker.setRestaurant(myService.findRestaurantById(selectedRestaurantId));
		myService.edit(worker);
		setVisible(false);
		init();
		return null;
		}


	public String supprimer(Worker item){
		 myService.delete(worker);
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
		
		
		workers=new ArrayList<User>();
	List<User> item=myService.findAll();
	if(item!=null){
		for(User w:item){
			if(w instanceof Worker){
				workers.add((Worker) w);
			}
		}
	}
	}
	
	public String initialiser(){
		worker=new Worker();
		selectedRestaurantId = -1 ;
		setVisible(true);
		return null;
		
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


	public Worker getWorker() {
		return worker;
	}

	public void setWorker(Worker worker) {
		this.worker = worker;
	}



	public List<User> getWorkers() {
		return workers;
	}

	public void setWorkers(List<User> workers) {
		this.workers = workers;
	}

	public List<User> getFiltredWorkers() {
		return filtredWorkers;
	}

	public void setFiltredWorkers(List<User> filtredWorkers) {
		this.filtredWorkers = filtredWorkers;
	}

	public void handleToggle(ToggleEvent event) {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Toggled", "Visibility:" + event.getVisibility());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
}

	

	

