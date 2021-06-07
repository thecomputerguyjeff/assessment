package com.example.server.customer.model;

import com.stripe.model.Customer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerList {
    private int customerCount;
    private List<Customer> customers;
}
