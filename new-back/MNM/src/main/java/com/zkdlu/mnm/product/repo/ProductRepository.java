package com.zkdlu.mnm.product.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zkdlu.mnm.article.model.Article;
import com.zkdlu.mnm.product.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
