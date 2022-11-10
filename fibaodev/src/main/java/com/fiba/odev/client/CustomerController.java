package com.fiba.odev.client;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.fiba.odev.Customer;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;

@Controller
public class CustomerController {
	@GetMapping("/customer/get")
	@ResponseBody
	public String getCustomer() {
		long customerId = 301;
		String url = "http://localhost:8080/api/customer/" + customerId;
		RestTemplate restTemplate = new RestTemplate();
		Customer customer = restTemplate.getForObject(url, Customer.class);
		System.out.println("ürün:  " + customer.getCustomerName());
		return "Edinildi " + customer.getCustomerName() + " " + customer.getTotalDebit();
	}

	@GetMapping("/customer/post")
	@ResponseBody
	public String postCustomer() {
		Customer customer = new Customer(0, "Fatih Tekke", 15000);
		String url = "http://localhost:8080/api/customer";
		RestTemplate restTemplate = new RestTemplate();
		Customer result = restTemplate.postForObject(url, customer, Customer.class);
		return "Yollandı " + result.getCustomerId();
	}

	@GetMapping("/customer/put")
	@ResponseBody
	public String putCustomer() {
		Customer customer = new Customer(302, "Gökdeniz Karadeniz", 18000);
		String url = "http://localhost:8080/api/customer";
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.exchange(url, HttpMethod.PUT, new HttpEntity<Customer>(customer), void.class);
		return "Koyuldu ";
	}

	@GetMapping("/customer/delete")
	@ResponseBody
	public String deleteCustomer() {
		long customerId = 303;
		String url = "http://localhost:8080/api/customer/" + customerId;
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(url);
		return "Silindi ";
	}
}
