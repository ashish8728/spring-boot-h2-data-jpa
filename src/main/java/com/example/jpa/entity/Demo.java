package com.example.jpa.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Demo {
	@Id
	@GeneratedValue
	private Integer id;
	private String name;

	public Demo(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Demo() {
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
