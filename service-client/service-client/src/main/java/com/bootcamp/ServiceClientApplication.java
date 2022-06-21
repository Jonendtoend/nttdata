package com.bootcamp;

import com.bootcamp.dao.Client;
import com.bootcamp.dao.Company;
import com.bootcamp.dao.Person;
import com.bootcamp.repository.CompanyRepository;
import com.bootcamp.repository.PersonRepository;
import com.bootcamp.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import sun.tools.jar.CommandLine;

import java.time.LocalDateTime;

@SpringBootApplication
public class ServiceClientApplication {

	@Autowired
	PersonService personService;
	public static void main(String[] args) {
		SpringApplication.run(ServiceClientApplication.class, args);
	}


}
