/**
 * 
 * @author Nayeem & SahabJaiswal
 *
 */

package com.expensetracker.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.expensetracker.exceptions.ExpenseRecordNotFoundException;
import com.expensetracker.exceptions.UserNotFoundException;
import com.expensetracker.model.Expense;
import com.expensetracker.model.User;

public class ExpenseRepositoryImpl implements IExpenseRepository {
	static Connection connection;

	/**
	 * @param expense
	 */
	@Override
	public void addTransaction(Expense expense) {
		connection = ModelDAO.openConnection();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(Queries.ADDTRANSACTIONQUERY);
			statement.setInt(1, expense.getUser().getUserid());
			statement.setString(2, expense.getType());
			statement.setString(3, expense.getCategory());
			statement.setString(4, expense.getModeOfTransaction());
			statement.setDouble(5, expense.getAmount());
			statement.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (statement != null) {

				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
			ModelDAO.closeConnection();
		}

	}

	/**
	 * @param transactionId
	 */
	@Override
	public void updateTransaction(Expense expense) throws ExpenseRecordNotFoundException {
		connection = ModelDAO.openConnection();
		PreparedStatement statement = null;

		try {
			statement = connection.prepareStatement(Queries.UPDATETRANSACTIONQUERY);
			statement.setString(1, expense.getCategory());
			statement.setDouble(2, expense.getAmount());
			statement.setInt(3, expense.getId());

			int count = statement.executeUpdate();
			
			if (count == 0) {
				throw new ExpenseRecordNotFoundException("TransactionId not found, Please check the id and try again");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
			ModelDAO.closeConnection();

		}
	}

	/**
	 * @param transactionId
	 */
	@Override
	public void deleteTransaction(int transactionId) throws ExpenseRecordNotFoundException {
		connection = ModelDAO.openConnection();
		PreparedStatement statement = null;

		try {
			statement = connection.prepareStatement(Queries.DELETETRANSACTIONQUERY);
			statement.setInt(1, transactionId);
			int count = statement.executeUpdate();

			if (count == 0) {
				throw new ExpenseRecordNotFoundException("Transaction Id  not found, Please check the id and try");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
			ModelDAO.closeConnection();

		}

	}

	/**
	 * @param transactionId
	 * @return
	 */
	@Override
	public List<Expense> findTransactionById(int transactionId) throws ExpenseRecordNotFoundException {
		PreparedStatement statement = null;
		Expense expense = null;
		Connection connection = ModelDAO.openConnection();
		List<Expense> expenseList = new ArrayList<>();
		try {
			statement = connection.prepareStatement(Queries.FINDTRANSACTIONBYIDQUERY);
			statement.setInt(1, transactionId);
			ResultSet resultSet = null;
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				expense = new Expense();
				expense.setAmount(resultSet.getDouble("amount"));
				expense.setCategory(resultSet.getString("category"));
				expense.setModeOfTransaction(resultSet.getString("ModeOfTransaction"));
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-mm-dd");
				LocalDate foundDate = LocalDate.parse(resultSet.getString("date").split("\\s")[0], formatter);
				expense.setDate(foundDate);
				expenseList.add(expense);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			ModelDAO.closeConnection();
		}

		if (expenseList.isEmpty()) {
			throw new ExpenseRecordNotFoundException("please Enter valid transaction Id:");
		}
		return expenseList;
	}

	/**
	 * @param date
	 * @param userId
	 * @return
	 */
	@Override
	public List<Expense> findTransactionByDate(LocalDate date, int userId) throws ExpenseRecordNotFoundException {
		PreparedStatement statement = null;
		Connection connection = ModelDAO.openConnection();
		ResultSet resultSet = null;
		List<Expense> expenseList = new ArrayList<>();

		try {
			statement = connection.prepareStatement(Queries.FINDTRANSACTIONBYDATEQUERY);
			statement.setInt(1, userId);
			statement.setString(2, date.toString() + "%");
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
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
			if (expenseList.isEmpty()) {
				throw new ExpenseRecordNotFoundException("Transaction not found");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
			ModelDAO.closeConnection();

		}

		return expenseList;
	}

	/**
	 * @param userId
	 * @return
	 */
	@Override
	public List<Expense> findTransactionByUser(int userId) throws UserNotFoundException {
		PreparedStatement statement = null;
		Connection connection = ModelDAO.openConnection();
		ResultSet resultSet = null;
		List<Expense> expenseList = new ArrayList<>();

		try {
			statement = connection.prepareStatement(Queries.FINDTRANSACTIONBYUSERQUERY);
			statement.setInt(1, userId);

			resultSet = statement.executeQuery();
			Expense findTransaction = null;
			while (resultSet.next()) {
				findTransaction = new Expense();
				findTransaction.setId(resultSet.getInt("userid"));
				findTransaction.setType(resultSet.getString("type"));
				findTransaction.setCategory(resultSet.getString("category"));
				findTransaction.setModeOfTransaction(resultSet.getString("modeoftransaction"));
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				LocalDate foundDate = LocalDate.parse(resultSet.getString("date").split("\\s")[0], formatter);
				findTransaction.setDate(foundDate);
				expenseList.add(findTransaction);
			}

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

			}
			ModelDAO.closeConnection();

		}

		if (expenseList.isEmpty()) {
			throw new UserNotFoundException("User not found, Please check user id ");
		}

		return expenseList;
	}

	/**
	 * @return
	 */
	@Override
	public List<Expense> findAllTransaction() {

		PreparedStatement statement = null;
		Connection connection = ModelDAO.openConnection();
		ResultSet resultset = null;
		List<Expense> expenseList = new ArrayList<>();
		try {
			statement = connection.prepareStatement(Queries.FINDALLTRANSACTIONSQUERY);
			resultset = statement.executeQuery();
			while (resultset.next()) {
				String type = resultset.getString("type");
				String category = resultset.getString("category");
				String modeOfTransaction = resultset.getString("modeOfTransaction");
				double amount = resultset.getDouble("amount");
				User user = new User();

				Expense expense = new Expense(user, type, category, modeOfTransaction, amount);
				expenseList.add(expense);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			ModelDAO.closeConnection();
		}
		return expenseList;
	}

	/**
	 * @param userId
	 * @return
	 */
	@Override
	public List<Expense> getStatsByCategory(int userId) throws UserNotFoundException {
		PreparedStatement statement = null;
		Connection connection = ModelDAO.openConnection();
		ResultSet resultSet = null;
		List<Expense> expenseList = new ArrayList<>();

		try {
			statement = connection.prepareStatement(Queries.CATEGORYSTATSQUERY);
			statement.setInt(1, userId);
			statement.setInt(2, userId);
			resultSet = statement.executeQuery();
			Expense categoryStats = null;
			while (resultSet.next()) {
				categoryStats = new Expense();
				categoryStats.setCategory(resultSet.getString("category"));
				categoryStats.setAmount(resultSet.getDouble("amount"));
				categoryStats.setPercentage(resultSet.getFloat("percentage"));
				expenseList.add(categoryStats);
			}

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

			}
			ModelDAO.closeConnection();

		}
		if (expenseList.isEmpty()) {
			throw new UserNotFoundException("User not found, Please check user id ");
		}

		return expenseList;
	}

	/**
	 * @param userId
	 * @return
	 */
	@Override
	public List<Expense> getStatsByModeOfTransaction(int userId) throws UserNotFoundException {
		PreparedStatement statement = null;
		Connection connection = ModelDAO.openConnection();
		ResultSet resultSet = null;
		List<Expense> expenseList = new ArrayList<>();
		try {
			statement = connection.prepareStatement(Queries.MODEOFTRANSACTIONSTATSQUERY);
			statement.setInt(1, userId);
			statement.setInt(2, userId);
			resultSet = statement.executeQuery();
			Expense ModeOfTransactionStats = null;
			while (resultSet.next()) {
				ModeOfTransactionStats = new Expense();
				ModeOfTransactionStats.setModeOfTransaction(resultSet.getString("ModeOfTransaction"));
				ModeOfTransactionStats.setAmount(resultSet.getDouble("amount"));
				ModeOfTransactionStats.setPercentage(resultSet.getFloat("percentage"));
				expenseList.add(ModeOfTransactionStats);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			ModelDAO.closeConnection();
		}
		if (expenseList.isEmpty()) {
			throw new UserNotFoundException("User not found, Please check user id ");
		}

		return expenseList;

	}

}
