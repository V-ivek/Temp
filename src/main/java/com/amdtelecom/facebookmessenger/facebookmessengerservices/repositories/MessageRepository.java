package com.amdtelecom.facebookmessenger.facebookmessengerservices.repositories;

import com.amdtelecom.facebookmessenger.facebookmessengerservices.models.Message;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.query.MongoParameterAccessor;

public interface MessageRepository extends MongoRepository<Message, String>{

}
