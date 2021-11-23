/**
 * 
 * @author SnehangshuBiswas
 * @version 1.0
 */

package com.expensetracker.service;

import java.util.List;

import com.expensetracker.exceptions.UserNotFoundException;
import com.expensetracker.model.User;
import com.expensetracker.repository.UserRepositoryImpl;

public class UserServiceImpl implements IUserService {
	UserRepositoryImpl userRepository = new UserRepositoryImpl();

	/**
	 * @param user
	 */
	@Override
	public void registerUser(User user) {
		userRepository.registerUser(user);
	}

	/**
	 * @param user
	 */
	@Override
	public User loginUser(User user) throws UserNotFoundException {
		return userRepository.loginUser(user);
	}

	/**
	 * @param email
	 * @param name
	 */
	@Override
	public void updateUser(String email, String name) throws UserNotFoundException {
		userRepository.updateUser(email, name);
	}

	/**
	 * @param userid
	 */
	@Override
	public void deleteUserById(int userId) throws UserNotFoundException {
		// TODO Auto-generated method stub
		userRepository.deleteUser(userId);
	}

	/**
	 * @param userId
	 * @return
	 */
	@Override
	public User getUserById(int userId) throws UserNotFoundException {
		return userRepository.findUserById(userId);
	}

	/**
	 * @return
	 */
	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAllUser();
	}

}
