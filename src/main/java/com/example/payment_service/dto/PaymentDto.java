package com.example.payment_service.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDto {

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

    // Indicates whether the payment is refundable
    private Boolean isRefundable;

}
