package com.shop.controller;

import com.shop.service.ProductService;

public class ProductGetAll {
	public static void main(String[] args) {

		ProductService productService = new ProductService();
		productService.getAllProducts();
	}
}
