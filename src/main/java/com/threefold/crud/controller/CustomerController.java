package com.threefold.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.threefold.crud.model.Customer;
import com.threefold.crud.model.Response;
import com.threefold.crud.service.CustomerService;


@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/addCustomer")
	public Response saveCustomer(@RequestBody Customer customer) {
		return this.customerService.addCustomer(customer);		
	}
	
	@GetMapping("/findAllCustomers")
	public Response getCustomers() {
		return this.customerService.findAllCustomers();
	}

	@GetMapping("/findCustomer/{id}")
	public Response getCustomer(@PathVariable long id) {
		return this.customerService.findCustomerById( id );
	}
	
	@GetMapping("/deleteCustomer/{id}")
	public Response deleteCustomer(@PathVariable long id) {
		return this.customerService.deleteCustomerById( id );
	}
	
	@PutMapping("/customer/{id}")
	 public Response replaceCustomer(@RequestBody Customer newCustomer, @PathVariable Long id) {
		return this.customerService.replaceCustomer( newCustomer, id );
	}

}
