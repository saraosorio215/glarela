package com.sara.glarelosangeles.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;


@Entity
@Table(name="products")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	private String productName;
	
	private Float productPrice;
	
	@NotEmpty
	private String description;
	
	@OneToMany(mappedBy="product", fetch = FetchType.LAZY)
	private List<ProductImage> productImages;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name = "cart_products",
			joinColumns = @JoinColumn(name = "product_id"),
			inverseJoinColumns = @JoinColumn(name="shoppingCart_id")
	)
	private List<ShoppingCart> shoppingCarts;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name = "order_products",
			joinColumns = @JoinColumn(name = "product_id"),
			inverseJoinColumns = @JoinColumn(name="order_id")
			)
	private List<Order> orders;
	
	//CONSTRUCTOR
	public Product(){
	}
	
	public Product(String productName, Float productPrice, String description) {
		this.productName = productName;
		this.productPrice = productPrice;
		this.description = description;
	}
	
	//GETTERS & SETTERS
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Float getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Float productPrice) {
		this.productPrice = productPrice;
	}

	public List<ProductImage> getProductImages() {
		return productImages;
	}

	public void setProductImages(List<ProductImage> productImages) {
		this.productImages = productImages;
	}

	public List<ShoppingCart> getShoppingCarts() {
		return shoppingCarts;
	}

	public void setShoppingCarts(List<ShoppingCart> shoppingCarts) {
		this.shoppingCarts = shoppingCarts;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	
}
