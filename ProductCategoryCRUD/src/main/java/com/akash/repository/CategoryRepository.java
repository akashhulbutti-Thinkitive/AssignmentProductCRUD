package com.akash.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.akash.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{
	
	@Query(value = "SELECT * FROM category WHERE status='Active'",nativeQuery = true)
	public List<Category> findAllByStatus();
	
	@Query(value = "SELECT * FROM category WHERE status='Active' AND category_id=:category_id",nativeQuery = true)
	public Category findCategoryById(@Param("category_id") Integer category_id);

}
