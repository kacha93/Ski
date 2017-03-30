package tn.esprit.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: ArticleCategory
 *
 */
@Entity

public class ArticleCategory implements Serializable {

	
	private int id;
	private String category;
	private Article article;
	private static final long serialVersionUID = 1L;

	public ArticleCategory() {
		super();
	}   
	@Id    
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	@OneToOne(mappedBy="articleCategory"
			)
	public Article getArticle() {
		return article;
	}
	public void setArticle(Article article) {
		this.article = article;
	}
	

	
	
	
	
   
	
}
