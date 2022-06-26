package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.demo.repository.PostRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.tables.Post;
import com.example.demo.tables.User;

@Service
public class PostService {

	@Autowired
	PostRepository postRepository;
	
	@Autowired
	UserRepository userRepository;
	
	public void savePost(String title, String fulltext) {
		Post post = new Post();
		post.setTitle(title);
		post.setFulltext(fulltext);
		
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
		  String username = ((UserDetails)principal).getUsername();
		  post.setUser(userRepository.findByUsername(username));
		  post.setAuthor(username);
		} else {
		  String username = principal.toString();
		}
		
		postRepository.save(post);
	}
}
