package com.from28minutes.learnerAppendix.Learn_spring_boot.User;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Size;

@Entity(name="user_details")
public class User {
	
	@Id
	@GeneratedValue
	private int id;
	
	@Size(min = 2, message = "Name should be greater then 2 characters")
	private String name;
	
	@Size(min = 5, message = "Description should be greater then 5 characters")
	private String description;
	
	@OneToMany(mappedBy = "user")
	@JsonIgnore
	private List<Post> posts;
	
	public User() {
		
	}
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
	public List<Post> getPosts() {
		return posts;
	}
	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", description=" + description + ", posts=" + posts + "]";
	}

	
	
}
