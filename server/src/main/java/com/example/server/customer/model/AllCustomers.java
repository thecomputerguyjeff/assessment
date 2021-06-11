package com.example.server.customer.model;

import com.stripe.model.Customer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AllCustomers {
    private List<Customer> customerList;
    private int customerCount;
}
