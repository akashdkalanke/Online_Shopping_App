package com.yash.ecommerceonlineshoppingapp.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.ecommerceonlineshoppingapp.entity.Category;
import com.yash.ecommerceonlineshoppingapp.repository.CategoryRepository;
import com.yash.ecommerceonlineshoppingapp.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
  private CategoryRepository categoryRepository;

	@Override
	public Category addCategory(Category category) {
		
		return categoryRepository.save(category);
	}

	@Override
	public List<Category> getAllCategory() {
		
		return categoryRepository.findAll();
	}

}
