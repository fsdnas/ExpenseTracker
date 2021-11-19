package com.expensetracker.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 
 * @author SnehangshuBiswas
 *
 */
public class ModelDAO {
	static Connection connection = null;

	/**
	 * 
	 * @return
	 */
	public static Connection openConnection() {
		String url = "jdbc:mysql://localhost:3306/project";
		String userName = "root";
		String password = "root";

		try {
			connection = DriverManager.getConnection(url, userName, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return connection;
	}

	public static void closeConnection() {
		try {
			if (connection != null)
				connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
