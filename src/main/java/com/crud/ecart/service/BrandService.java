package com.crud.ecart.service;

import java.util.List;
import java.util.Optional;

import com.crud.ecart.model.Brand;

public interface BrandService {

	Brand addNewBrand(Brand brand);    // done
	
	List<Brand> addNewListOfBrands(List<Brand> brand); //
	
	Brand updateBrand(Brand brand);  // done with test case
	
	List<Brand> updateMultipleBrands(List<Brand> brand);  // done  with twst
	
	Optional<Brand> findById(int brandId); // find by id done with test case
	
	List<Brand> fetchAllBrand(); // all brands
	
	String deleteById(int brandId); // done with test case 
}
