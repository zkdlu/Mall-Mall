package com.zkdlu.mnm.cart.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zkdlu.mnm.article.model.Article;
import com.zkdlu.mnm.cart.dto.CartDTO;
import com.zkdlu.mnm.cart.model.Cart;
import com.zkdlu.mnm.cart.service.CartService;

@RestController
public class CartController {
	
	@Autowired
	CartService cartService;
	
	@PostMapping("/users/{user_id}/carts")
	public boolean insertNewProduct(@RequestBody CartDTO cartDTO,
										@PathVariable("user_id") String userId) {
		if (cartDTO == null) {
			return false;
		}
		
		return cartService.insertProduct(userId, cartDTO);
	}
	
	@GetMapping("/users/{user_id}/carts")
	public List<Cart> getCartList(@PathVariable("user_id") String userId) {
		System.out.println(userId);
		
		List<Cart> carts = new ArrayList<Cart>();
		Cart cart = new Cart();
		Article article = new Article();
		article.setTitle("TEST");
		cart.setArticle(article);
		
		carts.add(cart);
		
		return carts;
	}
	
	@GetMapping(path = "/users/{user_id}/carts/{cart_pk}")
	public List<Cart> getCart(@PathVariable("user_id") String userId,
				@PathVariable("cart_pk") int cartPk) {
		System.out.println(userId);
		System.out.println(cartPk);
		
		List<Cart> carts = new ArrayList<Cart>();
		Cart cart = new Cart();
		Article article = new Article();
		article.setTitle("TEST");
		cart.setArticle(article);
		
		carts.add(cart);
		
		return carts;
	}
}
