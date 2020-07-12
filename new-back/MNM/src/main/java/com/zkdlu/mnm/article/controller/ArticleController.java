package com.zkdlu.mnm.article.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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

	@PostMapping(path = "/articles")
	public boolean insertArticle(@RequestBody ArticleDTO articleDTO) {
		return articleService.insertArticle(articleDTO);
	}

//	@DeleteMapping(path ="/articles/{article_pk}")
//	public boolean deleteArticle(@RequestParam("user_id") String userId,
//			@PathVariable("article_pk") int articlePk) {
//		return articleService.deleteArticleOne(userId,articlePk);
//	}

	@GetMapping("/articles")
	public List<Article> getArticleList() {
		return articleService.getArticleList();
	}
	
	@GetMapping("/articles/{article_pk}")
	public Article getArticle(@PathVariable("article_pk") int articlePk) {
		return articleService.getArticle(articlePk);
	}

//	@PutMapping(path ="/articles/{article_pk}")
//	public boolean updateArticle(@RequestParam("user_id") String userId,
//			@PathVariable("article_pk") int articlePk) {
//		return articleService.updateArticle(userId);
//	}
//	


}
