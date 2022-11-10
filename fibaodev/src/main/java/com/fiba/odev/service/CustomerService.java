package com.fiba.odev.service;

import java.util.List;

import com.fiba.odev.Customer;

public interface CustomerService {
	Customer find(long customerId);
	List<Customer> findAll();
	void createCustomer(Customer customer);
	void updateCustomer(Customer customer);
	void deleteCustomer(long customerId);
}
