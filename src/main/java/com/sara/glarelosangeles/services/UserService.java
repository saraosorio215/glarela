package com.sara.glarelosangeles.services;


import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.sara.glarelosangeles.models.LoginUser;
import com.sara.glarelosangeles.models.User;
import com.sara.glarelosangeles.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	public User findById(Long id) {
		Optional<User> user = userRepo.findById(id);
		if(user.isPresent()) {
			return user.get();
		}
		else {
			return null;
		}
	}
	
	//CREATE
		public User registerUser(User newUser, BindingResult result) {
			String email = newUser.getEmail();
			Optional<User> potentialUser = userRepo.findByEmail(email);
	    	if(potentialUser.isPresent()) {
	    		result.rejectValue("email", "registerErrors", "Registration information not valid");
	    	}
	    	
	    	if(!newUser.getPassword().equals(newUser.getConfirm())) {
	    		result.rejectValue("confirm", "registerErrors", "The confirm password must match password!");
	    	}
	        
	    	if(result.hasErrors()) {
	    		return null;
	    	}
	    	else {
	    		String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
	    		newUser.setPassword(hashed);
	    		return userRepo.save(newUser);    		
	    	}
		}
		
		//LOGIN
		public User loginUser(LoginUser newLoginObject, BindingResult result) {
	        Optional<User> currentUser = userRepo.findByEmail(newLoginObject.getEmail());
	        if(!currentUser.isPresent()) {
	        	result.rejectValue("email", "loginErrors", "Login information incorrect");
	        }
	        else {
	        	User user = currentUser.get();
	        	if(!BCrypt.checkpw(newLoginObject.getPassword(), user.getPassword())) {
	        		result.rejectValue("password", "loginErrors", "Invalid Password!");
	        	}
	        	if(result.hasErrors()) {
	        		return null;
	        	}
	        	else {
	        		return user;
	        	}
	        	
	        }
	        return null;
		}
		
		//FIND ONE
		public User findUser(Long id) {
			Optional<User> optionalUser = userRepo.findById(id);
			if(optionalUser.isPresent()) {
				return optionalUser.get();
			}
			else {
				return null;
			}
		}
		
		//FIND ALL
		public List<User> findAllUsers() {
			return userRepo.findAll();
		}
		
		//UPDATE
		public User updateUser(User user) {
			return userRepo.save(user);
		}
		
		//DELETE
		public void deleteUser(Long id) {
			userRepo.deleteById(id);
			return;
		}
}
