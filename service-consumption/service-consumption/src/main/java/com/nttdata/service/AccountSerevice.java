package com.nttdata.service;

import com.nttdata.dao.Account;

import java.util.List;

public interface AccountSerevice extends AbstractService<Account>{

    List<Account> findById(String id);
    @Override
    default Account update(Account account, Account tNew) {
        return null;
    }

    @Override
    default void delete(String id) {
        return ;
    }

}
