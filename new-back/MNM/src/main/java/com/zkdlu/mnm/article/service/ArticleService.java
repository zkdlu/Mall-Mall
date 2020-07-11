package com.zkdlu.mnm.article.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zkdlu.mnm.article.dto.ArticleDTO;
import com.zkdlu.mnm.article.model.Article;
import com.zkdlu.mnm.article.repo.ArticleRepository;
import com.zkdlu.mnm.cart.dto.CartDTO;
import com.zkdlu.mnm.cart.model.Cart;
import com.zkdlu.mnm.category.model.Category;
import com.zkdlu.mnm.product.dto.ProductDTO;
import com.zkdlu.mnm.product.model.Product;
import com.zkdlu.mnm.product.repo.ProductRepository;
import com.zkdlu.mnm.user.model.User;
import com.zkdlu.mnm.user.repo.UserRepository;

@Service
public class ArticleService {
	@Autowired
	ArticleRepository articleRepo;
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	ProductRepository productRepo;
	
	public boolean insertArticle(String userId,ArticleDTO articleDTO,ProductDTO productDTO) {
		User user = userRepo.findOneById(userId);
		
		if (user == null || user.getState() != 1) {
			return false;
		}
		
		String product_name = productDTO.getName();
		int stock = productDTO.getStock();
		int sales = productDTO.getSales();
		int price = productDTO.getPrice();
		String description = productDTO.getDescription();
		String product_category = productDTO.getCategory();
		
		Category category = new Category();
		category.setName(product_category);
		
		if (product_name == null || description == null) {
			return false;
		}
		
		Product product = new Product();
		product.setName(product_name);
		product.setStock(stock);
		product.setSales(sales);
		product.setPrice(price);
		product.setDescription(description);
		product.setState(0);
		
		String title = articleDTO.getTitle();
		int hits = articleDTO.getHits();
		
		Article article = new Article();
		article.setUser(user);
		article.setProduct(product);
		article.setCategory(category);
		article.setTitle(title);
		article.setDescription(description);
		article.setHits(hits);
		
		try {
			productRepo.save(product);//?
			try {
				articleRepo.save(article);
				return true;
			} catch (Exception e) {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
		
	}
	
	public boolean deleteArticleOne(String userId, int articlePk) {
		User user = userRepo.findOneById(userId);
		if (user == null) {
			return false;
		}
		
		Article article = articleRepo.findById(articlePk).get();
		
		int productPk = article.getProduct().getPk();
		Product product = productRepo.findById(productPk).get();
		
		if (article != null &&
				article.getUser().getPk() == user.getPk()) {
			try {
				articleRepo.delete(article);
				productRepo.delete(product);
			} catch (Exception e) {
				return false;
			}
			
			return true;
		}
		
		return false;
	}
	
	public Article getArticle(String userId, int articlePk) {
		User user = userRepo.findOneById(userId);
		if (user == null) {
			return null;
		}
		
		Article article = articleRepo.findById(articlePk).get();
		if (article != null &&
				article.getUser().getPk() == user.getPk()) {
			return article;
		}
	
		return null;
	}
	
	public boolean updateArticle(String userId, ArticleDTO articleDTO, int articlePk) {
		User user = userRepo.findOneById(userId);
		if (user == null) {
			return false;
		}
		
		Article article = articleRepo.findById(articlePk).get();
		if (article != null &&
				article.getUser().getPk() == user.getPk()) {
			try {
				articleRepo.save(article);
				
			} catch (Exception e) {
				return false;
			}
			
			return true;
		}
		
		return false;
	}
		return true;
		
	}
	
	public List<Article> getArticleList(String userId) {
		User user = userRepo.findOneById(userId);
		if (user == null) {
			return new ArrayList<Article>();
		}
		return articleRepo.findByUser(user);
	}

}
