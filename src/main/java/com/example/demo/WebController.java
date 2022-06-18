package com.example.demo;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.user.Role;
import com.example.demo.user.User;
import com.example.demo.user.UserRepository;

@Controller
public class WebController {
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/")
	public String getHome(Model model) {
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

	    User user = new User(password, email, username, true);
	    userRepository.save(user);
	    return "home";
	}
}
