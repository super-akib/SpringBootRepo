package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.demo.entity.UserData;
import com.demo.repository.IUserManagementRepository;

@Service
public class UserDataManagementServiceImpl implements IUserDataManagementService 
{
	//Repository object reference by field level injection
	@Autowired
	private IUserManagementRepository  userDataRepository;

	@Override
	public void getAllUsersData(Integer pageNumber, Integer pageSize)
  	{
		 PageRequest  pageable = PageRequest.of(pageNumber,pageSize);
		
		//  getting all users data from database
		Page<UserData> page = userDataRepository.findAll(pageable);
		
		//count how many records present in database
		long  totalPages =  userDataRepository.count()/pageSize;
		
		//print record based on page no.
		System.out.println("\n\nPage No."+page.getNumber()+" |   List of Record:"+page.getSize()
		+"\n------------------------------------------------------------");
		page.getContent().forEach(System.out::println);
		System.out.println("--------------------------------------------------");
		System.out.println("Total Pages:"+totalPages);
       
		 
	}

	@Override
	public void saveListOfUserData(List<UserData> listOfUsers) 
	{
		if(listOfUsers.isEmpty())
		{
			throw new IllegalArgumentException("In this case list collection connot be null.");
		}
		else
		{
			List<UserData> saveAll =(List<UserData>)userDataRepository.saveAll(listOfUsers);
			
			if(saveAll.isEmpty())
			{
				throw new IllegalArgumentException("List of user data can not be Stored in database.");
			}
			else
			{
				System.out.println(saveAll.size()+" user data is sucessfully stored.");
			}
			
		}
		
	}

}
