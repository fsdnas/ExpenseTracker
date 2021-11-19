package com.expensetracker.service;

import java.util.List;

import com.expensetracker.exceptions.UserNotFoundException;
import com.expensetracker.model.User;

/**
 * 
 * @author SahabJaiswal
 *
 */
public interface IUserService {
	/**
	 * 
	 * @param user
	 */
	void registerUser(User user);

	/**
	 * 
	 * @param user
	 * @throws UserNotFoundException
	 */
	void loginUser(User user) throws UserNotFoundException;

	/**
	 * 
	 * @param name
	 * @param email
	 * @throws UserNotFoundException
	 */
	void updateUser(String name, String email) throws UserNotFoundException;

	/**
	 * 
	 * @param id
	 * @throws UserNotFoundException
	 */
	void deleteUserById(int id) throws UserNotFoundException;

	/**
	 * 
	 * @param userId
	 * @return
	 * @throws UserNotFoundException
	 */
	User getUserById(int userId) throws UserNotFoundException;

	/**
	 * 
	 * @return
	 */
	List<User> getAllUsers();

}
