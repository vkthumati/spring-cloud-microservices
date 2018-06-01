package com.spring.restws.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User {
	
	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	private Date birthDate;
	private String emailId;
	private String phone;
	private String address;
	private String pwd;
	private String gender;
	private Integer age;
	private String profession;
	
	@OneToMany(mappedBy="user")
	private List<Post> post;
	
	public User() {
		super();
	}

	public User(Integer id, String name, Date birthDate, String emailId, String phone, String address, String pwd,
			String gender, Integer age, String profession) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
		this.emailId = emailId;
		this.phone = phone;
		this.address = address;
		this.pwd = pwd;
		this.gender = gender;
		this.age = age;
		this.profession = profession;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public List<Post> getPost() {
		return post;
	}

	public void setPost(List<Post> post) {
		this.post = post;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", birthDate=" + birthDate + ", emailId=" + emailId + ", phone="
				+ phone + ", address=" + address + ", pwd=" + pwd + ", gender=" + gender + ", age=" + age
				+ ", profession=" + profession + "]";
	}
	
	
}
