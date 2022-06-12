package com.sara.glarelosangeles.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.sara.glarelosangeles.models.Product;
import com.sara.glarelosangeles.models.ProductImage;
import com.sara.glarelosangeles.services.ImageService;
import com.sara.glarelosangeles.services.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService prodServ;
	
	@Autowired
	private ImageService imageServ;

	@GetMapping("/createprod/")
	public String create(Model model) {
		model.addAttribute("newProduct", new Product());
		return "products/createproduct.jsp";
	}
	
	@GetMapping("/createimage/")
	public String image(Model model) {
		model.addAttribute("newImage", new ProductImage());
		return "products/createimage.jsp";
	}
	
	//POST MAPPING	
	@PostMapping("/create/product/")
	public String createProd(@Valid @ModelAttribute("newProduct") Product product, BindingResult result) {
		if(result.hasErrors()) {
			return "createproduct.jsp";
		}
		else {
			prodServ.createProd(product);
			return "redirect:/createprod/";
		}
	}
	
	@PostMapping("/create/image/")
	public String createImage(@Valid @ModelAttribute("newImage") ProductImage productImage, BindingResult result) {
		if(result.hasErrors()) {
			return "createimage.jsp";
		}
		else {
			imageServ.createImage(productImage);
			return "redirect:/createimage/";
		}
	}
}
