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
import com.zkdlu.mnm.category.dto.CategoryDTO;
import com.zkdlu.mnm.category.model.Category;
import com.zkdlu.mnm.category.repo.CategoryRepository;
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
	
	@Autowired
	CategoryRepository categoryRepo;

	public boolean insertArticle(String userId, ArticleDTO articleDTO) {
		User user = userRepo.findOneById(userId);

		if (user == null || user.getState() == 1) {
			return false;
		}
		
		String articleTitle = articleDTO.getTitle();
		String articleDescription = articleDTO.getDescription();
		int hits = articleDTO.getHits();
		if (articleTitle == null) {
			return false;
		}
		
		ProductDTO productDTO = articleDTO.getProduct();
		String productName = productDTO.getName();
		int stock = productDTO.getStock();
		int sales = productDTO.getSales();
		int price = productDTO.getPrice();
		String description = productDTO.getDescription();
		
		if (productName == null) {
			return false;
		}
		
		Product product = new Product();
		product.setName(productName);
		product.setStock(stock);
		product.setSales(sales);
		product.setPrice(price);
		product.setDescription(description);
		product.setState(0);
		
		CategoryDTO categoryDTO = articleDTO.getCategory();
		String categoryName = categoryDTO.getName();
		
		if (categoryName == null) {
			return false;
		}
		
		Category category = categoryRepo.findOneByName(categoryName);
		if (category == null) {
			category = new Category();
			category.setName(categoryName);
			
			try {
				categoryRepo.save(category);
			} catch (Exception e) {
				return false;
			}
		}
		
		Article article = new Article();
		article.setUser(user);
		article.setProduct(product);
		article.setCategory(category);
		article.setTitle(articleTitle);
		article.setDescription(articleDescription);
		article.setHits(hits);

		try {
			productRepo.save(product);
			articleRepo.save(article);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public List<Article> getArticleList() {
		return articleRepo.findAll();
	}
	
	public Article getArticle(int articlePk) {
		Article article = articleRepo.findById(articlePk).get();
		if (article != null) {
			return article;
		}

		return null;
	}

//	
//	public boolean deleteArticleOne(String userId, int articlePk) {
//		User user = userRepo.findOneById(userId);
//		if (user == null) {
//			return false;
//		}
//		
//		Article article = articleRepo.findById(articlePk).get();
//		
//		int productPk = article.getProduct().getPk();
//		Product product = productRepo.findById(productPk).get();
//		
//		if (article != null &&
//				article.getUser().getPk() == user.getPk()) {
//			try {
//				articleRepo.delete(article);
//				productRepo.delete(product);
//			} catch (Exception e) {
//				return false;
//			}
//			
//			return true;
//		}
//		
//		return false;
//	}
//	

//	public boolean updateArticle(String userId, ArticleDTO articleDTO, int articlePk) {
//		User user = userRepo.findOneById(userId);
//		if (user == null) {
//			return false;
//		}
//		
//		Article article = articleRepo.findById(articlePk).get();
//		if (article != null &&
//				article.getUser().getPk() == user.getPk()) {
//			try {
//				articleRepo.save(article);
//				
//			} catch (Exception e) {
//				return false;
//			}
//			
//			return true;
//		}
//		
//		return false;
//	}
//	

}
