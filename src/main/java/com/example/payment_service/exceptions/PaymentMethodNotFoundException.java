package com.example.payment_service.exceptions;

public class PaymentMethodNotFoundException extends RuntimeException{

    public PaymentMethodNotFoundException(String message){
        super(message);
    }

}
