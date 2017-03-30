package tn.esprit.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: PurchaseDetail
 *
 */
@Entity

public class PurchaseDetail implements Serializable {

	private PurchaseDetailPk pk;
	private Date purchaseDate;
	private int quantity;
	private Client client ;
	private Article article;
	
	private static final long serialVersionUID = 1L;

	public PurchaseDetail() {
		super();
	}

	@EmbeddedId
	public PurchaseDetailPk getPk() {
		return pk;
	}

	public void setPk(PurchaseDetailPk pk) {
		this.pk = pk;
	}

	@Temporal(TemporalType.DATE)
	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@ManyToOne
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@ManyToOne
	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}
	
	
   
}
