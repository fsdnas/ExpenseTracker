package com.expensetracker.repository;

public class Queries {
	//Queries for user table
	public static final String REGISTERQUERY = "INSERT INTO users(name, email, password) values(?, ?, ?)";
	public static final String LOGINUSERQUERY = "SELECT * FROM users WHERE email = ? AND password = ?";
	public static final String UPDATEUSERQUERY = "UPDATE users SET name = ?, email = ? WHERE userid = ?";
	public static final String FINDUSERBYIDQUERY = "SELECT * FROM users WHERE userid=?";
	public static final String FINDALLUSERSQUERY = "SELECT * FROM users";
	
	//Queries for Expense table
	
	public static final String ADDTRANSACTIONQUERY = "INSERT INTO expense (userid, type, category, modeoftransaction, amount) values(?,?,?,?,?)";	
	public static final String UPDATETRANSACTIONQUERY = "UPDATE expense SET ?=?,?=? WHERE transactionid = ?";
	public static final String FINDTRANSACTIONBYIDQUERY = "SELECT * FROM expense WHERE transactionid = ?";
	public static final String FINDTRANSACTIONBYDATEQUERY = "SELECT * FROM expense WHERE date = ?";
	public static final String FINDTRANSACTIONBYUSERQUERY = "SELECT * FROM expense WHERE userid = ?";
	public static final String FINDALLTRANSACTIONSQUERY = "SELECT * FROM expense";
	
	
}
