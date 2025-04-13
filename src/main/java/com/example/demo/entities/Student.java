package com.example.demo.entities;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;

@Entity
@Table(name = "students")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_student", nullable = false)
	private Integer id;
	
	@Column(name = "first_name", nullable = false, length = 500)
	private String firstName;
	
	@Column(name = "last_name", nullable = false, length = 500)
	private String lastName;
	
	@Column(name = "email", nullable = true, length = 200, unique = true)
	private String email;
	
	@Column(name = "password", nullable = true, length = 200)
	private String password;
	
	@Column(name = "age", nullable = true)
	private Integer age;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "birthdate", nullable = true)
	private java.util.Date birthdate;

	public StudentStatus getStatus() {
		return status;
	}

	public void setStatus(StudentStatus status) {
		this.status = status;
	}

	@Enumerated(EnumType.STRING)
	private StudentStatus status;
	
	@ManyToOne
	@JoinColumn(name = "id_course", referencedColumnName = "id_course")
	private Course course;
	
	@OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
	//@JsonManagedReference
	@JsonIgnoreProperties("student") // ignora solo il campo inverso durante serializzazione
	private StudentDetail studentDetail;

	public StudentDetail getStudentDetail() {
		return studentDetail;
	}

	public void setStudentDetail(StudentDetail studentDetail) {
		this.studentDetail = studentDetail;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public java.util.Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(java.util.Date birthdate) {
		this.birthdate = birthdate;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
}