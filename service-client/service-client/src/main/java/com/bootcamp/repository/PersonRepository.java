package com.bootcamp.repository;

import com.bootcamp.dao.Person;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonRepository extends MongoRepository<Person,String> {
}
