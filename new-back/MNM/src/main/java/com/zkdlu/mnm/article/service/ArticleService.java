package com.zkdlu.mnm.article.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zkdlu.mnm.article.model.Article;
import com.zkdlu.mnm.article.repo.ArticleRepository;

@Service
public class ArticleService {
	@Autowired
	ArticleRepository articleRepo;
	
	public boolean insertArticle() {
		Article article = articleRepo.findById(cartDTO.getArticle_pk()).get();
		
	}
	
	
	/*
	public remove() {
		
	}
	
	public view() {
		
	}
	
	public edit() {
		
	}
	*/
	
	public boolean getArticleList() {
		
	}
	
	

}
