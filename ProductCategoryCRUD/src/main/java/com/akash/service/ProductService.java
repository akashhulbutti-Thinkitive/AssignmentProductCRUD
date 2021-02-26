package com.akash.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.akash.model.Category;
import com.akash.model.Products;

@Service
public interface ProductService {
	/**
	 * 
	 * @return
	 */
	public List<Products> getAllProducts();
	/**
	 * 
	 * @param product
	 * @return
	 */
	public Products addNewProduct(Products product);
	/**
	 * 
	 * @param productid
	 * @return
	 */
	public Products getOneProduct(Integer productid);
	/**
	 * 
	 * @param product
	 * @return
	 */
	public Products updateProduct(Products product);
	/**
	 * 
	 * @param productID
	 * @return
	 */
	public boolean deleteProduct(Integer productID);
	/**
	 * 
	 * @param page
	 * @return
	 */
	public Page<Products> findAllByPagination(int page);
	/**
	 * 
	 * @param page
	 * @param field
	 * @param sortBy
	 * @return
	 */
	public Page<Products> findAllByPaginationandSortbyField(int page,String field,String sortBy);
	
	/**
	 * @param name
	 * @param page
	 * @param field
	 * @param sortBy
	 * @return
	 */
	public List<Products> findByName(String name,int page,String field,String sortBy);
	
	/**
	 * @param price
	 * @param page
	 * @param field
	 * @param sortBy
	 * @return
	 */
	public List<Products> findByPrice(Double price,int page,String field,String sortBy);
	
	
	/**
	 * @param category
	 * @param page
	 * @param field
	 * @param sortBy
	 * @return
	 */
	public List<Products> findByCategory(Category category,int page,String field,String sortBy);
	
}
