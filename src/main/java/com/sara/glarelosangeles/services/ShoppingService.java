package com.sara.glarelosangeles.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sara.glarelosangeles.models.ShoppingCart;
import com.sara.glarelosangeles.repositories.ShoppingRepository;

@Service
public class ShoppingService {

	@Autowired
	private ShoppingRepository shopRepo;
	
	public ShoppingCart findById(Long id) {
		Optional<ShoppingCart> cart = shopRepo.findById(id);
		if(cart.isPresent()) {
			return cart.get();
		}
		else {
			return null;
		}
	}
	
	public ShoppingCart saveCart(ShoppingCart cart) {
		return shopRepo.save(cart);
	}
	
}
