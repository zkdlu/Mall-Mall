package com.zkdlu.mnm.cart.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.zkdlu.mnm.article.model.Article;
import com.zkdlu.mnm.product.model.Product;
import com.zkdlu.mnm.user.model.User;

@Entity
@Table(name = "cart")
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int pk;
	
	@OneToOne
	@JoinColumn(name = "user_pk")
	private User user;
	
	@OneToOne
	@JoinColumn(name = "article_pk")
	private Article article;
	
	@OneToOne
	@JoinColumn(name = "product_pk")
	private Product product;
	
	private int count;
	private int state;
	
	public int getPk() {
		return pk;
	}
	public void setPk(int pk) {
		this.pk = pk;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Article getArticle() {
		return article;
	}
	public void setArticle(Article article) {
		this.article = article;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
}
