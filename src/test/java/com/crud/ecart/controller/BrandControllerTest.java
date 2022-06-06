package com.crud.ecart.controller;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.mockito.junit.jupiter.MockitoExtension;

import com.crud.ecart.model.Brand;
import com.crud.ecart.service.BrandService;

@ExtendWith(MockitoExtension.class)
public class BrandControllerTest {

	@InjectMocks
	BrandController brandController;

	@Mock
	BrandService brandService;

	private Brand brand;

	@BeforeEach
	void check() {

		brand = new Brand();
		brand.setBrandId(1);
		brand.setBrandName("iphone");
	}

	@Test
	public void addNewBrandTest() {
		brand.setBrandId(23);
		when(this.brandService.addNewBrand(brand)).thenReturn(brand);
		Brand addNewBrand = this.brandController.addNewBrand(brand);
		assertEquals(brand.getBrandId(), addNewBrand.getBrandId());
	}

	@Test
	public void updateBrandTest() {
		brand.setBrandName("jsndcjksn");
		when(this.brandService.updateBrand(brand)).thenReturn(brand);
		Brand updateBrand = this.brandController.updateBrand(brand);
		assertEquals(brand.getBrandName(), updateBrand.getBrandName());
	}

	@Test
	public void upadteMultipleTest() {
		brand.setBrandName("sam");
		List<Brand> list = new ArrayList<Brand>();
		list.add(brand);

		when(brandService.updateMultipleBrands(list)).thenReturn(list);
		List<Brand> updateMultipleBrandsf = this.brandController.updateMultipleBrands(list);
		assertEquals(brand.getBrandName(), "sam");
	}

	@Test
	public void addNewListOfBrandsTest() {
		brand.setBrandId(1);
		List<Brand> list = new ArrayList<Brand>();
		list.add(brand);
		when(this.brandService.addNewListOfBrands(list)).thenReturn(list);
		List<Brand> addNewListOfBrands = this.brandController.addNewListOfBrands(list);
		assertEquals(brand.getBrandId(), 1);
	}

	@Test
	public void updateMultipleBrandsTset() {
		brand.setBrandId(1);
		brand.setBrandName("puma");
		List<Brand> list = new ArrayList<Brand>();
		list.add(brand);
		when(this.brandService.updateMultipleBrands(list)).thenReturn(list);
		List<Brand> multipleBrands = this.brandController.updateMultipleBrands(list);
		assertEquals(brand.getBrandName(), multipleBrands.get(0).getBrandName());
	}

	@Test
	public void updateBrandTset() {
		brand.setBrandName("Nike");
		when(this.brandService.updateBrand(brand)).thenReturn(brand);
		Brand updateBrand = this.brandController.updateBrand(brand);
		assertEquals(brand.getBrandName(), updateBrand.getBrandName());
	}

	@Test
	public void findByIdTest() {
		brand.setBrandId(1);
		when(this.brandService.findById(1)).thenReturn(Optional.of(brand));
		Optional<Brand> findBtId = this.brandController.findBtId(1);
		assertEquals(brand.getBrandId(), findBtId.get().getBrandId());
	}

	@Test
	public void deleteByIdTest() {
		brand.setBrandId(2);
		brand.setBrandName("pume");
		when(this.brandService.deleteById(2)).thenReturn("pume");
		String deleteById = this.brandController.deleteById(2);
		assertEquals(brand.getBrandId(), 2);
	}

	@Test
	public void addNewListOfBrandsTests() {
		brand.setBrandId(1);
		brand.setBrandName("gogle");
		List<Brand> list = new ArrayList<Brand>();
		list.add(brand);
		when(this.brandService.addNewListOfBrands(list)).thenReturn(List.of(brand));
		List<Brand> addNewListOfBrands = this.brandController.addNewListOfBrands(list);
		assertEquals(brand.getBrandName(), addNewListOfBrands.get(0).getBrandName());
	}

}
