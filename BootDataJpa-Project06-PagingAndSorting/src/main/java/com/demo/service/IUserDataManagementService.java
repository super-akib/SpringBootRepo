package com.demo.service;

import java.util.List;

import com.demo.entity.UserData;

public interface IUserDataManagementService {
	void getAllUsersData(Integer pageNumber, Integer pageSize);
	void saveListOfUserData(List<UserData> listOfUsers);
}
