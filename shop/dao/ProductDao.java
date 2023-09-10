package com.shop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.shop.configuration.ShopHelperClass;
import com.shop.dto.Product;

public class ProductDao {

	Product product = new Product();

	ShopHelperClass shopHelperClass = new ShopHelperClass();

	Connection connection = null;

	// to save product details
	public Product saveProducts(Product product) {

		// to get connection
		connection = shopHelperClass.getConnection();

		String sql = "INSERT INTO product VALUES(?,?,?,?)";

		try {
			// to create prepare statement
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setInt(1, product.getId());
			preparedStatement.setString(2, product.getCategory());
			preparedStatement.setString(3, product.getName());
			preparedStatement.setDouble(4, product.getPrice());

			// to execute query
			preparedStatement.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return product;
	}

	// to delete product details
	public boolean deleteProductsById(int id) {

		// to get connection
		connection = shopHelperClass.getConnection();

		String sql = "DELETE FROM product WHERE ID = ?";

		try {
			// to create prepare statement
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setInt(1, id);

			// to execute query
			int i = preparedStatement.executeUpdate();

			if (i > 0) {
				return true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;

	}

	// to update product details by price
	public boolean updateProductsByPrice(int id, double price) {

		connection = shopHelperClass.getConnection();

		String sql = "UPDATE product SET price = ? WHERE ID = ?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setDouble(1, price);
			preparedStatement.setInt(2, id);

			int i = preparedStatement.executeUpdate();

			if (i > 0) {
				return true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}

	// to get details of product by id
	public boolean getProductsByID(int id) {

		connection = shopHelperClass.getConnection();

		String sql = "SELECT * FROM product WHERE ID = ?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setInt(1, id);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				System.out.println("Product ID: " + resultSet.getInt(1));
				System.out.println("Category: " + resultSet.getString(2));
				System.out.println("Product Name: " + resultSet.getString(3));
				System.out.println("Price: " + resultSet.getDouble(4));
				return true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}

	// to get all the details of the table
	public void getAllProducts() {

		connection = shopHelperClass.getConnection();

		String sql = "SELECT * FROM product";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			ResultSet resultSet = preparedStatement.executeQuery();

			System.out.println("PRODUCT TABLE");
			System.out.println();

			while (resultSet.next()) {
				System.out.println("Product ID: " + resultSet.getInt(1));
				System.out.println("Category: " + resultSet.getString(2));
				System.out.println("Product Name: " + resultSet.getString(3));
				System.out.println("Price: " + resultSet.getDouble(4));
				System.out.println("===========================");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
