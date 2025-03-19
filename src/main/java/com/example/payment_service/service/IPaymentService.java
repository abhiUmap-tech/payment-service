package com.example.payment_service.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.example.payment_service.dto.PaymentDto;

public interface IPaymentService {

    String registerPayment(PaymentDto paymentDto);

    PaymentDto findPaymentById(String paymentId);

    List<PaymentDto> findAllPayments();

    String updatePaymentDetails(PaymentDto paymentDto);

    String deletePaymentById(String paymentId);

    String deleteAllPayments();

     List<PaymentDto> findPaymentsByOrderId(String orderId);

    List<PaymentDto> findPaymentsByCustomerId(String customerId);

    List<PaymentDto> findPaymentsByAmount(BigDecimal amount);

    List<PaymentDto> findPaymentsByPaymentMethod(String paymentMethod);

    List<PaymentDto> findPaymentsByPaymentDate(LocalDateTime paymentDate);
    



}
