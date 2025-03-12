package com.demo.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.demo.entity.User;
import com.demo.repository.UserRepository;

@Service
public class UserManagementServiceImpl implements IUserManagementService {

	private UserRepository userRepository;

	public UserManagementServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	//business method for add new user
	@Override
	public String registerUser(User user) {
		return userRepository.save(user).getUserName() + " you're register successfully.";
	}

//business method for pagination logic 
	@Override
	public Page<User> paginationOfUser(Pageable pageable)
	{
		return userRepository.findAll(pageable);
	}

	@Override
	public User findUserById(Integer id) {
		return userRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Invalid user id"));
	}

	@Override
	public String updateUserData(User user) {
		
		return "User "+userRepository.save(user).getId()+" are successfully updated.";
	}

	@Override
	public String deleteUserById(Integer id)
	{   
		userRepository.deleteById(id);
	  return "Id:"+id+" user are deleted from record.";
	}

}
