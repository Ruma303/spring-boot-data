package com.example.demo.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "student_details")
public class StudentDetail {

	@Id
	@Column(name = "id_student", nullable = false)
	private Integer idStudent;

	@OneToOne
	@MapsId
	@JoinColumn(name = "id_student")
	private Student student;

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Column(name = "address", nullable = false, length = 200)
	private String address;

	@Column(name = "phone", nullable = true, length = 20)
	private String phone;

	// Getters e Setters

	public Integer getIdStudent() {
		return idStudent;
	}

	public void setIdStudent(Integer idStudent) {
		this.idStudent = idStudent;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}