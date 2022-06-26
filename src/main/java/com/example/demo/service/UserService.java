package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.repository.UserRepository;
import com.example.demo.tables.User;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	public void saveUser(String username, String password, String email) {
	    User user = new User(password, email, username);
	    String pwd = user.getPassword();
	    String encryptedPwd = passwordEncoder.encode(pwd);
	    user.setPassword(encryptedPwd);
	    userRepository.save(user);
	}
	
	public void addAllUsersToModel(Model model) {
		model.addAttribute("users", userRepository.findAll());
	}
}
