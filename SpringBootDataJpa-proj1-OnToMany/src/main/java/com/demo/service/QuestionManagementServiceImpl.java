package com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entity.Question;
import com.demo.repository.IQuestionRepository;
@Service
public class QuestionManagementServiceImpl implements IQuestionManagementService {
    
	@Autowired
	private IQuestionRepository   questionRepository;
	@Override
	public String saveQuestionAndAnswer(Question question) 
	{
		Question save = questionRepository.save(question);
		return save.getId()+" Question saved successfully in data base.";
	}
	
	

}
