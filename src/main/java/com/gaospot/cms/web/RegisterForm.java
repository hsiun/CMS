package com.gaospot.cms.web;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.gaospot.cms.domain.Users;

public class RegisterForm {
	@NotNull
	@Size(min=3, max=16)
	private String username;
	@NotNull
	private String password;
	@NotNull
	private String phone;
	@NotNull
	private String email;
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public String getPhone() {
		return phone;
	}
	public String getEmail() {
		return email;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Users toUser() {
		return new Users(username, password, phone, email);
	}
	

}
