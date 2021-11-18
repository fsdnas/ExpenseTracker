package com.expensetracker.repository;

import java.util.List;

import com.expensetracker.exceptions.UserNotFoundException;
import com.expensetracker.model.Expense;
import com.expensetracker.model.User;

public interface IUserRepository {

	
	void registerUser(User user);
	void loginUser(User user) throws UserNotFoundException;
	void updateUser(String name, String email)throws UserNotFoundException;
	User findUserById(int userId)throws UserNotFoundException;
	
	
	List<User> findAllUser();
	
}
