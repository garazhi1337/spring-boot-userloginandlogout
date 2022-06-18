package com.example.demo.repository;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.example.demo.security.ERole;

@Entity
@Table(name="people")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String password;
	private String email;
	private String username;
	@Enumerated()
	private ERole role;
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEmail() {
		return email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public ERole getRole() {
		return role;
	}

	public void setRole(ERole role) {
		this.role = role;
	}

	public User() {
		
	}
	
	public User(String password, String email, String username) {
		this.username = username;
		this.password = password;
		this.email = email;
	}
}
