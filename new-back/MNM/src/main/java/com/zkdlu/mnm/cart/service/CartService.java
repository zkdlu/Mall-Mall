package com.zkdlu.mnm.cart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zkdlu.mnm.article.model.Article;
import com.zkdlu.mnm.article.repo.ArticleRepository;
import com.zkdlu.mnm.cart.dto.CartDTO;
import com.zkdlu.mnm.cart.model.Cart;
import com.zkdlu.mnm.cart.repo.CartRepository;
import com.zkdlu.mnm.user.model.User;
import com.zkdlu.mnm.user.repo.UserRepository;

@Service
public class CartService {

	@Autowired
	CartRepository cartRepo;

	@Autowired
	UserRepository userRepo;
	
	@Autowired
	ArticleRepository articleRepo;
	
	public boolean insertProduct(String userId, CartDTO cartDTO) {
		User user = userRepo.findOneById(userId);
		Article article = articleRepo.findById(cartDTO.getArticle_pk()).get();
		
		if (user == null || article == null) {
			return false;
		}
		
		Cart cart = new Cart();
		cart.setArticle(article);
		cart.setCount(cartDTO.getCount());
		cart.setProduct(article.getProduct());
		cart.setUser(user);
		cart.setState(0);
		
		try { 
			cartRepo.save(cart);
		} catch (Exception e) {
			return false;
		}
		
		return true;
	}

}
