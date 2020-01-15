package com.userfront.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.userfront.domain.User;
import com.userfront.service.UserService;

@Controller
public class HomeController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/")
	public String home() {
		return "redirect:/index";
	}
	
	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	
	@RequestMapping(value="/signup", method = RequestMethod.GET)
	public String signup(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "signup";
	}
	
	@RequestMapping(value="/signup", method = RequestMethod.POST)
	public String signupPost(@ModelAttribute("user") User user, Model model) {
		if(userService.checkUserExists(user.getUsername(), user.getEmail())) {
			/*
			 * usernameExists dhe emailExists - vijne nga SignUp HTMl
			 * Thymeleaf boolean th:if="${usernameExists} qe i dergojme vlere true ose false
			 */
			
			if(userService.checkExistingUsername(user.getUsername())) {
				model.addAttribute("usernameExists", true);
			}
			if(userService.checkExistingMail(user.getEmail())){
				model.addAttribute("emailExists", true);
			}
			return "signup";
			
		}
		else {
			userService.saveUser(user);
			return "redirect:/";
		}
	}
}
