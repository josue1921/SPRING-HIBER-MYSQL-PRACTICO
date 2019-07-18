package com.app.domain.dto;

public class User {
	private Integer userId;
	private String email;
	private String firstName;
	private String lastName;
	private String password;
	private Blog blog;
	
	@Override
	public String toString() {
		return "User[Id =" + userId + ", email=" + email
			+ ", password=" + password + ", firstName=" + firstName 
			+ ", lastName=" + lastName + "]";
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Blog getBlog() {
		return blog;
	}

	public void setBlog(Blog blog) {
		this.blog = blog;
	}
}
