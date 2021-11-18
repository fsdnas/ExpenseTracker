package com.expensetracker.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.expensetracker.exceptions.UserNotFoundException;
import com.expensetracker.model.Expense;
import com.expensetracker.model.User;

public class UserRepositoryImpl implements IUserRepository {
	static Connection connection;

	@Override
	public void registerUser(User user) {
		connection = ModelDAO.openConnection();
		PreparedStatement statement = null;

		try {
			statement = connection.prepareStatement(Queries.REGISTERQUERY);
			statement.setString(1, user.getName());
			statement.setString(2, user.getEmail());

			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				ModelDAO.closeConnection();
			}
		}
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
