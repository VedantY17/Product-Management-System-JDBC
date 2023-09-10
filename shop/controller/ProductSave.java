package com.shop.controller;

import java.util.Scanner;

import com.shop.dto.Product;
import com.shop.service.ProductService;

public class ProductSave {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("Enter product ID: ");
		int id = sc.nextInt();
		while (id <= 0) {
			System.out.print("ID cannot be 0. Please enter a valid ID :");
			id = sc.nextInt();
		}

		sc.nextLine();

		System.out.print("Enter product category: ");
		String category = sc.nextLine();

		System.out.print("Enter product name: ");
		String name = sc.nextLine();

		System.out.print("Enter product price: ");
		double price = sc.nextDouble();

		Product product = new Product();
		product.setId(id);
		product.setCategory(category);
		product.setName(name);
		product.setPrice(price);

		ProductService productService = new ProductService();
		Product pro = productService.saveProducts(product);

		if (pro != null) {
			System.out.println("values of id " + pro.getId() + " saved");
		}

		sc.close();
	}
}
