package com.crud.ecart.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.ecart.model.Brand;
import com.crud.ecart.model.Product;
import com.crud.ecart.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/product")
@Slf4j
public class ProductController {

	@Autowired
	ProductService productService;

	@PostMapping("/save")
	Product addNewProduct(@RequestBody Product product) {
		Product newProduct = productService.addNewProduct(product);
		String methodName = "addNewProduct()";
		log.info(methodName + " called");
		return newProduct;

	}

	@PostMapping("/saveAll")
	List<Product> addNewListOfProduct(@RequestBody List<Product> product) {
		List<Product> productLists = productService.addNewListOfProduct(product);
		String methodName = "addNewListOfProduct()";
		log.info(methodName + " called");
		return productLists;

	}

	@PutMapping("/update")
	Product updateProduct(@RequestBody Product product) {
		Product updateProduct = productService.updateProduct(product);
		String methodName = "updateProduct()";
		log.info(methodName + " called");
		return updateProduct;
	}

	@PutMapping("/updateAll")
	List<Product> updateListOfProduct(@RequestBody List<Product> product) {
		List<Product> updateProduct = productService.updateListOfProducts(product);
		String methodName = "updateListOfProduct()";
		log.info(methodName + " called");
		return updateProduct;

	}

	@GetMapping("/{productId}")
	Optional<Product> findById(@PathVariable int productId) {
		Optional<Product> existingProduct = productService.fetchById(productId);
		String methodName = "findById()";
		log.info(methodName + " called");
		return existingProduct;

	}

	@GetMapping("/findAll")
	public List<Product> fetchAllProducts() {
		List<Product> existingProductLists = productService.fetchAllProducts();
		String methodName = "fetchAllProducts()";
		log.info(methodName + " called");
		return existingProductLists;
	}

	@DeleteMapping("/{productId}")
	public String deleteProduct(@PathVariable int productId) {
		productService.deleteProduct(productId);
		String methodName = "deleteProduct()";
		log.info(methodName + " called");
		return " deleted Product Succesfully !";
	}

	@GetMapping("/find/{brandName}")
	public List<Product> fetchProductByBrandName(@PathVariable String brandName) {
		List<Product> existingProduct = productService.findByBrandName(brandName);
		String methodName = "fetchProductByBrandName()";
		log.info(methodName + " called");
		return existingProduct;
	}
	
	@GetMapping("/category/{categoryName}")
	public List<Product> fetchProductByCategoryName(@PathVariable String categoryName){
		List<Product> existingProduct = productService.findByCategoryName(categoryName);
		String methodName = "fetchProductByCategoryName()";
		log.info(methodName + " called");
		return existingProduct;
	}
	
	
}
