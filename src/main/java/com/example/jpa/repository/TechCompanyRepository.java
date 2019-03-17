package com.example.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.jpa.entity.TechCompany;

public interface TechCompanyRepository extends JpaRepository<TechCompany, String> {
	public List<TechCompany> findByName(String name);
	
	@Query("from TechCompany where name = ?1")
	public List<TechCompany> findByQuery(String name);

	public List<TechCompany> findByEngineersSkill(String skill);

	public List<TechCompany> findByEngineersSkillAndEngineersName(String skill, String name);

	public List<TechCompany> findByNameAndEngineersSkill(String name, String skill);
}
