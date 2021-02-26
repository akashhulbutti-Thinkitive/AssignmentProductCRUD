package com.akash.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.akash.model.Category;

/**
 * @author thinkitive
 *
 */
@Service
public interface CategoryService {
	
	
	/**
	 * @return
	 */
	public List<Category> getAllCategory();
	
	/**
	 * @return
	 */
	public List<Category> finaAllByStatus();
	
	/**
	 * @param categoryId
	 * @return
	 */
	public Category getCategoryById(Integer categoryId);
	
	/**
	 * @param category
	 * @return
	 */
	public Category addNewCategory(Category category);
	
	/**
	 * @param category
	 * @return
	 */
	public Category updateCategory(Category category);
	
	/**
	 * @param categoryId
	 * @return
	 */
	public boolean deleteCategory(Integer categoryId);
	
}
