package com.example.payment_service.advices;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.payment_service.configurations.ErrorDetails;
import com.example.payment_service.exceptions.AmountNotFoundException;
import com.example.payment_service.exceptions.CustomerIdNotFoundException;
import com.example.payment_service.exceptions.OrderIdNotFoundException;
import com.example.payment_service.exceptions.PaymentDateNotFoundException;
import com.example.payment_service.exceptions.PaymentDtoNullException;
import com.example.payment_service.exceptions.PaymentMethodNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AmountNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleAmountNotFoundException(AmountNotFoundException amountNotFoundException) {

        var errorDetails = new ErrorDetails(404, amountNotFoundException.getMessage(), LocalDateTime.now());
        return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CustomerIdNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleCustomerIdNotFoundException(
            CustomerIdNotFoundException customerIdNotFoundException) {

        var errorDetails = new ErrorDetails(404, customerIdNotFoundException.getMessage(), LocalDateTime.now());
        return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(OrderIdNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleOrderIdNotFoundException(
            OrderIdNotFoundException orderIdNotFoundException) {

        var errorDetails = new ErrorDetails(404, orderIdNotFoundException.getMessage(), LocalDateTime.now());
        return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(PaymentDateNotFoundException.class)
    public ResponseEntity<ErrorDetails> handlePaymentDateNotFoundException(
            PaymentDateNotFoundException paymentDateNotFoundException) {

        var errorDetails = new ErrorDetails(404, paymentDateNotFoundException.getMessage(), LocalDateTime.now());
        return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(PaymentDtoNullException.class)
    public ResponseEntity<ErrorDetails> handlePaymentDtoNullException(PaymentDtoNullException paymentDtoNullException) {

        var errorDetails = new ErrorDetails(404, paymentDtoNullException.getMessage(), LocalDateTime.now());
        return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(PaymentMethodNotFoundException.class)
    public ResponseEntity<ErrorDetails> handlePaymentMethodNotFoundException(PaymentMethodNotFoundException paymentMethodNotFoundException) {

        var errorDetails = new ErrorDetails(404, paymentMethodNotFoundException.getMessage(), LocalDateTime.now());
        return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> handleException(Exception exception) {

        var errorDetails = new ErrorDetails(404, exception.getMessage(), LocalDateTime.now());
        return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);
    }

}
