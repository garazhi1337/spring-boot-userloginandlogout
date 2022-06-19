package com.example.demo;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.repository.User;
import com.example.demo.repository.UserRepository;

@Controller
public class WebController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@GetMapping("/")
	public String getHome(Model model) {
		//Iterable<User> users = userRepository.findAll();
		model.addAttribute("users", userRepository.findAll());
		return "home";
	}
	
	@GetMapping("/registration")
	public String getRegistration(Model model) {
		return "registration";
	}
	
	@GetMapping("/add")
	public String getAddPicture(Model model) {
		return "addPicture";
	}
	
	@GetMapping("/pictures")
	public String getPicture(Model model) {
		return "pictures";
	}
	
	@PostMapping("/registration")
	public String addNewUser (@RequestParam String password, @RequestParam String email, @RequestParam String username) {

	    User user = new User(password, email, username);
	    String pwd = user.getPassword();
	    String encryptedPwd = passwordEncoder.encode(pwd);
	    user.setPassword(encryptedPwd);
	    userRepository.save(user);
	    return "home";
	}
	
	@GetMapping("/error")
	public String getError() {
		return "error";
	}
}
