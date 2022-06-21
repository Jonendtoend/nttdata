package com.bootcamp.service.impl;

import com.bootcamp.dao.Company;
import com.bootcamp.dao.Person;
import com.bootcamp.repository.CompanyRepository;
import com.bootcamp.service.CompanyService;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {

    private final Logger LOGGER= LoggerFactory.getLogger("CompanyServiceImpl");
    private final CompanyRepository companyRepository;
    public CompanyServiceImpl(CompanyRepository companyRepository){
        this.companyRepository=companyRepository;
    }

     /**
     * @param company
      * Guarda el objeto compañia
     * */
    @Override
    public void create(Company company) {
        companyRepository.save(company);
    }

    /**
     * Retorna todos los objetos
     * de la compañia registrados
     * */
    @Override
    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    /**
     * @param company
     * @param newCompany
     * Actulizacion de los registros
     * */
    @Override
    public void update(Company company, Company newCompany) {
        company.setState(newCompany.getState());
        company.setName(newCompany.getName());
        company.setRuc(newCompany.getRuc());
        companyRepository.save(company);
        LOGGER.info("#: Actualizado correctamente");
    }

    /**
     * @param id
     * El id se usa para eliminar un registro
     * logicamnte, porque solo le cambia el estado
     * */
    @Override
    public void delete(String id) {
        Optional<Company> companyOption=companyRepository.findById(id);
        if(companyOption.isPresent()) {
            Company company=companyOption.get();
            company.setState(0);
            companyRepository.save(company);
        }

    }
    /**
     * @param id
     * El id lo utiliza para buscar un registro
     * */
    @Override
    public Optional<Company> findById(String id) {
        return companyRepository.findById(id);
    }
}
