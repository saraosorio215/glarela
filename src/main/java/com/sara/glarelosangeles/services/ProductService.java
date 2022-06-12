package com.sara.glarelosangeles.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sara.glarelosangeles.models.Product;
import com.sara.glarelosangeles.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository prodRepo;
	
	//CREATE PRODUCT
	public Product createProd(Product product) {
		return prodRepo.save(product);
	}
	
	//FIND ALL
	public List<Product> allProds(){
		return prodRepo.findAll();
	}
	
	public Product findOneProduct(Long id) {
		Optional<Product> product = prodRepo.findById(id);
		if(product.isPresent()) {
			return product.get();
		}
		else {
			return null;
		}
	}
}
