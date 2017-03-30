package tn.esprit.entities;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import javax.persistence.*;
import javax.swing.text.html.HTMLDocument.HTMLReader.CharacterAction;

/**
 * Entity implementation class for Entity: Claim
 *
 */
@Entity

public class Claim implements Serializable {

	
	private int id;
	private Date claimDate;
	private String category;
	private String claimText;
	private Client client ; 
	private Player player;
	private static final long serialVersionUID = 1L;

	public Claim() {
		super();
	}   
	@Id    
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	
	@Temporal(TemporalType.DATE)
	public Date getClaimDate() {
		return this.claimDate;
	}

	public void setClaimDate(Date claimDate) {
		this.claimDate = claimDate;
	}   
	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}   
	public String getClaimText() {
		return this.claimText;
	}

	public void setClaimText(String claimText) {
		this.claimText = claimText;
	}
	
	@ManyToOne(cascade=CascadeType.ALL)
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	
	@ManyToOne(cascade=CascadeType.ALL)
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
	
	
   
}
