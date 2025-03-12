package com.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.IStudentDao;
import com.demo.dao.StudentDaoImp;
import com.demo.model.Student;
@Service("studentService")
public class StudentServiceImpl implements IStudentDao {
  
 @Autowired	
 private StudentDaoImp studentDao;	
	
    @Override
	public String saveData(Student student) {
		
		String result ="";
		
		if(student.getStudentMarks() >= 80 && student.getStudentMarks()<=100)
		{
              student.setStudentGrad("A");
		}
		else if(student.getStudentMarks()<=79 && student.getStudentMarks()>=60)
		{
			student.setStudentGrad("B");			
		}
		else if(student.getStudentMarks()<=59 && student.getStudentMarks()>= 50)
		{
			student.setStudentGrad("C");			
		}
		else if(student.getStudentMarks()<=49 && student.getStudentMarks()>=40)
		{
			student.setStudentGrad("D");			
		}
		else if(student.getStudentMarks()<40 && student.getStudentMarks()>=0)
		{
			student.setStudentGrad("F");			
		}
		else 
		{
			throw new IllegalArgumentException("! Hoo ho rong input . note sutdent marks 0 to 100 only .");
		}
		
		   result = studentDao.saveData(student);
		
		 return result;
	}

	@Override
	public List<Student> getAll()
	{   
		List<Student> newList = new ArrayList<Student>();
	    
		//Fetch the all  student object one by one
		for( Student student :studentDao.getAll())
	    {
	    	//Assign those student there grade is A 
			if(student.getStudentGrad().equals("A"))
			{
			    newList.add(student);	
			}
	    }
		return newList;
	}

	@Override
	public Student FindByid(int id) {
	  //returning student object based on the condition	
	  return studentDao.FindByid(id);
	}

}
