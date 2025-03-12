package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entity.User;
import com.demo.repository.IUserRepository;

@Service
public class UserManagmentServiceImpl implements IUserManagementService {
	@Autowired
	private IUserRepository userRepository;

	@Override
	public String saveUserData(User user) {
		if (user == null) {
			throw new NullPointerException("In this case we can not pass null object");
		} else {
			return userRepository.save(user).getUserId() + " User data store sucessfully.";
		}
	}

	@Override
	public User getUserById(Integer userId) {

		return userRepository.findById(userId)
				.orElseThrow(() -> new IllegalArgumentException("Could not find the user of this id:" + userId));
	}

	
	@Override
	public List<User> getAllUserData() {

		return userRepository.findAll();
	}

	@Override
	public String deleteUserDataById(Integer userId) {
		
		userRepository.deleteById(userId);
		
		return "User deleted";
	}

}
