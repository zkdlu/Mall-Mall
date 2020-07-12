package com.zkdlu.mnm.category.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zkdlu.mnm.category.model.Category;
import com.zkdlu.mnm.category.service.CategoryService;

@RestController
public class CategoryController {
	@Autowired
	CategoryService categoryService;
	
	@GetMapping("/categories")
	public List<Category> getCategories() {
		return categoryService.getCategories();
	}
}