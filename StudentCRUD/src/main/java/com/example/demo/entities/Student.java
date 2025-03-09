package com.example.demo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "student")
public class Student {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	int id;
	
	@Column
	String name;
	
	@Column
	String email;
	
	@Column
	String dept;
	
	@Column
	double cgpa;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(int id, String name, String email, String dept, double cgpa) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.dept = dept;
		this.cgpa = cgpa;
	}

	public Student(String name, String email, String dept, double cgpa) {
		super();
		this.name = name;
		this.email = email;
		this.dept = dept;
		this.cgpa = cgpa;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public double getCgpa() {
		return cgpa;
	}

	public void setCgpa(double cgpa) {
		this.cgpa = cgpa;
	}
	
	
}
