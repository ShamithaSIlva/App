package com.threefold.crud.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.threefold.crud.model.Customer;

public interface CustomerRepository extends MongoRepository<Customer,Long>{

}
