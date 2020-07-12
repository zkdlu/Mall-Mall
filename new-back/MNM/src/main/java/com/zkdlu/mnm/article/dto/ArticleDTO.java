package com.zkdlu.mnm.article.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.zkdlu.mnm.category.dto.CategoryDTO;
import com.zkdlu.mnm.category.model.Category;
import com.zkdlu.mnm.product.dto.ProductDTO;
import com.zkdlu.mnm.product.model.Product;
import com.zkdlu.mnm.user.dto.UserDTO;
import com.zkdlu.mnm.user.model.User;

public class ArticleDTO {
	private int pk;
	private UserDTO user;
	private ProductDTO product;
	private CategoryDTO category;
	private String title;
	private String description;
	private int hits;
	private int state;

	public int getPk() {
		return pk;
	}
	public void setPk(int pk) {
		this.pk = pk;
	}
	public UserDTO getUser() {
		return user;
	}
	public void setUser(UserDTO user) {
		this.user = user;
	}
	public ProductDTO getProduct() {
		return product;
	}
	public void setProduct(ProductDTO product) {
		this.product = product;
	}
	public CategoryDTO getCategory() {
		return category;
	}
	public void setCategory(CategoryDTO category) {
		this.category = category;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getHits() {
		return hits;
	}
	public void setHits(int hits) {
		this.hits = hits;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
}
