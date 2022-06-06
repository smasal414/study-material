package com.crud.ecart.ServiceTest;

import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.crud.ecart.dao.BrandDao;
import com.crud.ecart.model.Brand;
import com.crud.ecart.service.BrandService;

@ExtendWith(MockitoExtension.class)
public class BrandServiceTest {
	
	
	@InjectMocks
	BrandService brandService;
	
	@Mock
	BrandDao brandDao;
	
	private Brand brand;
	
	@BeforeEach
	public void start() {
		MockitoAnnotations.initMocks(this);
		brand = new Brand();
	}
	
	@AfterEach
	public void clean () {
		brand=null;
	}
	
	@Test
	public void deleteByIdTest() {
		brand.setBrandId(1);
		brand.setBrandName("jajskx");
		when(this.brandDao.findById(1)).thenReturn(Optional.of(brand));
		Optional<Brand> findById = this.brandService.findById(0);
		
	}

}
