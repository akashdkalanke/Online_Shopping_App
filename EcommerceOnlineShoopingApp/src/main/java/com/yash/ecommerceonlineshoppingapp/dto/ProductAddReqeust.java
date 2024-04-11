package com.yash.ecommerceonlineshoppingapp.dto;

import java.math.BigDecimal;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductAddReqeust {
	
	private String title;
	private String discription;
	private int quantity;
	private BigDecimal price;
	private MultipartFile image;
	private int categoryId;
	

}
