package com.threefold.crud.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import com.threefold.crud.repository.CustomerRepository;
import com.threefold.crud.repository.ResponseRepository;
import com.threefold.crud.utils.AppConstants;
import com.threefold.crud.model.Customer;
import com.threefold.crud.model.Response;
import java.util.Optional;
import static org.mockito.Mockito.*;

@ContextConfiguration()
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class CustomerServiceTest
{

	@MockBean
    private CustomerRepository customerRepository;
	@MockBean
	private SequenceGeneratorService sequenceGeneratorService;
	@MockBean
	private MongoOperations mongoOperations;
	@MockBean
	ResponseRepository responseRepository;

    
    private CustomerService customerService;    

    @Before
    public void init() throws Exception {
    	sequenceGeneratorService = Mockito.spy(new SequenceGeneratorService( mongoOperations ));
    	customerRepository = Mockito.mock(CustomerRepository.class);    	
    	responseRepository = Mockito.mock(ResponseRepository.class);    	
    	customerService = new CustomerService( customerRepository, responseRepository, sequenceGeneratorService );
    }
    
    @Test
    public void findCustomerById() throws Exception {

    	List<Customer> payload = new ArrayList<>();
    	long id = 2;
    	Customer searchCust = new Customer();
    	searchCust.setId( id );
    	payload.add(searchCust);    	
    	when(sequenceGeneratorService.generateSequence( Response.SEQUENCE_NAME )).thenReturn(id);
    	Response response = new Response(sequenceGeneratorService.generateSequence( Response.SEQUENCE_NAME ),HttpStatus.OK.value(),HttpStatus.OK.getReasonPhrase(),AppConstants.CUSTOMER_FOUND+id,payload);
        when(customerRepository.findById(id)).thenReturn(Optional.of(searchCust));
        assertTrue(customerService.findCustomerById(2L).equals( response ));
    }

}
