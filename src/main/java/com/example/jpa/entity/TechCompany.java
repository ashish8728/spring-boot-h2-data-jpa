package com.example.jpa.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class TechCompany {
	@Id
	private String id;

	private String name;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<SoftwareEngineer> engineers;

	public TechCompany() {

	}

	public TechCompany(String id, String name, List<SoftwareEngineer> engineers) {
		super();
		this.id = id;
		this.name = name;
		this.engineers = engineers;
	}

	public List<SoftwareEngineer> getEngineers() {
		return engineers;
	}

	public void setEngineers(List<SoftwareEngineer> engineers) {
		this.engineers = engineers;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "TechCompany [id=" + id + ", name=" + name + ", engineers=" + engineers + "]";
	}

}
