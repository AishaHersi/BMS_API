package com.BMS_API.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.context.annotation.Primary;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class DAOUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(unique=true)
	private String username;
	@Column
	@JsonIgnore
	private String password;
	@Column
	private String name;
	@Column
	private String address;
	@Column
	private String contact_info;
	@Column
	private int role;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public DAOUser(){}
	public DAOUser(String username, String password, String name, String address, String contact_info, int role) {
		this.username = username;
		this.password = password;
		this.name = name;
		this.address = address;
		this.contact_info = contact_info;
		this.role = role;
	}
}