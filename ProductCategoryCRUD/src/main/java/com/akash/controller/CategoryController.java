package com.akash.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.akash.model.Category;
import com.akash.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {
	
	@Autowired CategoryService categoryService;

	
	@GetMapping("/getAllCategory")
	public ResponseEntity<List<Category>> getAllCategory(){
		return new ResponseEntity<List<Category>>(categoryService.finaAllByStatus(),HttpStatus.OK);
	}
	
	@GetMapping("/getOneCategory/{category_id}")
	public ResponseEntity<Category> getOneCategory(@PathVariable("category_id") Integer category_id){
		return new ResponseEntity<Category>(categoryService.getCategoryById(category_id) ,HttpStatus.OK);
	}
	
	@PostMapping("/addNewCategory")
	public ResponseEntity<Category> addNewCategory(@Valid @RequestBody Category category ,BindingResult result){
		if(!result.hasErrors()) {
			return new ResponseEntity<Category>(categoryService.addNewCategory(category),HttpStatus.OK);
		}
		return new ResponseEntity<Category>(category,HttpStatus.BAD_REQUEST);
		
	}	
	
	@PutMapping("/updateCategory")
	public ResponseEntity<Category> updateCategory(@Valid @RequestBody Category category ,BindingResult result){
		if(!result.hasErrors()) {
			return new ResponseEntity<Category>(categoryService.updateCategory(category),HttpStatus.OK);
		}
		return new ResponseEntity<Category>(category,HttpStatus.BAD_REQUEST);
		
	}
	
	@DeleteMapping("/deleteCategory/{deleteId}")
	public ResponseEntity<Boolean>  deleteCategory(@PathVariable("deleteId") Integer categoryId){
		boolean flag = false;
		if(categoryId>0) {
			flag = categoryService.deleteCategory(categoryId);
			return new ResponseEntity<Boolean>(flag,HttpStatus.OK);
		}
		return new ResponseEntity<Boolean>(flag,HttpStatus.BAD_REQUEST);
		
	}
	
}
