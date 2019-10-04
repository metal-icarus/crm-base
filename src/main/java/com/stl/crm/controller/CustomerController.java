package com.stl.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.stl.crm.domain.Customer;
import com.stl.crm.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@RequestMapping (value="/customers", method=RequestMethod.GET)
	public ResponseEntity<?> getCustomers(){
		List<Customer> customerList = customerService.getCustomers();
		
		return new ResponseEntity<>(customerList, HttpStatus.OK);
	}
	
	@RequestMapping (value="/customers/{customerId}", method=RequestMethod.GET)
	public ResponseEntity<?> getCostumer(@PathVariable long customerId){
		Customer customer = customerService.getCostumer(customerId);
				
		return new ResponseEntity<>(customer, HttpStatus.OK);
	}
	
	@RequestMapping (value="/customers", method=RequestMethod.POST)
	public ResponseEntity<?> addCustomer(@RequestBody Customer customer){
		Customer newCustomer = customerService.addCustomer(customer);
		
		return new ResponseEntity<>(newCustomer, HttpStatus.CREATED);
	}
	
	@RequestMapping (value="/customers/{customerId}", method=RequestMethod.PUT)
	public ResponseEntity<?> updateCustomer (@PathVariable long customerId, @RequestBody Customer customer){
		Customer updatedCustomer = customerService.updateCustomer(customerId, customer);
		
		return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
	}
	
	@RequestMapping (value="/customers/{customerId}", method=RequestMethod.DELETE)
	public ResponseEntity<?> deleteCustomer (@PathVariable long customerId, @RequestBody Customer customer){
		customerService.deleteCustomer(customer);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ResponseEntity<?> home(){
		return new ResponseEntity<>("CRM REST API Base 1", HttpStatus.OK);
	}

}
