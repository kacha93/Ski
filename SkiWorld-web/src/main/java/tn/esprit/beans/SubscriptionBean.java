package tn.esprit.beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


import tn.esprit.entities.Client;
import tn.esprit.entities.User;
import tn.esprit.services.UserServiceLocal;


@ManagedBean(name="subscriptionBean")
@SessionScoped

public class SubscriptionBean {

	public SubscriptionBean() {
		
	}
	
	@EJB
	private UserServiceLocal ejb;
	
	private Client client ; 
	private List<User> clients;

	private boolean loggedIn=false;
	
	
	
	@PostConstruct
	public void init(){
		client = new Client();
		clients = ejb.findAll();
	}


	

	public boolean isLoggedIn() {
		return loggedIn;
	}




	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}




	public Client getClient() {
		return client;
	}




	public void setClient(Client client) {
		this.client = client;
	}




	public List<User> getClients() {
		return clients;
	}




	public void setClients(List<User> clients) {
		this.clients = clients;
	}




	public UserServiceLocal getEjb() {
		return ejb;
	}
	



	public void prepareCreate(){
		init();
		
	}
	

	public String create(){
		
		
		ejb.create(client);
		loggedIn = true;
		
		init();
		FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Subscription success", null);
		return null;
	}
}
