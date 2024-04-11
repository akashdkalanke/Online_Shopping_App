package com.yash.ecommerceonlineshoppingapp.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.yash.ecommerceonlineshoppingapp.dto.ProductAddNewRequest;
import com.yash.ecommerceonlineshoppingapp.dto.ProductAddReqeust;
import com.yash.ecommerceonlineshoppingapp.entity.Category;
import com.yash.ecommerceonlineshoppingapp.entity.Product;
import com.yash.ecommerceonlineshoppingapp.repository.CategoryRepository;
import com.yash.ecommerceonlineshoppingapp.repository.ProductRepository;
import com.yash.ecommerceonlineshoppingapp.service.ProductService;
import com.yash.ecommerceonlineshoppingapp.utils.StorageService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired 
	private StorageService storageService;

	@Override
	public Product addProduct(ProductAddReqeust productAddReqeust) {

		Category category = categoryRepository.findById(productAddReqeust.getCategoryId())
				.orElseThrow(() -> new RuntimeException());

		Product product = new Product();
		product.setCategory(category);
		product.setTitle(productAddReqeust.getTitle());
		product.setDiscription(productAddReqeust.getDiscription());
		product.setImageName(storageService.store(productAddReqeust.getImage()));
		product.setPrice(productAddReqeust.getPrice());
		product.setQuantity(productAddReqeust.getQuantity());
		return productRepository.save(product);
	}

	@Override
	public List<Product> getAllProduct() {
		// TODO Auto-generated method stub
		return null;
	}

	

	@Override
	public Product getProductById(Integer productId) {
	return 	productRepository.findById(productId).get();
		
	}

	@Override
	public Product addProductWithMultipart(ProductAddNewRequest addProductReqeust, MultipartFile file) {
		
	
		Category category = categoryRepository.findById(addProductReqeust.getCategoryId())
				.orElseThrow(() -> new RuntimeException());

		Product product = new Product();
		product.setCategory(category);
		product.setTitle( addProductReqeust.getTitle());
		product.setDiscription( addProductReqeust.getDiscription());
		product.setImageName(storageService.store(file));
		product.setPrice( addProductReqeust.getPrice());
		product.setQuantity( addProductReqeust.getQuantity());
		return productRepository.save(product);
	
		
	}

	@Override
	public List<Product> getProductByCategory(Integer categoryId) {
		return productRepository.findByCategoryId(categoryId);
		
	}
}



