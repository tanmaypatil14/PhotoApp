package com.appdeveloperblog.photoapp.api.user.model;

import java.io.Serializable;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UserDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1885916055523415995L;

	@NotNull(message = "First Name can not be null")
	private String firstName;
	@NotNull(message = "Last Name can not be null")
	private String lastName;
	@NotNull(message = "Email can not be null")
	@Email
	private String email;
	@NotNull(message = "Password can not be null")
	@Size(min = 8, max = 16, message = "Password must be equal or greater than 8 and less that 16 characters")
	private String password;

	private String userId;
	private String encryptedPassword;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

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

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getEncryptedPassword() {
		return encryptedPassword;
	}

	public void setEncryptedPassword(String encryptedPassword) {
		this.encryptedPassword = encryptedPassword;
	}

	public UserDTO(String firstName, String lastName, String email, String password, String userId,
			String encryptedPassword) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.userId = userId;
		this.encryptedPassword = encryptedPassword;
	}

	public UserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "UserDTO [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", password="
				+ password + ", userId=" + userId + ", encryptedPassword=" + encryptedPassword + "]";
	}

}
