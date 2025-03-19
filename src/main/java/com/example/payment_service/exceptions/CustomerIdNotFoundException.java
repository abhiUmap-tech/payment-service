package com.example.payment_service.exceptions;

public class CustomerIdNotFoundException extends RuntimeException{
    
    public CustomerIdNotFoundException(String message){
        super(message);
    }

}
