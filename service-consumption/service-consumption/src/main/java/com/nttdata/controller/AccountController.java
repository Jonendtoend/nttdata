package com.nttdata.controller;


import com.nttdata.dao.Account;
import com.nttdata.handler.ConsumptionException;
import com.nttdata.service.AccountSerevice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/accounts")
@RestController
public class AccountController {
    private final Logger LOGGER= LoggerFactory.getLogger("AccountController");
    private  final AccountSerevice accountSerevice;
    public AccountController(AccountSerevice accountSerevice){
        this.accountSerevice=accountSerevice;
    }
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void create(@RequestBody Account account){
        accountSerevice.create(account);
    }

    /**
     * retorna todos los consumos de un cliente
     * */
    @GetMapping(path = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<Account> findById(@PathVariable String id){

         if(accountSerevice.findById(id).size()==0){
             LOGGER.error("# se produjo un error con id: "+id);
             throw new ConsumptionException(HttpStatus.NOT_FOUND,"No se pudo encontrar la persona con id: "+id);
         }
         else return  accountSerevice.findById(id);
    }
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Account> findAll(){
       return accountSerevice.findAll();
    }
}
