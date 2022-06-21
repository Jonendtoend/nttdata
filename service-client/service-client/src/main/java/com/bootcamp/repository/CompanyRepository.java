package com.bootcamp.repository;

import com.bootcamp.dao.Company;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CompanyRepository extends MongoRepository<Company,String> {
}
