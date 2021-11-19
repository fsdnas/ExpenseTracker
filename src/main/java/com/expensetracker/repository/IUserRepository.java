package com.expensetracker.repository;

import java.util.List;

import com.expensetracker.exceptions.UserNotFoundException;
import com.expensetracker.model.User;

/**
 * 
 * @author SahabJaiswal
 *
 */
public interface IUserRepository {
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
	 * @param userId
	 * @throws UserNotFoundException
	 */
	void deleteUser(int userId) throws UserNotFoundException;

	/**
	 * 
	 * @param userId
	 * @return
	 * @throws UserNotFoundException
	 */
	User findUserById(int userId) throws UserNotFoundException;

	/**
	 * 
	 * @return
	 */
	List<User> findAllUser();

}
