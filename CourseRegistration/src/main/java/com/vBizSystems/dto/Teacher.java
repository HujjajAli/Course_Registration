package com.vBizSystems.dto;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Teacher {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String teacherName;
	private String gender;
	private String education;
	@OneToOne(fetch = FetchType.LAZY,mappedBy = "teacher",cascade  = {CascadeType.DETACH,CascadeType.MERGE,
		                                                              CascadeType.PERSIST,CascadeType.REFRESH})
	private Course course;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	
	
	public Teacher() {
		// TODO Auto-generated constructor stub
	}
	public Teacher(String teacherName, String gender, String education) {
		super();
		this.teacherName = teacherName;
		this.gender = gender;
		this.education = education;
		this.course = course;
	}
	

}
