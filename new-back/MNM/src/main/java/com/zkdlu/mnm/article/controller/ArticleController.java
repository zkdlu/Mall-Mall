package com.zkdlu.mnm.article.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zkdlu.mnm.article.dto.ArticleDTO;
import com.zkdlu.mnm.article.model.Article;
import com.zkdlu.mnm.article.service.ArticleService;
import com.zkdlu.mnm.cart.dto.CartDTO;
import com.zkdlu.mnm.cart.model.Cart;
import com.zkdlu.mnm.product.dto.ProductDTO;
import com.zkdlu.mnm.user.dto.UserDTO;
import com.zkdlu.mnm.user.model.User;
import com.zkdlu.mnm.user.service.UserService;

@RestController
public class ArticleController {
	
	@Autowired
	ArticleService articleService;
	
	@Autowired
	UserService userService;
	
	@PostMapping(path = "/articles?user_id={0}")
	public boolean insertArticle(@PathVariable("user_id") String userId, @RequestBody ArticleDTO articleDTO, @RequestBody ProductDTO productDTO) {
		return articleService.insertArticle(userId,articleDTO,productDTO);
	}
	
	@DeleteMapping(path ="/articles/{id}?user_id={0}")
	public boolean deleteArticle(@PathVariable("user_id") String userId,@PathVariable("article_pk") int articlePk) {
		return articleService.deleteArticleOne(userId,articlePk);
	}
	
	@GetMapping("/articles/{id}?user_id={0}")
	public Article getArticle(@PathVariable("user_id") String userId, @PathVariable("article_pk") int articlePk) {
		return articleService.getArticle(userId,articlePk);
	}
	
	@PutMapping(path ="/articles/{id}?user_id={0}")
	public boolean updateArticle(@PathVariable("user_id") String userId) {
		return articleService.updateArticle(userId);
	}
	
	@GetMapping("/articles?user_id={0}")
	public List<Article> getArticleList(@PathVariable("user_id") String userId) {
		
		return articleService.getArticleList(userId);
	}
	
}
