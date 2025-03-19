package com.example.payment_service.restcontroller;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.payment_service.dto.PaymentDto;
import com.example.payment_service.service.IPaymentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/payment")
public class PaymentController {

    private final IPaymentService service;

    @PostMapping("/register")
    public ResponseEntity<String> registerPayment(@RequestBody PaymentDto paymentDto){
        var registeredPayment = service.registerPayment(paymentDto);
        return new ResponseEntity<>(registeredPayment, HttpStatus.CREATED);
    }

    @GetMapping("/findPaymentById/{paymentId}")
    public ResponseEntity<PaymentDto> findPaymentById(@PathVariable String paymentId){
        var paymentDetails = service.findPaymentById(paymentId);
        return new ResponseEntity<>(paymentDetails, HttpStatus.OK);
    }

    @GetMapping("/findAllPayments")
    public ResponseEntity<List<PaymentDto>> findAllPayments(){
        var listOfPaymentDtos = service.findAllPayments();
        return new ResponseEntity<>(listOfPaymentDtos, HttpStatus.OK);
    }


    @PutMapping("/updatePaymentDetails")
    public ResponseEntity<String> updatePaymentDetails(@RequestBody PaymentDto paymentDto){
        var updatedPaymentDetails = service.updatePaymentDetails(paymentDto);
        return new ResponseEntity<>(updatedPaymentDetails, HttpStatus.OK);
    }   


    @DeleteMapping("/deletePaymentById/{paymentId}")
    public ResponseEntity<String> deletePaymentById(@PathVariable String paymentId){
        var responseMessage = service.deletePaymentById(paymentId);
        return new ResponseEntity<>(responseMessage, HttpStatus.OK);
    }


    @DeleteMapping("/deleteAllPayments")
    public ResponseEntity<String> deleteAllPayments(){
        var responseMessage = service.deleteAllPayments();
        return new ResponseEntity<>(responseMessage, HttpStatus.OK);
    }

    @GetMapping("/findPaymentsByOrderId/{orderId}")
    public ResponseEntity<List<PaymentDto>> findPaymentsByOrderId(@PathVariable String orderId){
        var listOfPaymentDtos = service.findPaymentsByOrderId(orderId);
        return new ResponseEntity<>(listOfPaymentDtos, HttpStatus.OK);
    }

    @GetMapping("/findPaymentsByCustomerId/{customerId}")
    public ResponseEntity<List<PaymentDto>> findPaymentsByCustomerId(@PathVariable String customerId){
        var listOfPaymentDtos = service.findPaymentsByCustomerId(customerId);
        return new ResponseEntity<>(listOfPaymentDtos, HttpStatus.OK);
    }

    @GetMapping("/findPaymentsByAmount/{amount}")
    public ResponseEntity<List<PaymentDto>> findPaymentsByAmount(@PathVariable BigDecimal amount){
        var listOfPaymentDtos = service.findPaymentsByAmount(amount);
        return new ResponseEntity<>(listOfPaymentDtos, HttpStatus.OK);
    }

    @GetMapping("/findPaymentsByPaymentMethod/{paymentMethod}")
    public ResponseEntity<List<PaymentDto>> findPaymentsByPaymentMethod(@PathVariable String paymentMethod){
        var listOfPaymentDtos = service.findPaymentsByPaymentMethod(paymentMethod);
        return new ResponseEntity<>(listOfPaymentDtos, HttpStatus.OK);
    }

    @GetMapping("/findPaymentsByPaymentDate/{paymentDate}")
    public ResponseEntity<List<PaymentDto>> findPaymentsByPaymentDate(@PathVariable LocalDateTime paymentDate){
        var listOfPaymentDtos = service.findPaymentsByPaymentDate(paymentDate);
        return new ResponseEntity<>(listOfPaymentDtos, HttpStatus.OK);
    }





}
