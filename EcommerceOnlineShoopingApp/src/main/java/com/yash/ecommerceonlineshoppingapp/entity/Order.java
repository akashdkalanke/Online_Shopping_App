package com.yash.ecommerceonlineshoppingapp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String orderId;
	@OneToOne
	@JoinColumn(name = "product_id")
	private Product product;
	@OneToOne
	@JoinColumn(name = "user_id")
	private User user;
	private int quantity;
	private String orderDate;
	private String deliveryStatus;
	private String deliveryDate;
	private String deliveryTime;
	private String deliveryAssigned;
	private int deliveryPersonId;

}
