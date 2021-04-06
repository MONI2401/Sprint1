package com.cg.cars.service;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import com.cg.cars.entities.User;
import com.cg.cars.exception.UserException;

@SuppressWarnings("serial")
public class UserPrinciple implements IUserServices {

	private User user;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		return Collections.singleton(new SimpleGrantedAuthority("USER"));
	}

	public UserPrinciple(User user) {
		super();
		this.user = user;
	}

	@Override
	public String getPassword() {

		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {

		return true;
	}

	@Override
	public boolean isAccountNonLocked() {

		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {

		return true;
	}

	@Override
	public boolean isEnabled() {

		return true;
	}

	@Override
	public Void signIn(User user) {
		if (user.getUsername() == "admin" || user.getUsername() == "user")
			throw new UserException("You have successfully signed in");
		else
			throw new UserException("Sign-in failed");

	}

	@Override
	public String signOut() {
		return "Successfully Signed out";
	}

}
