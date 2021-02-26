package com.akash.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.springframework.lang.NonNull;

@Entity
@Table(name = "category")
public class Category implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "categoryId")
	private int categoryId;
	
    @Column(name = "categoryName")
    @Size (max = 25,min = 2 ,message = "Size of Catgory Name should be of 2-25 length")
    @NonNull
	private String categoryName;
    
    @Column(name = "status")
    @Size (max = 25,min = 2 ,message = "Size of Catgory status be of 2-12 length")
    @NonNull
    private String status;
//	
//	@OneToMany(mappedBy = "category",cascade = CascadeType.PERSIST)
//	private Set<Products> products = new HashSet<Products>(); 

	public Category() {
	}

	public Category(int categoryId,
			@Size(max = 25, min = 2, message = "Size of Catgory Name should be of 2-25 length") String categoryName,
			@Size(max = 25, min = 2, message = "Size of Catgory status be of 2-12 length") String status
//			,Set<Products> products
			) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.status = status;
//		this.products = products;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
/*
	public Set<Products> getProducts() {
		return products;
	}

	public void setProducts(Set<Products> products) {
		this.products = products;
	}
*/
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + categoryId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		if (categoryId != other.categoryId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", categoryName=" + categoryName + ", status=" + status
//				+ ", products=" + products 
				+ "]";
	}
	
}
