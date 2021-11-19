package com.expensetracker.client;

import java.util.Scanner;

import com.expensetracker.exceptions.UserNotFoundException;
import com.expensetracker.model.User;
import com.expensetracker.service.IUserService;
import com.expensetracker.service.UserServiceImpl;

public class Client {

	public static void main(String[] args) {
		IUserService userService = new UserServiceImpl();

		Scanner scanner = new Scanner(System.in);

		System.out.println("My Expense Tracker");
		System.out.println();
		System.out.println("-----------------------------");
		System.out.println("\t" + "Login Page" + "\t" + "\t");
		System.out.println("-----------------------------");

		System.out.println("Login PRESS 1");
		System.out.println("SignUp PRESS 2");
		int login = scanner.nextInt();
		int loop = 0;

		switch (login) {
		case 1:
			loop = 0;
			while (loop < 1) {
				System.out.println();
				System.out.println("Enter email: ");
				String email = scanner.next();
				System.out.println("Enter password");
				String password = scanner.next();

				User user = new User(email, password);
				try {
					userService.loginUser(user);
				} catch (UserNotFoundException e) {
					e.printStackTrace();
				}

				System.out.println("Welcome " + user.getEmail());

				System.out.println("");

				loop += 1;

				break;

			}
		case 2:
			System.out.println("-----------------------------");
			System.out.println("\t" + "Register User" + "\t" + "\t");
			System.out.println("-----------------------------");

			System.out.println("Enter your name:");
			String registerName = scanner.next();
			System.out.println("Enter your email:");
			String registerEmail = scanner.next();
			System.out.println("Enter Password:");
			String registerPassword = scanner.next();
			User registerUser = new User(registerName, registerEmail, registerPassword);
			userService.registerUser(registerUser);
			System.out.println("Registration Successfully");

			break;

		default:
			break;
		}

	}
}