package com.bootcamp.service;

import com.bootcamp.dao.Person;

import java.util.Optional;

public interface PersonService extends AbstractService<Person>{
    Optional<Person> findById(String id);
}
