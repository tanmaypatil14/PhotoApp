package com.appdeveloperblog.photoapp.api.user.model;

public class LoginRequestModel {

	private String email;
	private String password;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LoginRequestModel(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public LoginRequestModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "LoginRequestModel [email=" + email + ", password=" + password + "]";
	}

}
