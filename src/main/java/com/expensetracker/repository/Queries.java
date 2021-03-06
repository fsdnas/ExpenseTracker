package com.expensetracker.repository;

public class Queries {
	// Queries for user table
	public static final String REGISTERQUERY = "INSERT INTO users(name, email, password) values(?, ?, ?)";
	public static final String LOGINUSERQUERY = "SELECT * FROM users WHERE email = ? AND password = ?";
	public static final String UPDATEUSERQUERY = "UPDATE users SET name = ? WHERE email = ?";
	public static final String DELETEUSERQUERY = "DELETE FROM users where userid = ?";
	public static final String FINDUSERBYIDQUERY = "SELECT * FROM users WHERE userid=?";
	public static final String FINDALLUSERSQUERY = "SELECT * FROM users";

	// Queries for Expense table

	public static final String ADDTRANSACTIONQUERY = "INSERT INTO expense (userid, type, category, modeoftransaction, amount, date) values(?,?,?,?,?, NOW())";
	public static final String UPDATETRANSACTIONQUERY = "UPDATE expense SET category=?,amount=? WHERE transactionid = ?";
	public static final String DELETETRANSACTIONQUERY = "DELETE FROM expense WHERE transactionid = ?";
	public static final String FINDTRANSACTIONBYIDQUERY = "SELECT * FROM expense WHERE transactionid = ?";
	public static final String FINDTRANSACTIONBYDATEQUERY = "SELECT * FROM expense WHERE userid = ? AND date like ?";
	public static final String FINDTRANSACTIONBYUSERQUERY = "SELECT * FROM expense WHERE userid = ?";
	public static final String FINDALLTRANSACTIONSQUERY = "SELECT type,category,modeoftransaction,amount FROM expense";

	// -----------------------------------------------------------------------------

	// give userId two times for filtering

	public static final String CATEGORYSTATSQUERY = "select distinct category,amount,ROUND(amount/(select SUM(amount) from expense where userid = ?)*100,2) as percentage from expense where userid = ?";
	public static final String MODEOFTRANSACTIONSTATSQUERY = "select distinct modeoftransaction,amount,ROUND(amount/(select SUM(amount) from expense where userid = ?)*100,2) as percentage from expense where userid = ?";
}
