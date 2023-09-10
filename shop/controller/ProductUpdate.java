package com.shop.controller;

import java.util.Scanner;

import com.shop.service.ProductService;

public class ProductUpdate {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the ID: ");
		int id = sc.nextInt();
		while (id <= 0) {
			System.out.print("ID cannot be 0. Please enter a valid ID: ");
			id = sc.nextInt();
		}

		System.out.print("Enter the Price to be updated: ");
		double price = sc.nextDouble();

		ProductService productService = new ProductService();
		boolean res = productService.updateProductsByPrice(id, price);
		System.out.println(res);

		sc.close();
	}
}
