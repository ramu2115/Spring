package com.bookshop.model;

import java.io.Serializable;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class LoginForm implements Serializable {
	
	@NotEmpty
	private String userName;
	
	@NotEmpty
	@Size(min = 5)
	private String password;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
