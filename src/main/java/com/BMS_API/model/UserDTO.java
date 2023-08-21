package com.BMS_API.model;

public class UserDTO {
	private String username;
	private String password;
	private String name;
	private String address;
	private String contact_info;
	private int role;//1- admin , 2- publisher;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContact_info() {
		return contact_info;
	}

	public void setContact_info(String contact_info) {
		this.contact_info = contact_info;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}
}