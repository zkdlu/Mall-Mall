package com.zkdlu.mnm.product.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zkdlu.mnm.article.model.Article;

public interface ProductRepository extends JpaRepository<Article, Integer>{

}
