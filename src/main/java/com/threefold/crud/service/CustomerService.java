package com.threefold.crud.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.threefold.crud.model.Customer;
import com.threefold.crud.model.Response;
import com.threefold.crud.repository.CustomerRepository;
import com.threefold.crud.repository.ResponseRepository;
import com.threefold.crud.utils.AppConstants;

@Service
public class CustomerService
{
	private CustomerRepository customerRepository;	
	private ResponseRepository responseRepository;	
	private SequenceGeneratorService sequenceGeneratorService;
	
	@Autowired
	public CustomerService( CustomerRepository customerRepository, ResponseRepository responseRepository ,SequenceGeneratorService sequenceGeneratorService)
	{
		this.customerRepository = customerRepository;
		this.responseRepository = responseRepository;
		this.sequenceGeneratorService = sequenceGeneratorService;
	}
	
	public Response findCustomerById(long id)
	{
		List<Customer> payload = new ArrayList<>();
		payload.add( customerRepository.findById(id).get() );
		Response response = new Response(sequenceGeneratorService.generateSequence( Response.SEQUENCE_NAME ),HttpStatus.OK.value(),HttpStatus.OK.getReasonPhrase(),AppConstants.CUSTOMER_FOUND+id,payload);
		responseRepository.save( response );
		return response;
	}
	
	public Response findAllCustomers()
	{
		List<Customer> payload = new ArrayList<>();
		payload.addAll( customerRepository.findAll() );
		Response response = new Response(sequenceGeneratorService.generateSequence( Response.SEQUENCE_NAME ),HttpStatus.OK.value(),HttpStatus.OK.getReasonPhrase(),AppConstants.CUSTOMERS_FOUND,payload);
		responseRepository.save( response );
		return response;
	}
	
	public Response deleteCustomerById(long id)
	{
		customerRepository.deleteById(id);
		Response response = new Response(sequenceGeneratorService.generateSequence( Response.SEQUENCE_NAME ),HttpStatus.OK.value(),HttpStatus.OK.getReasonPhrase(),AppConstants.CUSTOMER_DELETED+id,new ArrayList<>());
		responseRepository.save( response );
		return response;
	}

	public Response addCustomer(Customer customer)
	{
		customer.setId( sequenceGeneratorService.generateSequence( Customer.SEQUENCE_NAME ));
		customerRepository.save(customer);
		List<Customer> payload = new ArrayList<>();
		payload.add( customer );
		Response response = new Response(sequenceGeneratorService.generateSequence( Response.SEQUENCE_NAME ),HttpStatus.OK.value(),HttpStatus.OK.getReasonPhrase(),AppConstants.CUSTOMER_ADDED,payload);
		responseRepository.save( response );
		return response;		
	}
	
	public Response replaceCustomer(Customer newCustomer,Long id)
	{
		List<Customer> payload = new ArrayList<>();
		final Customer updatedCustomer;		
		updatedCustomer = customerRepository.findById(id)
			      .map(customer -> {
			    	  customer.setName(newCustomer.getName());
			    	  customer.setSurname(newCustomer.getSurname());
			    	  customer.setInitials(newCustomer.getInitials());
			    	  customer.setMobile(newCustomer.getMobile());
			    	  customer.setIdNumber(newCustomer.getIdNumber());
			    	  customer.setLastUpdated(newCustomer.getLastUpdated());
			        return customerRepository.save(customer);
			      })
			      .orElseGet(() -> {
			    	  newCustomer.setId(id);
			        return customerRepository.save(newCustomer);
			      });
		payload.add( updatedCustomer );
		Response response = new Response(sequenceGeneratorService.generateSequence( Response.SEQUENCE_NAME ),HttpStatus.OK.value(),HttpStatus.OK.getReasonPhrase(),AppConstants.CUSTOMER_UPDATED,payload);
		responseRepository.save( response );
		return response;
	}
}
