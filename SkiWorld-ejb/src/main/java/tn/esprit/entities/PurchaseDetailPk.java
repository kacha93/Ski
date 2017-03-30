package tn.esprit.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class PurchaseDetailPk implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int userId;
	private int articleId;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getArticleId() {
		return articleId;
	}
	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}
	public PurchaseDetailPk() {
		super();
	}
	public PurchaseDetailPk(int userId, int articleId) {
		super();
		this.userId = userId;
		this.articleId = articleId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + articleId;
		result = prime * result + userId;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PurchaseDetailPk other = (PurchaseDetailPk) obj;
		if (articleId != other.articleId)
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}
	
	
	
	

}
