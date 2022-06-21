package com.bootcamp.service;

import com.bootcamp.dao.Client;

import java.util.List;
import java.util.Optional;

public interface AbstractService <T extends Client>{


    void create(T t);
    List<T> findAll();
    void update(T t, T tNew);
    void delete(String id);

}
