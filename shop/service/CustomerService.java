package com.shop.service;

import com.shop.dao.CustomerDao;
import com.shop.dto.Customer;

public class CustomerService {

	CustomerDao customerDao = new CustomerDao();

	public Customer saveCustomer(Customer customer) {
		return customerDao.saveCustomer(customer);
	}

	public boolean deleteCustomersById(int id) {
		return customerDao.deleteCustomersById(id);
	}

	public boolean updateCustomersByEmail(int id, String email) {
		return customerDao.updateCustomersByEmail(id, email);
	}

	public boolean getCustomersById(int id) {
		return customerDao.getCustomersById(id);
	}

	public void getAllCustomers() {
		customerDao.getAllCustomers();
	}
}
