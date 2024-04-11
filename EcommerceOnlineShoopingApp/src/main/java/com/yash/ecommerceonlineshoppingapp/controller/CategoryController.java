package com.yash.ecommerceonlineshoppingapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yash.ecommerceonlineshoppingapp.entity.Category;
import com.yash.ecommerceonlineshoppingapp.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@PostMapping("/add")
	public ResponseEntity<Category> addCategory(@RequestBody Category category) {

		category = categoryService.addCategory(category);
		return new ResponseEntity<>(category, HttpStatus.OK);

	}

	@GetMapping("/getAll")
	public ResponseEntity<List<Category>> getAllCategory() {
		List<Category> categoryList = categoryService.getAllCategory();
		return new ResponseEntity<>(categoryList, HttpStatus.OK);
	}

}
