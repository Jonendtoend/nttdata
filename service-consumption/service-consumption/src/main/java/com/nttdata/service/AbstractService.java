package com.nttdata.service;

import com.nttdata.dao.Account;

import java.util.List;


public interface AbstractService<T extends Account>{


    void create(T t);
    List<T> findAll();
    T update(T t, T tNew);
    void delete(String id);

}
