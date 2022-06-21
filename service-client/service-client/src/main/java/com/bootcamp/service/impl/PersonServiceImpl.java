package com.bootcamp.service.impl;

import com.bootcamp.dao.Person;
import com.bootcamp.repository.PersonRepository;
import com.bootcamp.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {
    private final Logger LOGGER= LoggerFactory.getLogger("PersonServiceImpl");
    private PersonRepository personRepository;

    public PersonServiceImpl( PersonRepository personRepository){
        this.personRepository=personRepository;
    }
    @Override
    public void create(Person person) {
        personRepository.save(person);
    }

    @Override
    public List<Person> findAll() {
        return personRepository.findAll();
    }
    /**
     * @param person
     * @param newPerson
     * Actulizacion de los registros
     * */
    @Override
    public void update(Person person, Person newPerson)  {
        person.setName(newPerson.getName());
        person.setIdentificaiton(newPerson.getIdentificaiton());
        person.setModifiedAt(LocalDateTime.now());
        person.setState(newPerson.getState());
        person.setLastName(newPerson.getLastName());
        personRepository.save(person);
        LOGGER.info("# guardado correctamente");
    }

    /**
     * @param id
     * Se utiliza para buscar un registro de persona,
     * pero solo lo elimina logicamente, porque solo
     * cambia el estado
     * */
    @Override
    public void delete(String id) {
        Optional<Person> personOptional= personRepository.findById(id);
        if(personOptional.isPresent()) {
            Person person=personOptional.get();
            person.setState(0);
            personRepository.save(person);
        }

    }
    /**
     * @param id
     * Se utiliza para buscar un registro de persona
     * */
    @Override
    public Optional<Person> findById(String id){
        return personRepository.findById(id);
    }
}
