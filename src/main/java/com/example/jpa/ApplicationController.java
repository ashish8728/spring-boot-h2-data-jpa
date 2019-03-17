package com.example.jpa;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jpa.entity.Laptop;
import com.example.jpa.entity.SoftwareEngineer;
import com.example.jpa.entity.Student;
import com.example.jpa.entity.TechCompany;
import com.example.jpa.repository.StudentRepository;
import com.example.jpa.repository.TechCompanyRepository;

@RestController
public class ApplicationController {

	private TechCompanyRepository techCompanyRepository;
	private StudentRepository studentRepository;

	public ApplicationController(TechCompanyRepository TechCompanyRepository, StudentRepository studentRepository) {
		super();
		this.techCompanyRepository = TechCompanyRepository;
		this.studentRepository = studentRepository;
	}

	@RequestMapping("/welcome")
	public String welcome() {
		return "Wecome to Spring JPA Data Application: " + new Date();
	}

	@RequestMapping("/findAllTechCompany")
	public List<TechCompany> findAllTechCompany() {
		return techCompanyRepository.findAll();
	}

	@RequestMapping("/findFirstTechCompany")
	public TechCompany findFirstTechCompany() {
		return techCompanyRepository.findAll().stream().findFirst().get();
	}
	
	@RequestMapping("/findAllCompany")
	public List<TechCompany> findAllCompany() {
		return techCompanyRepository.findAll();
	}

	@RequestMapping("/findByCompanyId/{id}")
	public TechCompany findByCompanyId(@PathVariable String id) {
		return techCompanyRepository.findById(id).get();
	}

	@RequestMapping("/findByCompanyName/{name}")
	public TechCompany findByCompanyName(@PathVariable String name) {
		return techCompanyRepository.findByName(name).stream().findFirst().get();
	}
	
	@RequestMapping("/findByCompanyNameQuery/{name}")
	public TechCompany findByCompanyNameQuery(@PathVariable String name) {
		return techCompanyRepository.findByQuery(name).stream().findFirst().get();
	}

	@RequestMapping("/findBySkill/{skill}")
	public TechCompany findBySkill(@PathVariable String skill) {
		return techCompanyRepository.findByEngineersSkill(skill).stream().findFirst().get();
	}

	@RequestMapping("/findBySkillAndName/{skill}/{name}")
	public TechCompany findBySkillAndName(@PathVariable String skill, @PathVariable String name) {
		return techCompanyRepository.findByEngineersSkillAndEngineersName(skill, name).stream().findFirst().get();
	}

	@RequestMapping("/findByNameSkillAndeName/{name}/{skill}")
	public TechCompany findByNameSkillAndeName(@PathVariable String skill, @PathVariable String name) {
		return techCompanyRepository.findByNameAndEngineersSkill(name, skill).stream().findFirst().get();
	}

	@RequestMapping("/createTechCompany")
	public String createTechCompany() {
		SoftwareEngineer javaEngineer = new SoftwareEngineer("Jon R", "Java");
		SoftwareEngineer scalaEngineer = new SoftwareEngineer("Megan F", "Scala");
		SoftwareEngineer pythonEngineer = new SoftwareEngineer("Tommy N", "Python");
		List<SoftwareEngineer> engineers = Arrays.asList(javaEngineer, scalaEngineer, pythonEngineer);
		TechCompany company = new TechCompany("TCS", "Tata Consultancy", engineers);
		TechCompany company2 = new TechCompany("Nag", "Naggaro", engineers);
		techCompanyRepository.save(company);
		techCompanyRepository.save(company2);
		return "New TechCompany has been Created Successfully.";
	}

	@RequestMapping("/createStudent")
	public String createStudent() {
		Laptop laptop = new Laptop(101, "Dell");
		Student student = new Student("Jon", laptop);
		studentRepository.save(student);
		return "New Student Created;";
	}

	@RequestMapping("/findStudent")
	public Student findStudent() {
		return studentRepository.findAll().stream().findFirst().get();
	}

	@RequestMapping("/findCount")
	public Integer findCount() {
		return studentRepository.findAll().size();
	}
}
