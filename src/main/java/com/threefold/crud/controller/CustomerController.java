package com.threefold.crud.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.threefold.crud.model.Customer;
import com.threefold.crud.repository.CustomerRepository;


@RestController
public class CustomerController {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@PostMapping("/addCustomer")
	public String saveCustomer(@RequestBody Customer emp) {
		customerRepository.save(emp);
		return "Customer added successfully::"+emp.getId();
		
	}
	
	@GetMapping("/findAllCustomers")
	public List<Customer> getCustomers() {
		return customerRepository.findAll();
	}

	@GetMapping("/findCustomer/{id}")
	public Optional<Customer> getCustomer(@PathVariable long id) {
		return customerRepository.findById(id);
	}
	
	@GetMapping("/deleteCustomer/{id}")
	public String deleteCustomer(@PathVariable long id) {
		customerRepository.deleteById(id);
		return "Deleted Customer Successfully::"+id;
	}

}
