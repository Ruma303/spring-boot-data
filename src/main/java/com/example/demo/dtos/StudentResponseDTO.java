package com.example.demo.dtos;

public class StudentResponseDTO {

	private String firstName;
	private String lastName;
	private String email;
	private String courseName;
	private String birthdateFormatted;
	private String statusLabel;

	public StudentResponseDTO() {}

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

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getBirthdateFormatted() {
		return birthdateFormatted;
	}

	public void setBirthdateFormatted(String birthdateFormatted) {
		this.birthdateFormatted = birthdateFormatted;
	}

	public String getStatusLabel() {
		return statusLabel;
	}

	public void setStatusLabel(String statusLabel) {
		this.statusLabel = statusLabel;
	}
}