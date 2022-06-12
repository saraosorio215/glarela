package com.sara.glarelosangeles.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sara.glarelosangeles.models.ProductImage;

@Repository
public interface ImageRepository extends CrudRepository<ProductImage, Long> {
	
	List<ProductImage> findAll();
}
