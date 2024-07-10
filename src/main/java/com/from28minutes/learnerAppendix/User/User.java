package com.from28minutes.learnerAppendix.User;

import jakarta.validation.constraints.Size;

public class User {
	
	private int id;
	
	@Size(min = 2, message = "Name should be greater then 2 characters")
	private String name;
	
	@Size(min = 5, message = "Description should be greater then 5 characters")
	private String description;
	
	public User(int id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	
	
}
