package com.bootcamp.controller;

import com.bootcamp.dao.Person;
import com.bootcamp.handler.ClientException;
import com.bootcamp.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/persons")
public class PersonController {
    private final Logger LOGGER= LoggerFactory.getLogger("PersonController");
    private PersonService personService;

    public PersonController(PersonService personService){
        this.personService=personService;
    }
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void create(@RequestBody Person person){
         personService.create(person);
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Mono<Person> findById(@PathVariable String id){
        Optional<Person> person=personService.findById(id);
        if(person.isPresent()) return Mono.just(person.get());
        else {
            LOGGER.error("# se produjo un error con id: "+id);
            throw new ClientException(HttpStatus.NOT_FOUND,"No se pudo encontrar la persona con id: "+id);
        }
    }
    @PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@RequestBody Person person, @PathVariable String id){
        Optional<Person> personOptional=personService.findById(id);
        if(personOptional.isPresent()){
            personService.update(personOptional.get(),person);
        }else{
            LOGGER.error("# se produjo un error con id: "+id);
            throw new ClientException(HttpStatus.NOT_FOUND,"No se pudo encontrar la persona con id: "+id);
        }

    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String id){
        personService.delete(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Person> getAllPersons(){
        return personService.findAll();
    }
}
