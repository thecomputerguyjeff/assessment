package com.example.server.customer.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.stripe.model.Customer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomerResponse {
    private Customer customer;
    private String errorMessage;
}
