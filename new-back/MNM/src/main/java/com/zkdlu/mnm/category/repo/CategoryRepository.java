package com.zkdlu.mnm.category.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.zkdlu.mnm.article.model.Article;
import com.zkdlu.mnm.category.model.Category;
import com.zkdlu.mnm.user.model.User;

public interface CategoryRepository extends JpaRepository<Category, Integer>{
	@Query("SELECT c FROM Category c WHERE c.name = ?1")
	Category findOneByName(String name);
}
