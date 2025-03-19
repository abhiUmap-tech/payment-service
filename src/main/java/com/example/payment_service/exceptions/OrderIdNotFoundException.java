package com.example.payment_service.exceptions;

public class OrderIdNotFoundException extends RuntimeException{

    public OrderIdNotFoundException(String message){
        super(message);
    }

}
