package com.amdtelecom.facebookmessenger.facebookmessengerservices.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.query.MongoParameterAccessor;

public interface MessageRepository extends MongoRepository<T, ID>, MongoParameterAccessor {

}
