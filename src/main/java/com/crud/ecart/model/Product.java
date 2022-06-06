package com.crud.ecart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="products")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="product_id")
	private int productId;
	
	@Column(name="product_name")
	private String productName;
	
	@Column(name="price")
	private double price;
	
	@Column(name="description")
	private String description;
	
	@ManyToOne
	private Brand brand;
	
	@ManyToOne
	private Category category;
}
