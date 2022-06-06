package com.crud.ecart.controller;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.any;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.crud.ecart.dao.ProductDao;
import com.crud.ecart.model.Category;
import com.crud.ecart.model.Product;
import com.crud.ecart.service.ProductService;

@ExtendWith(MockitoExtension.class)
public class ProductControllerTest {
	@InjectMocks
	ProductController productController;

	@Mock
	ProductService productService;

	@Mock
	ProductDao productDao;

	private Product product;

	private Category category;

	@BeforeEach
	void check() {
		product = new Product();
		MockitoAnnotations.initMocks(this);
		category = new Category();
	}

	@AfterEach
	void close() {

	}

	@Test
	public void addNewProductTest() {
		product.setProductName("Apple");
		when(this.productService.addNewProduct(product)).thenReturn(product);
		Product newProduct = this.productController.addNewProduct(product);
		assertEquals(product.getProductName(), newProduct.getProductName());
	}

	@Test
	public void updateProductTest() {
		product.setProductName("pooja");
		when(this.productService.updateProduct(product)).thenReturn(product);
		Product updateProduct = this.productController.updateProduct(product);
		assertEquals(product.getProductName(), updateProduct.getProductName());
	}

	@Test
	public void updateProductPositiveTest() {
		product.setProductId(1);
		when(this.productService.updateProduct(product)).thenReturn(product);
		Product updateProduct = this.productController.updateProduct(product);
		assertEquals(product.getProductId(), updateProduct.getProductId());
	}

	@Test
	public void updateListOfProductTest() {
		product.setProductName("Samsung");
		List<Product> list = new ArrayList<Product>();
		list.add(product);
		when(this.productService.updateListOfProducts(list)).thenReturn(list);
		List<Product> updateListOfProduct = this.productController.updateListOfProduct(list);
		assertEquals(product.getProductName(), "Samsung");
	}

	@Test
	public void fetchProductByCategoryNameTest() { // this is not working properly

		product.setProductName("mobile");

		when(this.productService.findByCategoryName("mobile")).thenReturn(List.of(product));
		List<Product> fetchProductByCategoryName = this.productController.fetchProductByCategoryName("mobile");
		assertEquals(product.getProductName(), fetchProductByCategoryName.get(0).getProductName());
	}

	@Test
	public void fetchProductByBrandNameTest() {
		product.setProductName("laptop");
		when(this.productService.findByBrandName("laptop")).thenReturn(List.of(product));
		List<Product> fetchProductByBrandName = this.productController.fetchProductByBrandName("laptop");
		assertEquals(product.getProductName(), fetchProductByBrandName.get(0).getProductName());
	}
@Test
public void updateListOfProductsTest() {
	product.setProductName("name");
	product.setDescription("jhja");
	product.setPrice(23.00);
	List<Product>list = new ArrayList<Product>();
	list.add(product);
	when(this.productService.updateListOfProducts(list)).thenReturn(list);
	List<Product> listOfProduct = this.productController.updateListOfProduct(list);
	assertEquals(product.getPrice(), listOfProduct.get(0).getPrice());
}






}
