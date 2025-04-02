package com.example.demo.entities;

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
	
	@Column(name = "age", nullable = true)
	private Integer age;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "birthdate", nullable = true)
	private java.util.Date birthdate;
	
	@ManyToOne
	@JoinColumn(name = "id_course", referencedColumnName = "id_course")
	private Course course;

}
