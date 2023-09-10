package com.shop.controller;

import java.util.Scanner;

import com.shop.service.CustomerService;

public class CustomerDelete {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Customer ID to be deleted: ");
		int id = sc.nextInt();
		while (id <= 0) {
			System.out.print("ID cannot be 0. Please enter a valid ID: ");
			id = sc.nextInt();
		}

		CustomerService customerService = new CustomerService();
		boolean res = customerService.deleteCustomersById(id);
		System.out.println(res);

		sc.close();

	}
}
