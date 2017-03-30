package tn.esprit.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Shop
 *
 */
@Entity

public class Shop implements Serializable {

	
	private int id;
	private String name ;
	private Adress adress;
	private ShopManager shopManager ; 
	private List<Article>articles;
	
	private static final long serialVersionUID = 1L;

	public Shop() {
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
	
	@Embedded
	public Adress getAdress() {
		return adress;
	}
	public void setAdress(Adress adress) {
		this.adress = adress;
	}
	
	@ManyToOne
	public ShopManager getShopManager() {
		return shopManager;
	}
	public void setShopManager(ShopManager shopManager) {
		this.shopManager = shopManager;
	}
	
	@OneToMany(mappedBy="shop",
			cascade=CascadeType.ALL)
	public List<Article> getArticles() {
		return articles;
	}
	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
	
	
	
   
}
