package com.zkdlu.mnm.article.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zkdlu.mnm.article.model.Article;

public interface ArticleRepository extends JpaRepository<Article, Integer>{

}
