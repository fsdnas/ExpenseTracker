package com.expensetracker.model;

import java.time.LocalDate;

/**
 * 
 * @author SnehangshuBiswas
 * @version 1.0
 */
public class Expense {

	private User user;
	private String type;
	private String category;
	private String modeOfTransaction;
	private LocalDate date;
	private double amount;
	private int transactionId;
	private float percentage;

	public Expense() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * @param user
	 * @param type
	 * @param category
	 * @param modeOfTransaction
	 * @param amount
	 */
	public Expense(User user, String type, String category, String modeOfTransaction, double amount) {
		super();
		this.user = user;
		this.type = type;
		this.category = category;
		this.modeOfTransaction = modeOfTransaction;
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Expense [user=" + user + ", type=" + type + ", category=" + category + ", modeOfTransaction="
				+ modeOfTransaction + ", date=" + date + ", amount=" + amount + ", id=" + transactionId + "]";
	}

	/**
	 * 
	 * @return
	 */
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * 
	 * @return
	 */
	public String getType() {
		return type;
	}

	/**
	 * 
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * 
	 * @return
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * 
	 * @param category
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * 
	 * @return
	 */
	public String getModeOfTransaction() {
		return modeOfTransaction;
	}

	/**
	 * 
	 * @param modeOfTransaction
	 */
	public void setModeOfTransaction(String modeOfTransaction) {
		this.modeOfTransaction = modeOfTransaction;
	}

	/**
	 * 
	 * @return
	 */
	public LocalDate getDate() {
		return date;
	}

	/**
	 * 
	 * @param date
	 */
	public void setDate(LocalDate date) {
		this.date = date;
	}

	/**
	 * 
	 * @return
	 */
	public double getAmount() {
		return amount;
	}

	/**
	 * 
	 * @param amount
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}

	/**
	 * 
	 * @return
	 */
	public int getId() {
		return transactionId;
	}

	/**
	 * 
	 * @param id
	 */
	public void setId(int id) {
		this.transactionId = id;
	}

	/**
	 * 
	 * @param percentage
	 */
	public void setPercentage(float percentage) {
		this.percentage = percentage;

	}

	/**
	 * 
	 * @return
	 */
	public float getPercentage() {
		return percentage;
	}

}
