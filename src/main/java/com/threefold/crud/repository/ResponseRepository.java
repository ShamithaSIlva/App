package com.threefold.crud.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.threefold.crud.model.Response;

public interface ResponseRepository extends MongoRepository<Response,Long>
{

}
