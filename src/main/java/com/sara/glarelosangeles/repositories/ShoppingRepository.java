package com.sara.glarelosangeles.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sara.glarelosangeles.models.ShoppingCart;

@Repository
public interface ShoppingRepository extends CrudRepository<ShoppingCart, Long> {

	List<ShoppingCart> findAll();
	
}
