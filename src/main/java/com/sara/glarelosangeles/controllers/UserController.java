package com.sara.glarelosangeles.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.sara.glarelosangeles.models.LoginUser;
import com.sara.glarelosangeles.models.Order;
import com.sara.glarelosangeles.models.ShoppingCart;
import com.sara.glarelosangeles.models.User;
import com.sara.glarelosangeles.services.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userServ;
	
	//GET MAPPING
	@GetMapping("/register")
	public String index(Model model, HttpSession session) {
    	Long sesh = (Long) session.getAttribute("user_id");
    	if(sesh != null) {
    		return "redirect:/dashboard";
    	}
		 model.addAttribute("newUser", new User());
	     return "users/register.jsp";
	}
	
	@GetMapping("/login")
	public String indexTwo(Model model, HttpSession session) {
    	Long sesh = (Long) session.getAttribute("user_id");
    	if(sesh != null) {
    		return "redirect:/dashboard";
    	}
	     model.addAttribute("newLogin", new LoginUser());
	     return "users/login.jsp";
	}
	
	
	@GetMapping("/dashboard")
	public String home(Model model, HttpSession session) {
    	Long sesh = (Long) session.getAttribute("user_id");
    	if(sesh == null) {
    		return "redirect:/login";
    	}
		User user = userServ.findUser(sesh);
		model.addAttribute("user", user);
		List<Order> userOrders = user.getOrders();
		model.addAttribute("orders", userOrders);
		ShoppingCart currentCart = user.getShoppingCart();
		model.addAttribute("currentCart", currentCart);
		return "users/dashboard.jsp";
	}
	
	@GetMapping("/logout/")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	//POST MAPPING
	@PostMapping("/register/")
	public String registerUser(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, Model model, HttpSession session) {
		// REGISTER USER FIRST!!!!!!
		userServ.registerUser(newUser, result);
		if(result.hasErrors()) {
			model.addAttribute("newLogin", new LoginUser());
		    return "register.jsp";
		}
		else {
			session.setAttribute("user_id", newUser.getId());
			User user = userServ.findById((Long) session.getAttribute("user_id"));
			user.setShoppingCart(new ShoppingCart());
			return "redirect:/dashboard";
		}
	}
	
	@PostMapping("/login/")
	public String loginUser(@Valid @ModelAttribute("newLogin") LoginUser newLogin, BindingResult result, Model model, HttpSession session) {
		 User user = userServ.loginUser(newLogin, result);  
	     if(result.hasErrors()) {
	    	 model.addAttribute("newUser", new User());
	    	 return "login.jsp";
	        }
	        else {
	        	session.setAttribute("user_id", user.getId());
	        	return "redirect:/dashboard";        	
	        }
	}
	
}
