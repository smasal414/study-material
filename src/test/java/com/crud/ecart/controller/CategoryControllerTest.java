package com.crud.ecart.controller;

import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.crud.ecart.model.Category;
import com.crud.ecart.service.CategoryService;

@ExtendWith(MockitoExtension.class)
public class CategoryControllerTest {

	@InjectMocks
	CategoryController categoryController;

	@Mock
	CategoryService categoryService;

	private Category category;

	@SuppressWarnings("deprecation")
	@BeforeEach
	public void does() {
		MockitoAnnotations.initMocks(this);
		category = new Category();

	}

	@AfterEach
	public void clean() {
		category = null;
	}

	@Test
	public void addNewCategoeyTest() {
		category.setCategoryName("cloth");
		category.setCategoryId(2);
		when(this.categoryService.addNewCategoey(category)).thenReturn(category);
		Category newCategory = this.categoryController.addNewCategory(category);
		assertEquals(category.getCategoryName(), newCategory.getCategoryName());
	}

	@Test
	public void updateCategoryTest() {
		category.setCategoryId(1);
		category.setCategoryName("innerwear");
		when(this.categoryService.updateCategory(category)).thenReturn(category);
		Category category2 = this.categoryController.updateCategory(category);
		assertEquals(category.getCategoryName(), category2.getCategoryName());
	}

	@Test
	public void findByIdTest() {
		category.setCategoryId(4);
		when(this.categoryService.findById(4)).thenReturn(Optional.of(category));
		Optional<Category> findById = this.categoryController.findById(4);
		assertEquals(category.getCategoryId(), findById.get().getCategoryId());
	}

	@Test
	public void addListOfCategoriesTest() {
		category.setCategoryId(0);
		category.setCategoryName("necessary");
		List<Category> list = new ArrayList<>();
		list.add(category);
		when(this.categoryService.addListOfCategories(list)).thenReturn(List.of(category));
		List<Category> addNewListCategories = this.categoryController.addNewListCategories(list);
		assertEquals(category.getCategoryName(), addNewListCategories.get(0).getCategoryName());
	}

	@Test
	public void updateListOfCategoriesTest() {
		category.setCategoryId(3);
		category.setCategoryName("mobile");
		List<Category> list = new ArrayList<Category>();
		list.add(category);
		when(this.categoryService.updateListOfCategories(list)).thenReturn(List.of(category));
		List<Category> listOfCategory = this.categoryController.updateListOfCategory(list);
		assertEquals(category.getCategoryName(), listOfCategory.get(0).getCategoryName());
	}

	@Test
	public void fetchAllTest() {
		category.setCategoryId(2);
		category.setCategoryName("ji");
		List<Category> list = new ArrayList<Category>();
		when(this.categoryService.fetchAll()).thenReturn(List.of(category));
		List<Category> fetchAll = this.categoryController.fetchAll();
		assertEquals(category.getCategoryName(), fetchAll.get(0).getCategoryName());
	}

}
