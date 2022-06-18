package com.example.demo.security;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

public enum ERole {
	USER(Set.of(Permission.READ)),
	ADMIN(Set.of(Permission.WRITE, Permission.READ));
	
	ERole(Set<Permission> permissions) {
		this.permissions = permissions;
	}

	public Set<Permission> getPermission() {
		return permissions;
	}

	public Set<SimpleGrantedAuthority> getAuthorities() {
		return getPermission().stream().map(permissions -> new SimpleGrantedAuthority(permissions.getPermission()))
				.collect(Collectors.toSet());
	}
	
	private final Set<Permission> permissions;
}
