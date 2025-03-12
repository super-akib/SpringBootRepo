package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.entity.Student;

public interface IStudentRepositoty extends JpaRepository<Student, Integer> {

}
