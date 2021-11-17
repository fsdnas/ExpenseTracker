package com.expensetracker.repository;

import java.util.List;

import com.expensetracker.exceptions.UserNotFoundException;
import com.expensetracker.model.Expense;
import com.expensetracker.model.User;

public class UserRepositoryImpl implements IUserRepository {

	@Override
	public void registerUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void loginUser(User user) throws UserNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateUser(String name, String email) throws UserNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void findUserById(int userId) throws UserNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Expense> findAllUser() {
		// TODO Auto-generated method stub
		return null;
	}

}
