package com.example.util;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.entites.Users;

public class MyUserDetails implements UserDetails {

	
	private String userName;
	private String password;
	private List<GrantedAuthority> authorities;
	
	public MyUserDetails() {
	}
	
	public MyUserDetails(Users users) {
		this.userName=users.getName();
		this.password=users.getPassword();
		this.authorities=Arrays.stream(users.getRole().split(",")).map(SimpleGrantedAuthority::new).collect(Collectors.toList());
		//this.authorities=Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
