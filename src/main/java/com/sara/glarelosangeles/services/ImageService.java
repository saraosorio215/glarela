package com.sara.glarelosangeles.services;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sara.glarelosangeles.models.ProductImage;
import com.sara.glarelosangeles.repositories.ImageRepository;


@Service
public class ImageService {
	@Autowired
	private ImageRepository imageRepo;
	
	
	//CREATE PRODUCT IMAGE
	public ProductImage createImage(ProductImage prodImage) {
		return imageRepo.save(prodImage);
	}
	
	//FIND BY ID
	public ProductImage findImage(Long id){
		Optional<ProductImage> productImg = imageRepo.findById(id);
		if(productImg.isPresent()) {
			return productImg.get();
		}
		else {
			return null;
		}
	}
	

}
