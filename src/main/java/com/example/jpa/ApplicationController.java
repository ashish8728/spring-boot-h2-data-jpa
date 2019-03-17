package com.example.jpa;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jpa.entity.SoftwareEngineer;
import com.example.jpa.entity.TechCompany;
import com.example.jpa.repository.TechCompanyRepository;

@RestController
public class ApplicationController {

	private TechCompanyRepository TechCompanyRepository;

	public ApplicationController(TechCompanyRepository TechCompanyRepository) {
		super();
		this.TechCompanyRepository = TechCompanyRepository;
	}

	@RequestMapping("/welcome")
	public String welcome() {
		return "Wecome to Spring JPA Data Application: " + new Date();
	}

	@RequestMapping("/findAllTechCompany")
	public List<TechCompany> findAllTechCompany() {
		return TechCompanyRepository.findAll();
	}

	@RequestMapping("/createTechCompany")
	public String createTechCompany() {
		SoftwareEngineer javaEngineer = new SoftwareEngineer("Jon R", "Java");
		SoftwareEngineer scalaEngineer = new SoftwareEngineer("Megan F", "Scala");
		SoftwareEngineer pythonEngineer = new SoftwareEngineer("Tommy N", "Python");
		List<SoftwareEngineer> engineers = Arrays.asList(javaEngineer, scalaEngineer, pythonEngineer);
		TechCompany company = new TechCompany("TCS", "Tata Consultancy", engineers);
		TechCompanyRepository.save(company);
		return "New TechCompany has been Created Successfully.";
	}
}
