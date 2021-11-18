package com.expensetracker.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import com.expensetracker.exceptions.ExpenseRecordNotFoundException;
import com.expensetracker.exceptions.UserNotFoundException;
import com.expensetracker.model.Expense;
import com.expensetracker.model.User;


public class ExpenseRepositoryImpl implements IExpenseRepository {
	static Connection connection;

	@Override
	public void addTransaction(Expense expense) {
		connection = ModelDAO.openConnection();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(Queries.ADDTRANSACTIONQUERY);
			statement.setInt(1, expense.getId());
			statement.setString(2, expense.getType());
			statement.setString(3, expense.getCategory());
			statement.setString(4, expense.getModeOfTransaction());
			statement.setDouble(5, expense.getAmount());
			statement.execute();

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
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
	public void updateTransaction(int transactionId) throws ExpenseRecordNotFoundException {
		connection = ModelDAO.openConnection();
		PreparedStatement statement = null;
		
		try {
			statement = connection.prepareStatement(Queries.UPDATETRANSACTIONQUERY);
			statement.setInt(1, transactionId);
			int count = statement.executeUpdate();
			if(count == 0) {
				throw new ExpenseRecordNotFoundException("TransactionId not found, Please check the id and try");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
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
	public void deleteTransaction(int transactionId) throws ExpenseRecordNotFoundException {
		connection = ModelDAO.openConnection();
		PreparedStatement statement = null;
		
		try {
			statement = connection.prepareStatement(Queries.DELETETRANSACTIONQUERY);
			statement.setInt(1, transactionId);
			int count = statement.executeUpdate();
			if(count == 0) {
				throw new ExpenseRecordNotFoundException("Transaction Id  not found, Please check the id and try");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
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
	public List<Expense> findTransactionById(int transactionId) throws ExpenseRecordNotFoundException {
		
		return null;
	}

	@Override
	public List<Expense> findTrnasactionByDate(LocalDate date) throws ExpenseRecordNotFoundException {
		PreparedStatement statement = null;
		Connection connection = ModelDAO.openConnection();
		ResultSet resultSet = null;
		List<Expense> expenseList = new ArrayList<>();
		
		try {
			statement = connection.prepareStatement(Queries.FINDTRANSACTIONBYDATEQUERY);
			statement.setString(1, date.toString() + "%");
			
			resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				Expense expense = new Expense();
				expense.setId(resultSet.getInt("transactionid"));
				expense.setAmount(resultSet.getDouble("amount"));
				expense.setCategory(resultSet.getString("category"));
				expense.setType(resultSet.getString("type"));
				expense.setModeOfTransaction(resultSet.getString("modeoftransaction"));
				
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				LocalDate foundDate = LocalDate.parse(resultSet.getString("date").split("\\s")[0], formatter);
				expense.setDate(foundDate);
				expenseList.add(expense);
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return expenseList;
	}

	@Override
	public List<Expense> findTransactionByUser(User user) throws UserNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Expense> findAllTransaction() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
