package com.cg.cars.model;

import org.springframework.stereotype.Component;

@Component
public class UserDTO {
private int id;
	
	
	private String password;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public UserDTO(int id, String password) {
		super();
		this.id = id;
		this.password = password;
	}


	public UserDTO() {
		super();
	
	}
	

}
