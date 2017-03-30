package tn.esprit.beans;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import tn.esprit.services.UserServiceLocal;

@ManagedBean
@SessionScoped
public class LoginBean {

	
	public LoginBean() {
		
	}
	@EJB
	UserServiceLocal ejb;
	
	private String email ; 
	private String password ;
	private boolean loggedIn ;
	
	
	public boolean isLoggedIn() {
		return loggedIn;
	}
	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String doLogin () {
		
		if(!(ejb.authenticate(this.email, this.password)).equals(null)){
			loggedIn = true ;
			FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Login success", null);
			return "client/client.xhtml?faces-redirect=true";
		
		}
		
		else {
			loggedIn = false;
			FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid credentails", null);
			return null;
		}
		
	}
	
	

}
