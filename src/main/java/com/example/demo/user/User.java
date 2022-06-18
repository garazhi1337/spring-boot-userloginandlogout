package com.example.demo.user;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="people")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String password;
	private String email;
	private String username;
	private boolean active;
	
	/*@ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
	@CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
	@Enumerated(EnumType.STRING)
	private Set<Role> roles;*/
	
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

	/*public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> user) {
		this.roles = user;
	}*/

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean isActive) {
		this.active = isActive;
	}

	public User() {
		
	}
	
	public User(String password, String email, String username, boolean active) {
		
		this.active = true;
		this.username = username;
		this.password = password;
		this.email = email;
	}
}
