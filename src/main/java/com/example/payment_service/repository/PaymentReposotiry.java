package com.example.payment_service.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.payment_service.entity.Payment;
import java.util.List;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface PaymentReposotiry extends MongoRepository<Payment, String>{

    List<Payment> findByOrderId(String orderId);

    List<Payment> findByCustomerId(String customerId);

    List<Payment> findByAmount(BigDecimal amount);

    List<Payment> findByPaymentMethod(String paymentMethod);

    List<Payment> findByPaymentDate(LocalDateTime paymentDate);
    


}
