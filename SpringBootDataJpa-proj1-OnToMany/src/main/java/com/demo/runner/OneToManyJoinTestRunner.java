package com.demo.runner;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.demo.entity.Question;
import com.demo.service.IQuestionManagementService;

@Component
public class OneToManyJoinTestRunner implements CommandLineRunner {

	@Autowired
	private IQuestionManagementService service;

	@Override
	public void run(String... args) throws Exception {
		
		//create set collection object
	    Question  question1 = new Question("What is String ?","A,B,C,D");
	    
	    //set string 
	    question1.setAnswerList(Set.of("A:- String is premative data type.","B:-String is Immutable class.","C:- String is Thread safe Type.","D:- String is wrapper class."));
	    
	    String output = service.saveQuestionAndAnswer(question1);
	    
	    System.out.println(output);
	    
	}

}
