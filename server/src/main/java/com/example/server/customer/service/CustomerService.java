package com.example.server.customer.service;

import com.example.server.customer.model.AllCustomers;
import com.example.server.customer.model.CustomerId;
import com.example.server.customer.model.CustomerResponse;
import com.example.server.stripe.StripeService;
import com.stripe.model.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final StripeService stripeService;

    public AllCustomers getCustomers() {

        List<Customer> customerList = stripeService.getCustomers();

        return AllCustomers.builder()
                .customerList(customerList)
                .customerCount(customerList.size())
                .build();
    }

    public ResponseEntity<CustomerResponse> getCustomer(String customerId) {
        try {
            return ResponseEntity.ok(
                    CustomerResponse.builder()
                            .customer(stripeService.getCustomer(customerId))
                            .build());
        } catch (Exception e) {
            return new ResponseEntity<>(
                    CustomerResponse.builder()
                            .errorMessage(String.format("customer %s was not found", customerId))
                            .build()
                    , HttpStatus.NOT_FOUND);
        }


    }
}
