package com.stl.crm.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.stl.crm.domain.Customer;

@Service
public class CustomerService {

	public List<Customer> customerList = null;
	
	public List<Customer> getCustomers(){
		
		return customerList;
	}
	
	public Customer getCostumer(long customerId) {
		
		for (Customer customer : customerList) {
			if (customer.getId()==customerId) {
				return customer;
			}
		}
		return null;
	}
	
	public Customer updateCustomer(long customerId, Customer customer) {
		
		for (Customer existingCustomer : customerList) {
			if(existingCustomer.getId()==customer.getId()) {
				existingCustomer.setName(customer.getName());
				existingCustomer.setAddress(customer.getAddress());
				existingCustomer.setPhone(customer.getPhone());
				existingCustomer.setContact(customer.getContact());
				
				return existingCustomer;
			}
		}
		return null;
	}
	
	public Customer addCustomer (Customer customer) {
		customer.setId(customerList.size()+1);
		customerList.add(customer);
		
		return customer;
	}
	
	public void deleteCustomer (Customer customer) {
		customerList.remove(customer);
		
	}
	
	@PostConstruct
	private void setupCustomers() {
		customerList = new ArrayList<Customer>();
		Customer customer = new Customer();
		
		customer.setId(1);
		customer.setName("Maxi");
		customer.setAddress("Tucuman y Bulnes");
		customer.setPhone("1234567");
		customer.setContact("Dev");
		customerList.add(customer);
		
		customer = new Customer();
		customer.setId(2);
		customer.setName("Fabi");
		customer.setAddress("Tucuman y Bulnes");
		customer.setPhone("0987654");
		customer.setContact("QA");
		customerList.add(customer);
		
	}
	
}
