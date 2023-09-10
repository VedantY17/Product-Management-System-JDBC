package com.shop.controller;

import java.util.Scanner;

import com.shop.dto.Customer;
import com.shop.service.CustomerService;

public class CustomerSave {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Customer ID: ");
		int id = sc.nextInt();
		while (id <= 0) {
			System.out.print("ID cannot be 0. Please enter a valid ID: ");
			id = sc.nextInt();
		}

		sc.nextLine();

		System.out.print("Enter Customer Name: ");
		String name = sc.nextLine();

		System.out.print("Enter Customer Email: ");
		String email = sc.nextLine();
		while (!email.contains("@")) {
			System.out.println("Email must contain @....");
			System.out.print("Enter valid email: ");
			email = sc.nextLine();
		}

		System.out.print("Enter Customer ConatactNo: ");
		int contact = sc.nextInt();

		Customer customer = new Customer();
		customer.setId(id);
		customer.setName(name);
		customer.setEmail(email);
		customer.setContact(contact);

		CustomerService customerService = new CustomerService();
		Customer cust = customerService.saveCustomer(customer);

		if (cust != null) {
			System.out.println("values of id " + cust.getId() + " saved");
		}

		sc.close();
	}
}
