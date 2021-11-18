package com.expensetracker.service;

import java.util.List;

import com.expensetracker.exceptions.UserNotFoundException;
import com.expensetracker.model.User;

public interface IUserService {
	void registerUser(User user);

	void loginUser(User user) throws UserNotFoundException;

	void updateUser(String name, String email) throws UserNotFoundException;

	void deleteUserById(int id) throws UserNotFoundException;

	User getUserById(int userId) throws UserNotFoundException;

	List<User> getAllUsers();

}
