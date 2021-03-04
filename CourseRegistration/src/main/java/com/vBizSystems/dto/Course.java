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
import javax.persistence.OneToOne;

@Entity
public class Course {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(unique = true)
	private String courseName;
	private String description;
	@ManyToMany(fetch = FetchType.LAZY,cascade = {CascadeType.DETACH,CascadeType.MERGE,
			                                      CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinTable(name = "course_student",
			   joinColumns = @JoinColumn(name = "course_id"),
			   inverseJoinColumns = @JoinColumn(name = "student_id"))
	private List<Student> students;
	@OneToOne(fetch = FetchType.EAGER,cascade = {CascadeType.DETACH,CascadeType.MERGE,
			                                    CascadeType.PERSIST,CascadeType.REFRESH})
	private Teacher teacher;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	
	
	public Course() {
		// TODO Auto-generated constructor stub
	}
	public Course(String courseName, String description, Teacher teacher) {
		super();
		this.courseName = courseName;
		this.description = description;
		this.teacher = teacher;
	}
	
	

}
