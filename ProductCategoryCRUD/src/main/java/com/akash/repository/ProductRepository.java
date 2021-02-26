package com.akash.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.akash.model.Category;
import com.akash.model.Products;

@Repository
public interface ProductRepository extends JpaRepository<Products, Integer> {
	
	@Query(value = "SELECT * FROM products WHERE status='Active'",nativeQuery = true)
	public List<Products> findAllByStatus();
	
	@Query(value = "SELECT * FROM products where status='Active' AND productid=:productid",nativeQuery = true)
	public Products findProductById(@Param("productid") Integer productid);
	
	public List<Products> findByName(String name,Pageable pageable);
	
	public List<Products> findByPrice(Double price,Pageable pageable);
	
	public List<Products> findByCategory(Category price,Pageable pageable);

}
