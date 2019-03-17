package com.example.jpa.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Laptop {
	public Laptop() {
		// TODO Auto-generated constructor stub
	}

	@Id
	private Integer id;
	private String brand;
	@OneToOne(mappedBy = "laptop")
	private Student student;

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Laptop(Integer id, String brand) {
		super();
		this.id = id;
		this.brand = brand;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	@Override
	public String toString() {
		return "Laptop [id=" + id + ", brand=" + brand + "]";
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

}
