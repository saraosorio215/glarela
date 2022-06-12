package com.sara.glarelosangeles.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import com.sara.glarelosangeles.models.Product;
import com.sara.glarelosangeles.models.ShoppingCart;
import com.sara.glarelosangeles.models.User;
import com.sara.glarelosangeles.services.ProductService;
import com.sara.glarelosangeles.services.ShoppingService;
import com.sara.glarelosangeles.services.UserService;

@Controller
public class MainController {

	@Autowired
	private ProductService prodServ;
	
	@Autowired
	private UserService userServ;
	
	@Autowired
	private ShoppingService shopServ;
	
	//GET MAPPING
	@GetMapping("/")
	public String index() {
		return "mainpage.jsp";
	}
	
	@GetMapping("/products")
	public String products(Product product, Model model) {
		model.addAttribute("allProducts", prodServ.allProds());
		return "products/products.jsp";
	}
	
	@GetMapping("/products/{id}")
	public String viewProduct(@PathVariable("id") Long id, Model model, HttpSession session) {
		User user = userServ.findById((Long) session.getAttribute("user_id"));
		Product product = prodServ.findOneProduct(id);
		ShoppingCart userCart = user.getShoppingCart();
		model.addAttribute("product", product);
		model.addAttribute("products", prodServ.allProds());
		model.addAttribute("userCart", userCart);
		return "products/viewone.jsp";
	}
	
	@PutMapping("/additem/")
	public String addToCart(@Valid @ModelAttribute("currentCart") Product product, BindingResult result, HttpSession session) {
		User user = userServ.findById((Long) session.getAttribute("user_id"));
		Long cartId = user.getShoppingCart().getId();
		ShoppingCart currentCart = shopServ.findById(cartId);
		currentCart.getProducts().add(product);
		shopServ.saveCart(currentCart);
		return "redirect:/products";

	}
	

}
