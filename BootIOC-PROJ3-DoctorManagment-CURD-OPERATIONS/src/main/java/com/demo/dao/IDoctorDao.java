package com.demo.dao;

import java.util.List;

import com.demo.model.Doctor;

public interface IDoctorDao 
{
    
	//Abstract method for CURD -operations
    
	//save data in database 
    public void saveDoctorData(Doctor doctor)throws Exception;
    //retrieve all data from database
    public List<Doctor> retrieveAllDoctorsData()throws Exception;
    //retrieve particular record based on id
    public Doctor findDoctorDataById(Integer doctorId)throws Exception;
    //update record based on id
    public void updateDoctorData(Integer doctorId , Double updateSalary)throws Exception;
    //delete record from database based on the id
    public void deleteDoctorDataById(Integer doctorId) throws Exception;
}
