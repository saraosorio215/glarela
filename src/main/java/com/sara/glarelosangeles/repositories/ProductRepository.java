package com.sara.glarelosangeles.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sara.glarelosangeles.models.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
	
	List<Product> findAll();
}
