package com.md.stuendent_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.md.stuendent_management.model.Student;

public interface IStudentRepository extends JpaRepository<Student, Long> {

}
