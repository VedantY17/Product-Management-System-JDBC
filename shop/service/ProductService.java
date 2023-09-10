package com.shop.service;

import com.shop.dao.ProductDao;
import com.shop.dto.Product;

public class ProductService {

	ProductDao productDao = new ProductDao();

	public Product saveProducts(Product product) {
		return productDao.saveProducts(product);
	}

	public boolean deleteProductsById(int id) {
		return productDao.deleteProductsById(id);
	}

	public boolean updateProductsByPrice(int id, double price) {
		return productDao.updateProductsByPrice(id, price);
	}

	public boolean getProductsByID(int id) {
		return productDao.getProductsByID(id);
	}

	public void getAllProducts() {
		productDao.getAllProducts();
	}
}
