package com.gaospot.cms.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gaospot.cms.db.UserRepository;
import com.gaospot.cms.domain.Users;

@Controller
@RequestMapping("/user")
public class UserController {

	private UserRepository userRepository;
	
	@Autowired
	public UserController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String showRegistrationForm() {
		return "registerForm";
	}
	 
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String processRegistration(
			@Valid RegisterForm registerUser,
			Errors errors) {
	    if (errors.hasErrors()) {
	        return "registerForm";
	      }
	    Users users = new Users(registerUser.getUsername(),
	    					registerUser.getPassword(),
	    					registerUser.getPhone(),
	    					registerUser.getEmail()
	    		);
		userRepository.save(users);
		return "redirect:/user/" + 
				users.getUsername();
	}

	@RequestMapping(value="/{username}", method=RequestMethod.GET)
	public String showUserProfile(@PathVariable String username, Model model) {
		Users users = userRepository.findByUsername(username);
		model.addAttribute(users);
		return "profile";
		
	}
}
