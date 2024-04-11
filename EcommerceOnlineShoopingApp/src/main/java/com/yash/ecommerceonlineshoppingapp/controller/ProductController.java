package com.yash.ecommerceonlineshoppingapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yash.ecommerceonlineshoppingapp.dto.ProductAddNewRequest;
import com.yash.ecommerceonlineshoppingapp.dto.ProductAddReqeust;
import com.yash.ecommerceonlineshoppingapp.entity.Product;
import com.yash.ecommerceonlineshoppingapp.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/products")
@Slf4j
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping("/addProduct")
	public ResponseEntity<Product> addProduct(@RequestBody ProductAddReqeust addProductReqeust) {

		Product product = productService.addProduct(addProductReqeust);

		return new ResponseEntity<Product>(product, HttpStatus.OK);

	}

	@PostMapping
	public ResponseEntity<Product> createProduct(@RequestParam MultipartFile file,
			@RequestParam("product") String product) {
		log.info("In Create ProductController::createProduct");

		ObjectMapper objectMapper = new ObjectMapper();
		Product productObj = null;

		try {
			ProductAddNewRequest readValue = objectMapper.readValue(product, ProductAddNewRequest.class);
			productObj = productService.addProductWithMultipart(readValue, file);
		} catch (JsonProcessingException e) {
			log.error("Error while saving product");
throw new RuntimeException("Problem while saving product");
		}

		return new ResponseEntity<Product>(productObj, HttpStatus.OK);

	}
	public ResponseEntity<List<Product>> getProductByCategory(@RequestParam("categoryId") Integer categoryId){
	return new ResponseEntity<List<product>>(productService.getProductByCategory(categoryId),HttpStatus.OK);
	}
	
	

}
