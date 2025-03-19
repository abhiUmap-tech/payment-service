package com.example.payment_service.exceptions;

public class PaymentDtoNullException extends RuntimeException{

    public PaymentDtoNullException(String message){
        super(message);
    }

}
