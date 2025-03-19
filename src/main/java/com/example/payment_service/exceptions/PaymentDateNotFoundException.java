package com.example.payment_service.exceptions;

public class PaymentDateNotFoundException extends RuntimeException{

    public PaymentDateNotFoundException(String message){
        super(message);
    }

}
