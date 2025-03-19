package com.example.payment_service.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import com.example.payment_service.dto.PaymentDto;
import com.example.payment_service.entity.Payment;
import com.example.payment_service.exceptions.AmountNotFoundException;
import com.example.payment_service.exceptions.CustomerIdNotFoundException;
import com.example.payment_service.exceptions.OrderIdNotFoundException;
import com.example.payment_service.exceptions.PaymentDateNotFoundException;
import com.example.payment_service.exceptions.PaymentDtoNullException;
import com.example.payment_service.exceptions.PaymentMethodNotFoundException;
import com.example.payment_service.exceptions.PaymentNotFoundException;
import com.example.payment_service.repository.PaymentReposotiry;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements IPaymentService {

    private final ModelMapper modelMapper;
    private final PaymentReposotiry repo;

    @Override
    public String registerPayment(PaymentDto paymentDto) {
        return Optional.ofNullable(paymentDto)
                .map(dto -> {
                    // Convert the DTO to entity
                    var payment = modelMapper.map(dto, Payment.class);
                    // save the details to repo
                    var savedPayment = repo.save(payment);
                    return "Payment registered successfully with the ID::" + savedPayment.getPaymentId();
                })
                .orElseThrow(() -> new PaymentDtoNullException("Payment Dto cannot be null or empty"));

    }

    @Override
    public PaymentDto findPaymentById(String paymentId) {
        var paymentDetails = repo.findById(paymentId)
                .orElseThrow(
                        () -> new PaymentNotFoundException("Payment Not Found for the given payment Id::" + paymentId));
        return modelMapper.map(paymentDetails, PaymentDto.class);
    }

    @Override
    public List<PaymentDto> findAllPayments() {
        var listOfPayments = repo.findAll();
        return listOfPayments.stream()
                .map(payment -> modelMapper.map(payment, PaymentDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public String updatePaymentDetails(PaymentDto paymentDto) {
        return Optional.ofNullable(paymentDto)
                .map(dto -> {
                    // Convert the Dto to entity
                    var updatedDetails = modelMapper.map(dto, Payment.class);
                    // save the updated details to repo
                    repo.save(updatedDetails);
                    // return a success message
                    return "Payment details updated successfully for the ID::" + updatedDetails.getPaymentId();
                })
                .orElseThrow(() -> new PaymentDtoNullException("Payment Dto cannot be Null or Empty"));
    }

    @Override
    public String deletePaymentById(String paymentId) {
        var paymentDetails = repo.findById(paymentId)
                .orElseThrow(
                        () -> new PaymentNotFoundException("No Payment details found for the given Id::" + paymentId));
        repo.deleteById(paymentDetails.getPaymentId());
        return "Payment details deleted successfully for the Id::" + paymentId;
    }

    @Override
    public String deleteAllPayments() {
        repo.deleteAll();
        return "All payment details deleted successfully";
    }

    @Override
    public List<PaymentDto> findPaymentsByOrderId(String orderId) {
        return Optional.of(repo.findByOrderId(orderId))
                // Filter to check whether the list of payments is not empty
                .filter(payment -> !payment.isEmpty())
                // Throw custom exception if no payments are found
                .orElseThrow(() -> new OrderIdNotFoundException("No payments found for the given order id::" + orderId))
                // If the payment are found stream it
                .stream()
                // Map each payment to a dto
                .map(payment -> modelMapper.map(payment, PaymentDto.class))
                // Collect it as a List
                .collect(Collectors.toList());
    }

    @Override
    public List<PaymentDto> findPaymentsByCustomerId(String customerId) {
        return Optional.of(repo.findByCustomerId(customerId))
                // Filter to check whether the List of Payments is empty or not
                .filter(payment -> !payment.isEmpty())
                // Or Else throw new custom exception
                .orElseThrow(() -> new CustomerIdNotFoundException(
                        "No payments found for the given Customer ID::" + customerId))
                // If the payment details are present then stream the list
                .stream()
                // Map each payment details to a Dto
                .map(payment -> modelMapper.map(payment, PaymentDto.class))
                // Collect the details in a list
                .collect(Collectors.toList());
    }

    @Override
    public List<PaymentDto> findPaymentsByAmount(BigDecimal amount) {
        return Optional.of(repo.findByAmount(amount))
                .filter(payment -> !payment.isEmpty())
                .orElseThrow(() -> new AmountNotFoundException("No payments found for the given amount::" + amount))
                .stream()
                .map(payment -> modelMapper.map(payment, PaymentDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<PaymentDto> findPaymentsByPaymentMethod(String paymentMethod) {
        return Optional.of(repo.findByPaymentMethod(paymentMethod))
                .filter(payment -> !payment.isEmpty())
                .orElseThrow(() -> new PaymentMethodNotFoundException(
                        "No payments found for the payment method::" + paymentMethod))
                .stream()
                .map(payment -> modelMapper.map(payment, PaymentDto.class))
                .collect(Collectors.toList());

    }

    @Override
    public List<PaymentDto> findPaymentsByPaymentDate(LocalDateTime paymentDate) {
        return Optional.of(repo.findByPaymentDate(paymentDate))
                .filter(payment -> !payment.isEmpty())
                .orElseThrow(() -> new PaymentDateNotFoundException(
                        "No payments found for the payment date::" + paymentDate))
                .stream()
                .map(payment -> modelMapper.map(payment, PaymentDto.class))
                .collect(Collectors.toList());

    }

}
