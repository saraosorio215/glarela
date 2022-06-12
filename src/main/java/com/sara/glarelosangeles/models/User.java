package com.sara.glarelosangeles.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message="First name is required!")
	@Size(min=2, max=50, message="First name must be at least 2 characters long!")
	private String firstName;
	
	@NotEmpty(message="Last name is required!")
	@Size(min=2, max=50, message="Last name must be at least 2 characters long!")
	private String lastName;
	
	@NotEmpty(message="Email is required!")
	@Email(message="Please enter a valid email")
	private String email;
	
	@NotEmpty(message="Password is required!")
	@Size(min=8, max=128, message="Password must be at least 8 characters long!")
	private String password;
	
	@Transient
	@NotEmpty(message="Confirm password is required!")
	@Size(min=8, max=50, message="Password must be between 8 and 50 characters long!")
	private String confirm;
	
	@OneToOne(mappedBy="user", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private ShoppingCart shoppingCart;
	
	@OneToMany(mappedBy="user", fetch=FetchType.LAZY)
	private List<Order> orders;
	
	// CONSTRUCTOR
	public User() {
		
	}
	
	// GETTERS & SETTERS

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirm() {
		return confirm;
	}

	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}

	public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}

	public void setShoppingCart(ShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
	
	
}
