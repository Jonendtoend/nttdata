package com.nttdata.client;

import com.nttdata.client.dto.ClientResult;
import com.nttdata.client.dto.AccountRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ClientResultClientImpl implements ClientResultClient{

//clientHostPro

    private  RestTemplate restTemplate=new RestTemplate();
    private final String clientHost;
    private final String clientHostPro;

    public ClientResultClientImpl(@Value("${clientHost}") final String clientHost,
                                  @Value("${clientHost}") final String clientHostPro){

        this.clientHost=clientHost;
        this.clientHostPro=clientHostPro;

    }
    @Override
    public ClientResult retrievePersonResult(String id) {

        return restTemplate.getForObject(clientHost+"/persons/"+id,ClientResult.class);
    }

    @Override
    public AccountRequest retrieveProductResult(String carNumber) {
        return restTemplate.getForObject("http://localhost:8083"+"/products/card/"+carNumber, AccountRequest.class);
    }

    public ResponseEntity<AccountRequest>  updateAccount(AccountRequest request){
        HttpHeaders headers =new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<AccountRequest> putRequest=new HttpEntity<>(request,headers);

        ResponseEntity<AccountRequest> response=restTemplate.exchange("http://localhost:8083"+"/products/card/",
                HttpMethod.PUT,putRequest,AccountRequest.class);

        return response;
    }
}
