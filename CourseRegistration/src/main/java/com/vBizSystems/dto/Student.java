package com.vBizSystems.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;


@Entity
public class Student {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@GeneratedValue(strategy = GenerationType.IDENTITY,generator = "native")
	//@GenericGenerator(name = "native",strategy = "native")
	private int id;
	private String std_name;
	private String father_name;
	private String gender;
	private String contact;
	@Column(unique = true)
	private String username;
	private String password;
	@ManyToMany(fetch = FetchType.EAGER,cascade = {CascadeType.DETACH,CascadeType.MERGE,
			                                       CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinTable(name = "course_student",
	           joinColumns = @JoinColumn(name="student_id"),
	           inverseJoinColumns = @JoinColumn(name="course_id"))
	private List<Course> courses;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStd_name() {
		return std_name;
	}
	public void setStd_name(String std_name) {
		this.std_name = std_name;
	}
	public String getFather_name() {
		return father_name;
	}
	public void setFather_name(String father_name) {
		this.father_name = father_name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
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
	public List<Course> getCourses() {
		return courses;
	}
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	} 
	
	public Student() {
		// TODO Auto-generated constructor stub
	}
	public Student(String std_name, String father_name, String gender, String contact, String username, String password,
			List<Course> courses) {
		super();
		this.std_name = std_name;
		this.father_name = father_name;
		this.gender = gender;
		this.contact = contact;
		this.username = username;
		this.password = password;
		this.courses = courses;
	}
	
	@Override
	public String toString() {
		return "Student [std_name=" + std_name + ", father_name=" + father_name + ", gender=" + gender + ", contact="
				+ contact + ", username=" + username + ", password=" + password + "]";
	}
	
	
}
