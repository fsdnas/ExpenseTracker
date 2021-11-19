/**
 * 
 * @author SnehangshuBiswas
 * @version 1.0
 */

package com.expensetracker.model;

public class User {
	private int userid;
	private String name;
	private String email;
	private String password;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * @param name
	 * @param email
	 * @param password
	 */
	public User(String name, String email, String password) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;

	}

	public User(String email, String password) {
		super();
		this.email = email;
		this.password = password;

	}
	public User(int userId) {
		super();
		this.userid = userId;

	}

	public User(int userId, String name, String email, String password) {
		super();
		this.userid = userId;
		this.name = name;
		this.email = email;
		this.password = password;

	}
	

	/**
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 * @return
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * 
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", email=" + email + "]";
	}

	/**
	 * 
	 * @return
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * 
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * 
	 * @return
	 */
	public int getUserid() {
		return userid;
	}

	/**
	 * 
	 * @param userid
	 */
	public void setUserid(int userid) {
		this.userid = userid;
	}

}
