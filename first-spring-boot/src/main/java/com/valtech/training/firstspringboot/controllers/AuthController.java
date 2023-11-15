package com.valtech.training.firstspringboot.controllers;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.valtech.training.firstspringboot.entities.User;
import com.valtech.training.firstspringboot.models.ChangePasswordModel;
import com.valtech.training.firstspringboot.models.RegisterUserModel;
import com.valtech.training.firstspringboot.services.AuthService;

@Controller
public class AuthController {

	@Autowired
	private AuthService authService;
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	//for everybodyy
	@GetMapping("/anon")
	@ResponseBody
	public String anonPage() {
		return "Anonymous Page";
	}
	
	//logged in general access
	@GetMapping("/user")
	@ResponseBody
	public String userPage() {
		return "User Page";
	}
	
	
	//Restrict access
	@GetMapping("/admin")
	@ResponseBody
	public String adminPage() {
		return "Admin Page";
	}
	
	//Registration
	
	//opens register page
	@GetMapping("/register")
	public String registerForm() {
		return "register";
	}

	//called after submitting on register page
	@PostMapping("/register")
	public String handleRegistration(@ModelAttribute RegisterUserModel registerModel, Model model) {
//		if(registerModel.getPassword().equals(registerModel.getConfirmPassword())){                -----------> one of the strings could be NULL (throws NullPointerException), use StringUtils/Objects
		if(Objects.equals(registerModel.getPassword(),registerModel.getConfirmPassword())) {
			authService.createUser(registerModel);
			model.addAttribute("message", "User Registration Successful. Please login to proceed.");
		}else {
			model.addAttribute("message", "Password and confirm password doesn't match");
			return "register";
		}
		return "login";
	}
	
	//Change Password
	
	@GetMapping("/changePassword")
	public String changePasswordForm() {
		return "changePassword";
	}

	@PostMapping("/changePassword")
	public String handleChangePassword(@AuthenticationPrincipal UserDetails userDetails,  @ModelAttribute ChangePasswordModel changePasswordModel, Model model) {
		changePasswordModel.setUsername(userDetails.getUsername());
		if(Objects.equals(changePasswordModel.getNewPassword(),changePasswordModel.getConfirmPassword())) {
			if(authService.changePassword(changePasswordModel)) {
				model.addAttribute("message", "Password changed successfully");
			}else {
				model.addAttribute("message", "Old password doesn't match");
				return "changePassword";
			}
		}else {
			model.addAttribute("message", "Password and Confirm password doesn't match");
			return "changePassword"; 
		}
		return "redirect:logout";
	}
}
