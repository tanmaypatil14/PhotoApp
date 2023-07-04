package com.appdeveloperblog.photoapp.api.user.model;

public class ResponseUserDTO {

	private String firstName;
	private String lastName;
	private String email;

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

	public ResponseUserDTO(String firstName, String lastName, String email, String userId, String encryptedPassword) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.userId = userId;
		this.encryptedPassword = encryptedPassword;
	}

	public ResponseUserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "ResponseUserDTO [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", userId="
				+ userId + ", encryptedPassword=" + encryptedPassword + "]";
	}

}
