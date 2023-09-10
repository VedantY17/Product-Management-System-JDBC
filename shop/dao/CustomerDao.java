package com.shop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.shop.configuration.ShopHelperClass;
import com.shop.dto.Customer;

public class CustomerDao {

	Customer customer = new Customer();

	ShopHelperClass shopHelperClass = new ShopHelperClass();

	Connection connection = null;

	// to save customer data
	public Customer saveCustomer(Customer customer) {

		// to get connection
		connection = shopHelperClass.getConnection();

		String sql = "INSERT INTO customer VALUES(?,?,?,?)";

		try {
			// to create prepare statement
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setInt(1, customer.getId());
			preparedStatement.setString(2, customer.getName());
			preparedStatement.setString(3, customer.getEmail());
			preparedStatement.setInt(4, customer.getContact());

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
		return customer;
	}

	// to delete customer data by id
	public boolean deleteCustomersById(int id) {

		// to get connection
		connection = shopHelperClass.getConnection();

		String sql = "DELETE FROM customer WHERE ID = ?";

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

	// to update customer data by email
	public boolean updateCustomersByEmail(int id, String email) {

		connection = shopHelperClass.getConnection();

		String sql = "UPDATE customer SET email = ? WHERE ID = ?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, email);
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

	// to get customer data by id
	public boolean getCustomersById(int id) {

		connection = shopHelperClass.getConnection();

		String sql = "SELECT * FROM customer WHERE ID = ?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setInt(1, id);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				System.out.println("Customer ID: " + resultSet.getInt(1));
				System.out.println("Customer Name: " + resultSet.getString(2));
				System.out.println("Email ID: " + resultSet.getString(3));
				System.out.println("Contact No: " + resultSet.getInt(4));
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
	public void getAllCustomers() {

		connection = shopHelperClass.getConnection();

		String sql = "SELECT * FROM customer";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			ResultSet resultSet = preparedStatement.executeQuery();

			System.out.println("CUSTOMER TABLE");
			System.out.println();

			while (resultSet.next()) {
				System.out.println("Customer ID: " + resultSet.getInt(1));
				System.out.println("Customer Name: " + resultSet.getString(2));
				System.out.println("Email ID: " + resultSet.getString(3));
				System.out.println("Contact No: " + resultSet.getInt(4));
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
