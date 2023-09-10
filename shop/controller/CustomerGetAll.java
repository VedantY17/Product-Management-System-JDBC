package com.shop.controller;

import com.shop.service.CustomerService;

public class CustomerGetAll {
	public static void main(String[] args) {

		CustomerService customerService = new CustomerService();
		customerService.getAllCustomers();
	}
}
