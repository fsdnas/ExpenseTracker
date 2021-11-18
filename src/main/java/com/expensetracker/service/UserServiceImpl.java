package com.expensetracker.service;

import java.util.List;

import com.expensetracker.exceptions.UserNotFoundException;
import com.expensetracker.model.User;
import com.expensetracker.repository.UserRepositoryImpl;

public class UserServiceImpl implements IUserService {
	UserRepositoryImpl userRepository = new UserRepositoryImpl();

	@Override
	public void registerUser(User user) {
		userRepository.registerUser(user);
	}

	@Override
	public void loginUser(User user) throws UserNotFoundException {
		userRepository.loginUser(user);
	}

	@Override
	public void updateUser(String email, String name) throws UserNotFoundException {
		userRepository.updateUser(email, name);
	}

	@Override
	public void deleteUserById(int id) throws UserNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User getUserById(int userId) throws UserNotFoundException {
		return userRepository.findUserById(userId);
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAllUser();
	}
	
}
