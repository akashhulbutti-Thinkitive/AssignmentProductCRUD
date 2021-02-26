package com.akash.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akash.model.Category;
import com.akash.repository.CategoryRepository;

@Service
public class CategoryServiceImplementation implements CategoryService{
	
	@Autowired CategoryRepository categoryRepo;

	@Override
	public List<Category> getAllCategory() {
		return categoryRepo.findAll();
	}

	@Override
	public Category addNewCategory(Category category) {
		return categoryRepo.save(category);
	}

	@Override
	public Category updateCategory(Category category) {
		return categoryRepo.save(category);
	}

	@Override
	public boolean deleteCategory(Integer categoryId) {
		
		Category category = categoryRepo.findCategoryById(categoryId);
		System.out.println(" Update this "+category);
		if(category!=null) {
			category.setStatus("Removed");
			categoryRepo.save(category);
			return true;
		}
		
		return false;
	}
	
	

	@Override
	public List<Category> finaAllByStatus() {	
		return categoryRepo.findAllByStatus();
	}

	@Override
	public Category getCategoryById(Integer categoryId) {
		return categoryRepo.findCategoryById(categoryId);
	}

}
