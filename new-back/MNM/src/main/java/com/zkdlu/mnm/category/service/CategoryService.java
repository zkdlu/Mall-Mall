package com.zkdlu.mnm.category.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zkdlu.mnm.category.model.Category;
import com.zkdlu.mnm.category.repo.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	CategoryRepository categoryRepo;
	
	public List<Category> getCategories() {
		return categoryRepo.findAll();
	}
}
