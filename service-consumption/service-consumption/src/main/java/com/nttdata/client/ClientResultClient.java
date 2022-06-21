package com.nttdata.client;

import com.nttdata.client.dto.ClientResult;
import com.nttdata.client.dto.AccountRequest;
import org.springframework.http.ResponseEntity;

public interface ClientResultClient {

    ClientResult retrievePersonResult(String id);
    AccountRequest retrieveProductResult(String carNumber);
    ResponseEntity<AccountRequest> updateAccount(AccountRequest request);
}
