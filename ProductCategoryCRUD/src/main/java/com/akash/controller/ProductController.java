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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.akash.model.Category;
import com.akash.model.Products;
import com.akash.service.CategoryService;
import com.akash.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired ProductService productService;
	@Autowired CategoryService categoryService;
	
	@GetMapping("/getProductJSONForm")
	public ResponseEntity<Products> getProductJSONForm(){
		return new ResponseEntity<Products>(new Products(),HttpStatus.OK);
	}

	@GetMapping("/getCategoryJSONForm")
	public ResponseEntity<Category> getCategoryJSONForm(){
		return new ResponseEntity<Category>(new Category(),HttpStatus.OK);
	}
	
	@PostMapping("/addNewProduct")
	public ResponseEntity<Products> addNewProduct(@Valid @RequestBody Products product,BindingResult result){
		if(result.hasErrors()) {
			System.out.println("Error : "+result.getAllErrors());
			return new ResponseEntity<Products>(product,HttpStatus.BAD_REQUEST);
		}else {
			return new ResponseEntity<Products>(productService.addNewProduct(product),HttpStatus.OK);	
		}
	}
	
	@GetMapping("/getOneProduct/{productid}")
	public ResponseEntity<Products> getOneProduct(@PathVariable("productid") Integer productid){
		return new ResponseEntity<Products>(productService.getOneProduct(productid),HttpStatus.OK);
	}
	
	@PutMapping("/updateProduct")
	public ResponseEntity<Products> updateProduct(@Valid @RequestBody Products product,BindingResult result){
		if(result.hasErrors()) {
			System.out.println("Error : "+result.getAllErrors());
			return new ResponseEntity<Products>(product,HttpStatus.BAD_REQUEST);
		}else {
			return new ResponseEntity<Products>(productService.updateProduct(product),HttpStatus.OK);	
		}
	}
	
	@DeleteMapping("/deleteProduct/{productId}")
	public ResponseEntity<Boolean> deleteProduct(@PathVariable("productId") Integer productid){
		boolean flag = false;
		if(productid>0) {
			flag = productService.deleteProduct(productid);	
		}		
		return new ResponseEntity<Boolean>(flag,HttpStatus.OK);
	}
	
	@GetMapping("/getAllProducts")
	public ResponseEntity<List<Products>> getAllProducts(){
		return new ResponseEntity<List<Products>>(productService.getAllProducts(),HttpStatus.OK);
	}
	
	
	@GetMapping("/getAllProducts/{page}")
	public ResponseEntity<List<Products>> getProductsBypagination(@PathVariable("page") Integer page){
		return new ResponseEntity<List<Products>>(productService.findAllByPagination(page).getContent(),HttpStatus.OK);
	}
	
	@GetMapping("/getAllProductsSort/{page}")
	public ResponseEntity<List<Products>> getProductsBypaginationSort(@PathVariable("page") Integer page,
			@RequestParam("field") String field,@RequestParam("by") String sortBy){
		return new ResponseEntity<List<Products>>(productService.findAllByPaginationandSortbyField(page,field,sortBy).getContent(),HttpStatus.OK);
	}
	
	@GetMapping("/getAllProductsbyName/{page}")
	public ResponseEntity<List<Products>> getProductsByNamePaginationSort(@PathVariable("page") Integer page,
			@RequestParam("value") String name,@RequestParam("field") String field,@RequestParam("by") String sortBy){
		return new ResponseEntity<List<Products>>(productService.findByName(name, page, field, sortBy),HttpStatus.OK);
	}	
	
	@GetMapping("/getAllProductsbyPrice/{page}")
	public ResponseEntity<List<Products>> getProductsByPricePaginationSort(@PathVariable("page") Integer page,
			@RequestParam("value") Double price,@RequestParam("field") String field,@RequestParam("by") String sortBy){
		return new ResponseEntity<List<Products>>(productService.findByPrice(price, page, field, sortBy),HttpStatus.OK);
	}
	
	@GetMapping("/getAllProductsbyCategory/{page}")
	public ResponseEntity<List<Products>> getProductsByPricePaginationSort(@PathVariable("page") Integer page,
			@RequestParam("value") Integer categoryId,@RequestParam("field") String field,@RequestParam("by") String sortBy){
		Category category = categoryService.getCategoryById(categoryId);
		if(category!=null) {
			return new ResponseEntity<List<Products>>(productService.findByCategory(category, page, field, sortBy),HttpStatus.OK);
		}
		return new ResponseEntity<List<Products>>(HttpStatus.OK);
	}	
	
	
}
