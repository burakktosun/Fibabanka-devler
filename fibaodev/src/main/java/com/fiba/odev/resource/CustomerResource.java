package com.fiba.odev.resource;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fiba.odev.Customer;
import com.fiba.odev.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import java.util.List;


@RestController
public class CustomerResource {
	@Autowired
	private CustomerService customerService;
	
	
	@GetMapping("/api/customer/{id}") 
	public Customer getCustomer(@PathVariable("id") long customerId) {
		Customer customer = customerService.find(customerId);
		return customer;
	}

	@GetMapping("/api/customers") 
	public List<Customer> getCustomers() {
		List<Customer> customerList = customerService.findAll();
		return customerList;
	}

	@PostMapping("/api/customer") 
	public Customer postCustomer(@RequestBody Customer customer) {
		customer.setCustomerId(301);
		customerService.createCustomer(customer);
		return customer;
	}

	@PutMapping("/api/customer")  
	public void putCustomer(@RequestBody Customer customer) {
		customerService.updateCustomer(customer);
	}

	@DeleteMapping("/api/customer/{id}" ) 
	public void deleteCustomer(@PathVariable("id")long customerId) {
		customerService.deleteCustomer(customerId);
	}
	
}