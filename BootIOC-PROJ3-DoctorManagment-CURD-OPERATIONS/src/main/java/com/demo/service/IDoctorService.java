package com.demo.service;

import java.util.List;

import com.demo.model.Doctor;

public interface IDoctorService {
	

	    void addDoctor(Doctor doctor);
	    List<Doctor> findAll();
	    Doctor findById(int id);
	    void updateDoctor(Integer doctorId, Double updateSalary);
	    void deleteDoctor(int id);
		

}
