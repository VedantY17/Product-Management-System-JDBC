package com.shop.controller;

import java.util.Scanner;

import com.shop.service.ProductService;

public class ProductDelete {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("Enter product ID to be deleted: ");
		int id = sc.nextInt();
		while (id <= 0) {
			System.out.print("ID cannot be 0. Please enter a valid ID: ");
			id = sc.nextInt();
		}

		ProductService productService = new ProductService();
		boolean res = productService.deleteProductsById(id);
		System.out.println(res);

		sc.close();
	}
}
