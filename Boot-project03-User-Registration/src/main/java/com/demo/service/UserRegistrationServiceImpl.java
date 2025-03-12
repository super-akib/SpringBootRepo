package com.demo.service;

import org.springframework.stereotype.Service;

import com.demo.entity.UserRegistration;
import com.demo.repository.IUserRegistrationRepository;

@Service
public class UserRegistrationServiceImpl implements IUserRegistrationService {

	private IUserRegistrationRepository userRegistrationRepository;

	public UserRegistrationServiceImpl(IUserRegistrationRepository userRegistrationRepository)
	{
		this.userRegistrationRepository = userRegistrationRepository;
	}
	
	// user registration business method
	@Override
	public String userRegistration(UserRegistration user) {

		String resultMessage = "";
		if (user == null) {
			throw new NullPointerException("User object can not be null.");
		} else {
			// check user already registered or not
			String existingUserName = userRegistrationRepository.findByUserName(user.getUserName());
			//if user not registered then save new user data
			if (existingUserName == null) {
				UserRegistration registeredUser = userRegistrationRepository.save(user);
				resultMessage += registeredUser.getUserName() + " your successfully registered.";
			} else {
				resultMessage += existingUserName + " all ready registered.";
			}
		}
		return resultMessage;
	}

}
