package com.example.demo.dtos;

import java.util.Date;

import com.example.demo.entities.Student;

public record StudentDTO {

	private Integer id;
	private String firstName;
	private String lastName;
	private String email;
	private Integer age;
	private Date birthdate;
	private String courseName;

	// Costruttori
	public StudentDTO() {
	}

	public StudentDTO(Integer id, String firstName, String lastName, String email, Integer age, Date birthdate,
			String courseName) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.age = age;
		this.birthdate = birthdate;
		this.courseName = courseName;
	}

	// Metodo per convertire un oggetto Student in StudentDTO
	public static StudentDTO fromEntity(Student student) {
		return new StudentDTO(
				student.getId(), 
				student.getFirstName(), 
				student.getLastName(), 
				student.getEmail(),
				student.getAge(), 
				student.getBirthdate(),
				student.getCourse() != null ? student.getCourse().getCourseName() : null
			);
	}

	// Getters e Setters

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

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
}