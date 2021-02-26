package com.akash.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="products")
//@JsonIgnoreProperties({"hibernateLazyInitializer","handler","category"})
public class Products implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int productID;
    @Column(name = "name")
    @Size (max = 25,min = 2 ,message = "Size of Product Name should be of 2-25 length")
    @NonNull
	private String name;
    @Column(name = "quantity")
	private int quantity;
    @Column(name = "price")
	private double price;
    @Column(name = "status")
    private String status;
	@ManyToOne
	private Category category;
	
	public Products() {
		// TODO Auto-generated constructor stub
	}

	public Products(int productID,
			@Size(max = 25, min = 2, message = "Size of Product Name should be of 2-25 length") String name,
			int quantity, double price, String status, Category category) {
		super();
		this.productID = productID;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		this.status = status;
		this.category = category;
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + productID;
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
		Products other = (Products) obj;
		if (productID != other.productID)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Products [productID=" + productID + ", name=" + name + ", quantity=" + quantity + ", price=" + price
				+ ", status=" + status + ", category=" + category.getCategoryName() + "]";
	}

}
