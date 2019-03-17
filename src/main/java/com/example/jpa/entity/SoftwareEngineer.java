package com.example.jpa.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class SoftwareEngineer {
	@Id
	@GeneratedValue
	private Integer engineerId;

	private String name;

	private String skill;

	public SoftwareEngineer() {

	}

	public SoftwareEngineer(String name, String skill) {
		super();
		this.name = name;
		this.skill = skill;
	}

	public Integer getEngineerId() {
		return engineerId;
	}

	public void setEngineerId(Integer engineerId) {
		this.engineerId = engineerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((engineerId == null) ? 0 : engineerId.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((skill == null) ? 0 : skill.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SoftwareEngineer other = (SoftwareEngineer) obj;
		if (engineerId == null) {
			if (other.engineerId != null)
				return false;
		} else if (!engineerId.equals(other.engineerId))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (skill == null) {
			if (other.skill != null)
				return false;
		} else if (!skill.equals(other.skill))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SoftwareEngineer [engineerId=" + engineerId + ", name=" + name + ", skill=" + skill + "]";
	}

}
