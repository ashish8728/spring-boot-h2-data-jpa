package com.example.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jpa.entity.Demo;

public interface DemoRepository extends JpaRepository<Demo, Integer> {

}
