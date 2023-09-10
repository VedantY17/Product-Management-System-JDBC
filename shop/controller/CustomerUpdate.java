package com.shop.controller;

import java.util.Scanner;

import com.shop.service.CustomerService;

public class CustomerUpdate {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the ID: ");
		int id = sc.nextInt();
		while (id <= 0) {
			System.out.print("ID cannot be 0. Please enter a valid ID: ");
			id = sc.nextInt();
		}

		sc.nextLine();

		System.out.print("Enter email to be updated: ");
		String email = sc.nextLine();
		while (!email.contains("@")) {
			System.out.println("Email must contain @....");
			System.out.print("Enter valid email: ");
			email = sc.nextLine();
		}

		CustomerService customerService = new CustomerService();
		boolean res = customerService.updateCustomersByEmail(id, email);
		System.out.println(res);

		sc.close();
	}
}
