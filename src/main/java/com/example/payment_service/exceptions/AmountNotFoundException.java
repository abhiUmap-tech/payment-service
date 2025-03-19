package com.example.payment_service.exceptions;

public class AmountNotFoundException extends RuntimeException{

    public AmountNotFoundException(String message){
        super(message);
    }

}
