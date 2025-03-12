package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.entity.Question;

public interface IQuestionRepository extends JpaRepository<Question, Integer> {

}
