package com.example.demo.entities;

import jakarta.persistence.*;

@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	

}
