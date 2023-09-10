package com.shop.controller;

import java.util.Scanner;

import com.shop.service.CustomerService;

public class CustomerGet {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the ID to get the record: ");
		int id = sc.nextInt();
		while (id <= 0) {
			System.out.print("ID cannot be 0. Please enter a valid ID: ");
			id = sc.nextInt();
		}

		CustomerService customerService = new CustomerService();
		boolean idFound = customerService.getCustomersById(id);

		if (!idFound) {
			System.out.println("!!!!ERROR!!!!");
			System.out.println("The ID entered does not exist in the customer table.");
		}

		sc.close();
	}
}
