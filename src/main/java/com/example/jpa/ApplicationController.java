package com.example.jpa;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jpa.entity.Demo;
import com.example.jpa.repository.DemoRepository;

@RestController
public class ApplicationController {

	private DemoRepository demoRepository;

	public ApplicationController(DemoRepository demoRepository) {
		super();
		this.demoRepository = demoRepository;
	}

	@RequestMapping("/welcome")
	public String welcome() {
		return "Wecome to Spring JPA Data Application Demo: " + new Date();
	}

	@RequestMapping("/findAllDemo")
	public List<Demo> findAllDemo() {
		return demoRepository.findAll();
	}

	@RequestMapping("/createDemo")
	public String createDemo() {
		Optional<Demo> demo = demoRepository.findAll().stream().findFirst();
		if (demo.isPresent()) {
			Integer id = demo.get().getId() + 1;
			demoRepository.save(new Demo(id, "Demo " + id));
		} else {
			demoRepository.save(new Demo(101, "Demo 1"));
		}
		return "New demo has been Created Successfully.";
	}

	@RequestMapping("/delete/{id}")
	public String deleteDemo(@PathVariable Integer id) {
		demoRepository.deleteById(id);
		return "Demo Deleted Successfully " + id;
	}
}
