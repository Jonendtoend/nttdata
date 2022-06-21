package com.bootcamp.service;

import com.bootcamp.dao.Company;
import com.bootcamp.dao.Person;

import java.util.Optional;

public interface CompanyService  extends AbstractService<Company>{

    Optional<Company> findById(String id);
}
