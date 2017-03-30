package tn.esprit.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Article
 *
 */
@Entity

public class Article implements Serializable {
	
	
	private int id;
	private String name ; 
	private String description;
	private float price;
	private Shop shop;
	private ArticleCategory articleCategory;
	private List<PurchaseDetail> purchaseDetails;
	
	
	

	
	private static final long serialVersionUID = 1L;

	public Article() {
		super();
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getId() {
		return id;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@ManyToOne(cascade=CascadeType.ALL
			)
	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	@OneToOne
	public ArticleCategory getArticleCategory() {
		return articleCategory;
	}

	public void setArticleCategory(ArticleCategory articleCategory) {
		this.articleCategory = articleCategory;
	}

	@OneToMany(mappedBy="article",
			cascade=CascadeType.ALL,
			fetch=FetchType.EAGER)
	public List<PurchaseDetail> getPurchaseDetails() {
		return purchaseDetails;
	}

	public void setPurchaseDetails(List<PurchaseDetail> purchaseDetails) {
		this.purchaseDetails = purchaseDetails;
	}
	
	
	
	
   
}
