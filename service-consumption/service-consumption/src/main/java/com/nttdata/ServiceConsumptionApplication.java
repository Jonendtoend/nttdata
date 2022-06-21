package com.nttdata;

import com.nttdata.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ServiceConsumptionApplication {

	@Autowired
	AccountRepository repository;
	public static void main(String[] args) {
		SpringApplication.run(ServiceConsumptionApplication.class, args);
	}



}
