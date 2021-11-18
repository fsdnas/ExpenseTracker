package com.expensetracker.model;

import java.time.LocalDate;

public class Expense {

	private User user;
	private String type;
	private String category;
	private String modeOfTransaction;
	private LocalDate date;
	private double amount;
	private int transactionId;
	
	
	public Expense() {
		// TODO Auto-generated constructor stub
	}

	public Expense(User user, String type, String category, String modeOfTransaction, LocalDate date, double amount,
			int transactionId) {
		super();
		this.user = user;
		this.type = type;
		this.category = category;
		this.modeOfTransaction = modeOfTransaction;
		this.date = date;
		this.amount = amount;
		this.transactionId = transactionId;
	}

	@Override
	public String toString() {
		return "Expense [user=" + user + ", type=" + type + ", category=" + category + ", modeOfTransaction="
				+ modeOfTransaction + ", date=" + date + ", amount=" + amount + ", id=" + transactionId + "]";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getModeOfTransaction() {
		return modeOfTransaction;
	}

	public void setModeOfTransaction(String modeOfTransaction) {
		this.modeOfTransaction = modeOfTransaction;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getId() {
		return transactionId;
	}

	public void setId(int id) {
		this.transactionId = id;
	}

}
