package com.yash.ecommerceonlineshoppingapp.service;

import java.util.List;

import com.yash.ecommerceonlineshoppingapp.entity.Category;

public interface CategoryService {

	Category addCategory(Category category);

	List<Category> getAllCategory();

}
