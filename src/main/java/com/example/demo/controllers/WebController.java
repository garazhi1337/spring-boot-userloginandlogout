package com.example.demo.controllers;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import com.example.demo.tables.User;

@Controller
public class WebController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/")
	public String getHome(Model model) {
		userService.addAllUsersToModel(model);
		return "home";
	}
	
	@GetMapping("/registration")
	public String getRegistration(Model model) {
		return "registration";
	}
	
	@PostMapping("/registration")
	public void addNewUser (@RequestParam String password, @RequestParam String email, @RequestParam String username) {
		userService.saveUser(username, password, email);
	    //return "home";
	}
	
	@GetMapping("/calculator")
	public String getCalculator() {
		return "calculator";
	}
	
	@GetMapping("/weather") 
	public String getWather() {
		return "weather";
	}
}
