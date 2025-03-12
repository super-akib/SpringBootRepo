package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.entity.Course;

public interface ICourseRepositoty extends JpaRepository<Course, Integer> {

}
