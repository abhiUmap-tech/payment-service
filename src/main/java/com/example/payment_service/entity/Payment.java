package com.example.payment_service.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "payment")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {

    // Unique identifier for the payment
    @Id
    private String paymentId;

    // The order ID this payment is associated with
    private String orderId;

    // The customer ID making the payment
    private String customerId;

    // The total amount of the payment
    private BigDecimal amount;

    // The payment method used (e.g., Credit Card, PayPal, etc.)
    private String paymentMethod;

    // The status of the payment (e.g., SUCCESS, PENDING, FAILED)
    private String paymentStatus;

    // The timestamp of when the payment was initiated
    private LocalDateTime paymentDate;

    // Additional details related to the payment (optional)
    private String paymentDetails;

    // Currency in which the payment is made
    private String currency;

    // Indicates whether the payment is refundable
    private Boolean isRefundable;

}
