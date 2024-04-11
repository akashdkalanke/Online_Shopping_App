package com.yash.ecommerceonlineshoppingapp.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.yash.ecommerceonlineshoppingapp.dto.ProductAddNewRequest;
import com.yash.ecommerceonlineshoppingapp.dto.ProductAddReqeust;
import com.yash.ecommerceonlineshoppingapp.entity.Product;

public interface ProductService {

	Product addProduct(ProductAddReqeust addProductReqeust);

	List<Product> getAllProduct();

	List<Product> getProductByCategory(Integer CategoryId);

	Product getProductById(Integer productId);

	Product addProductWithMultipart(ProductAddNewRequest addProductReqeust, MultipartFile file);

}
