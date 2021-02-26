package com.akash.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.akash.model.Category;
import com.akash.model.Products;
import com.akash.repository.ProductRepository;

@Service
public class ProductServiceImplementation implements ProductService{
	
	@Autowired ProductRepository productRepo;

	@Override
	public Products addNewProduct(Products product) {
		return productRepo.save(product);
	}

	@Override
	public Products updateProduct(Products product) {
		return productRepo.save(product);
	}

	@Override
	public boolean deleteProduct(Integer productID) {
		
		Products product =  productRepo.findProductById(productID);
		if(product!=null) {
			product.setStatus("Removed");
			productRepo.save(product);
			return true;
		}		
		return false;
	}

	@Override
	public List<Products> getAllProducts() {
		return productRepo.findAllByStatus();
	}

	@Override
	public Products getOneProduct(Integer productid) {
		Products product = productRepo.findProductById(productid);
		if(product!=null)
			return product;
		return null;
	}
	
	@Override
	public Page<Products> findAllByPagination(int page){
		Pageable pageable = PageRequest.of(page-1,5);
		return productRepo.findAll(pageable);
	}
	
	@Override
	public Page<Products> findAllByPaginationandSortbyField(int page, String field, String sortBy) {
		Sort sort = sortBy.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(field).ascending() : Sort.by(field).descending();
		Pageable pageable = PageRequest.of(page-1,5,sort);
		return productRepo.findAll(pageable);
	}

	@Override
	public List<Products> findByName(String name, int page, String field, String sortBy) {
		Sort sort = sortBy.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(field).ascending() : Sort.by(field).descending();
		Pageable pageable = PageRequest.of(page-1,5,sort);
		return productRepo.findByName(name, pageable);
	}

	@Override
	public List<Products> findByPrice(Double price, int page, String field, String sortBy) {
		Sort sort = sortBy.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(field).ascending() : Sort.by(field).descending();
		Pageable pageable = PageRequest.of(page-1,5,sort);
		return productRepo.findByPrice(price, pageable);
	}

	@Override
	public List<Products> findByCategory(Category category, int page, String field, String sortBy) {
		Sort sort = sortBy.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(field).ascending() : Sort.by(field).descending();
		Pageable pageable = PageRequest.of(page-1,5,sort);
		return productRepo.findByCategory(category, pageable);
	}

}

