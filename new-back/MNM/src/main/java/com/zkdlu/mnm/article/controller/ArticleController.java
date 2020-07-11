package com.zkdlu.mnm.article.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zkdlu.mnm.article.service.ArticleService;
import com.zkdlu.mnm.user.dto.UserDTO;
import com.zkdlu.mnm.user.model.User;

@RestController
public class ArticleController {
	
	@Autowired
	ArticleService articleService;
	
	@PostMapping(path = "/articles?user_id={0}")
	public boolean insertArticle(@RequestBody UserDTO userDTO) {
		return true;
	}
	
	/*
	@DeleteMapping(path ="/articles/{id}?user_id={0}")
	public boolean deleteArticle(@PathVariable("user_id") String id) {
		return userService.remove(id);
	}
	
	@GetMapping("/articles/{id}?user_id={0}")
	public User view(@PathVariable("user_id") String id) {
		System.out.println(id);
		return userService.view(id);
	}
	
	@PutMapping(path ="/articles/{id}?user_id={0}")
	public boolean edit(@RequestBody UserDTO userDTO, @PathVariable("user_id") String id) {
		if (userDTO.getUser_id().equals(id)) {
			return userService.edit(userDTO);
		}
		return false;
	}
	*/
	
	@GetMapping("/articles?user_id={0}")
	public boolean getArticleList(@PathVariable("user_id") String id) {
		System.out.println(id);
		return userService.view(id);
	}
	
	
	
	

}
