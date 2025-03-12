package com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dto.UserDto;
import com.demo.entity.User;
import com.demo.exception.UserCredentialException;
import com.demo.repository.UserRegistrationRepository;

import jakarta.mail.MessagingException;

@Service
public class UserManagmentServiceImpl implements IUserManagementService {

	// Has-a property of user repository interface and field level injection
	@Autowired
	private UserRegistrationRepository userRepository;

	@Autowired
	private EmailService emailSender;

	// user registration
	@Override
	public String userRegistration(UserDto userDto) throws UserCredentialException {

		User savedUser = null;
		if (userDto != null) {
			// invoke validation method
			User user = validateEmailAndPassword(userDto);

			// invoke save method of repository class
			savedUser = userRepository.save(user);
			
			// check user data store or not in database
			String message = savedUser != null ? ".You're sucessfully registred in our platform" : "";
			// invoke mail transfer business method
			String sentEmailToUser = sentEmailToUser(message, user);
			// print email set or not
			System.out.println(sentEmailToUser);

			// validate and return message
			return savedUser != null ? "User sucessfull registrated" : "Registration faild";
		} else {
			throw new NullPointerException("UserDto class object must not be null");
		}
	}

	// Validate email and password
	private User validateEmailAndPassword(UserDto userDto) throws UserCredentialException {

		// validate email and password
		if (userDto.getEmailId().equals(userDto.getConfirmEmailId())
				&& userDto.getUserPassword().equals(userDto.getConfirmUserPassword())) { // Using builder insert userDto
																							// data into user entity
																							// class and return
			return User.builder().userName(userDto.getUserName()).firstName(userDto.getFirstName())
					.lastName(userDto.getLastName()).emailId(userDto.getEmailId())
					.userPassword(userDto.getUserPassword()).phoneNumber(userDto.getPhoneNumber()).build();
		} else {
			throw new UserCredentialException("Invalid Email or Password");
		}

	}

	private String sentEmailToUser(String message, User user) {
		String confirmationMessage = "";
		try {
			confirmationMessage = emailSender.sendMail(user, message);
		} catch (MessagingException e) {

			e.printStackTrace();
		}

		return confirmationMessage;
	}

}
