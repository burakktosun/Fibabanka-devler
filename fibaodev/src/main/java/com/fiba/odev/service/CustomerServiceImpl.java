package com.fiba.odev.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fiba.odev.Customer;


@Service
public class CustomerServiceImpl implements CustomerService{

	@Override
	public Customer find(long customerId) {
		Customer customer = new Customer(customerId,"Fatih Tekke", 15000);
		System.out.println("İşgörü çalıştı. ");
		return customer;
	}

	
	@Override
	public List<Customer> findAll() {
		List<Customer> customerList = new ArrayList<>();
		customerList.add(new Customer(301, "Fatih Tekke", 15000));
		customerList.add(new Customer(302, "Gökdeniz Karadeniz", 2000));
		customerList.add(new Customer(303, "Hüseyin Çimşir", 10000));
		return customerList;
	}

	@Override
	public void createCustomer(Customer customer) {
		customer.setCustomerId(301);
		System.out.println("Müşteri eklendi " 
				+ customer.getCustomerId() + " " 
				+ customer.getCustomerName() + " "
				+ customer.getTotalDebit());
	}

	@Override
	public void updateCustomer(Customer customer) {
		System.out.println("Müşteri eklendi " 
				+ customer.getCustomerId() + " " 
				+ customer.getCustomerName() + " "
				+ customer.getTotalDebit());		
	}

	@Override
	public void deleteCustomer(long customerId) {
		System.out.println("Müşteri silindi " + customerId);		
	}
}
