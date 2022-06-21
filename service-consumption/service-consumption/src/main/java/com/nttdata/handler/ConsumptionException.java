package com.nttdata.handler;

import org.springframework.http.HttpStatus;

public class ConsumptionException extends RuntimeException{

    private HttpStatus httpStatus;
    public ConsumptionException(String message){super(message);}

    public ConsumptionException(HttpStatus httpStatus ,String message){
        super(message);
        this.httpStatus=httpStatus;
    }
    public ConsumptionException(HttpStatus httpStatus ,Throwable cause){
        super(cause);
        this.httpStatus=httpStatus;
    }
    public ConsumptionException(String message ,Throwable cause){
        super(message,cause);

    }
    public String errorMessage(){ return httpStatus.value()+" : ".concat(getMessage());}
    public HttpStatus getHttpStatus() {return  httpStatus;}
}
