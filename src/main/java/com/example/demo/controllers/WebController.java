package com.example.demo.controllers;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.repository.UserRepository;
import com.example.demo.service.PostService;
import com.example.demo.service.UserService;
import com.example.demo.tables.User;

@Controller
public class WebController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	PostService postService;
	
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
	}
	
	@GetMapping("/calculator")
	public String getCalculator() {
		return "calculator";
	}
	
	@GetMapping("/posts") 
	public String getWather(Model model) {
		postService.addAllPostsToModel(model);
		return "posts";
	}
	
	@GetMapping("/posts/add")
	public String getAdd() {
		return "add";
	}
	
	@PostMapping("/posts/add")
	public String addPost(@RequestParam String title, @RequestParam String fulltext) {
		postService.savePost(title, fulltext);
		return "redirect:/posts";
	}
}
