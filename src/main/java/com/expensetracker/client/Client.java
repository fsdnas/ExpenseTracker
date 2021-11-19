package com.expensetracker.client;

import java.util.Scanner;

import com.expensetracker.exceptions.UserNotFoundException;
import com.expensetracker.model.Expense;
import com.expensetracker.model.User;
import com.expensetracker.service.ExpenseServiceImpl;
import com.expensetracker.service.IExpenseService;
import com.expensetracker.service.IUserService;
import com.expensetracker.service.UserServiceImpl;

public class Client {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		IUserService userService = new UserServiceImpl();
		IExpenseService expenseService = new ExpenseServiceImpl();

		System.out.println("My Expense Tracker");
		System.out.println();
		System.out.println("-----------------------------");
		System.out.println("\t" + "Login Page" + "\t" + "\t");
		System.out.println("-----------------------------");

		while (true) {

			System.out.println("Login PRESS 1");
			System.out.println("SignUp PRESS 2");
			int login = scanner.nextInt();

			switch (login) {
			case 1:
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
					break;
				}

				System.out.println("Welcome " + user.getEmail());

				System.out.println("Find All Transactions PRESS 0");
				System.out.println("Add Transaction PRESS 1");
				System.out.println("Update Transaction PRESS 2");
				System.out.println("Delete Transaction PRESS 3");
				System.out.println("Update Transaction PRESS 4");
				System.out.println("Get Transaction By Date PRESS 5");
				System.out.println("Get Transaction By User PRESS 6");
				System.out.println("Get Category statistics PRESS 7");
				System.out.println("Get mode of transaction stats By  PRESS 8");

				int input = scanner.nextInt();
				switch (input) {
				case 0:
					expenseService.findAllTransaction();
					break;
				case 1:
					System.out.println("Enter User Id");
					int userid = scanner.nextInt();

					System.out.println("Enter type(credit/debit)");
					String type = scanner.next();

					System.out.println("Enter category(apparel/groceries/food)");
					String category = scanner.next();

					System.out.println("Enter mode of transaction(upi/netbanking/wiretransfer/card)");
					String mode = scanner.next();

					System.out.println("Enter amount spent");
					double amount = scanner.nextDouble();

					User userExpense = new User(userid);
					Expense expense = new Expense(userExpense, type, category, mode, amount);
					expenseService.addTransaction(expense);

					break;
				case 2:
					expenseService.findAllTransaction();
					break;
				case 3:
					expenseService.findAllTransaction();
					break;

				default:
					break;
				}

				break;

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
				System.exit(0);
				break;
			}

		}

	}
}