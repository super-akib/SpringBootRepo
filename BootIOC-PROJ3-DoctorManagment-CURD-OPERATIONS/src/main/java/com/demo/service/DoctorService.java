package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.IDoctorDao;
import com.demo.model.Doctor;
@Service("doctorService")
public class DoctorService  implements IDoctorService{
     
	@Autowired
	//HAS-A property of doctorDao 
	private IDoctorDao   doctorDao;
	
	//Business method for check data save or not in database
	@Override
	public void addDoctor(Doctor doctor)
	{
	     if(doctor != null)
	     {
	    	 try {
				
	    		 doctorDao.saveDoctorData(doctor);
			
	    	 } catch (Exception e) {
				
				e.printStackTrace();
			}
	     }
	     else
	     {
	    	 throw new NullPointerException("Yor doctor class object is null. please create the object");
	     }
		
	}

	@Override
	public List<Doctor> findAll()
	{
		List<Doctor> list = null;
		try {
			list =doctorDao.retrieveAllDoctorsData();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
		return list;
	}

	@Override
	public Doctor findById(int id) 
	{
		Doctor doctor=null;
		try {
		      doctor =doctorDao.findDoctorDataById(id);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return doctor;
	}

	@Override
	public void updateDoctor(Integer doctorId, Double updateSalary) 
	{
		 try {
			doctorDao.updateDoctorData(doctorId,updateSalary);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	@Override
	public void deleteDoctor(int id) 
	{
		 try {
			doctorDao.deleteDoctorDataById(id);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}

	
}
