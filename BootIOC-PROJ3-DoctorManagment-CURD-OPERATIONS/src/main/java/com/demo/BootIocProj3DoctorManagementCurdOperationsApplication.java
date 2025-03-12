package com.demo;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.demo.model.Doctor;
import com.demo.service.DoctorService;

@SpringBootApplication
public class BootIocProj3DoctorManagementCurdOperationsApplication {

	public static void main(String[] args)
	{
		//get the IOC container
		ApplicationContext applicationContext  = SpringApplication.run(BootIocProj3DoctorManagementCurdOperationsApplication.class, args);
		
		//get Service class object reference 
		DoctorService service = applicationContext.getBean("doctorService",DoctorService.class);
		
	     //set Doctor class properties using builder
		Doctor doctor1 = Doctor.builder().doctorId(102).doctorName("Dr.mike").specialization("dentist specialist").salary(30000.0).department("Normal").build();
		
		service.addDoctor(doctor1);
      
		List<Doctor> list = service.findAll();
		
		for (Doctor doctors : list) {
			System.out.println(doctors);
		}
		
		//find doctor record based on the id
		Doctor findById = service.findById(102);
		
        System.out.println(findById);
		
		service.updateDoctor(103, 85000.0);
		
		service.deleteDoctor(101);

	   //Close IOC container
		((ConfigurableApplicationContext) applicationContext).close();
	}
	

}
