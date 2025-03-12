package com.md.stuendent_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.md.stuendent_management.model.Course;

public interface ICourseRepositoty extends JpaRepository<Course, Long> {

}
