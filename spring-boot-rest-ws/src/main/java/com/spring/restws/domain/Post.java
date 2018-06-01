package com.spring.restws.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Post {
	@Id
	@GeneratedValue
	private Integer id;
	
	private String desc;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JsonIgnore
	private User user;
	
	public Post() {
		super();
	}

	public Post(Integer id, String desc, User user) {
		super();
		this.id = id;
		this.desc = desc;
		this.user = user;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", desc=" + desc + "]";
	}
	
	
}
