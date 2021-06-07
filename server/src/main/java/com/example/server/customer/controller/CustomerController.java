package com.example.server.customer.controller;

import com.example.server.customer.model.CustomerList;
import com.example.server.customer.service.CustomerService;
import com.stripe.exception.StripeException;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@CrossOrigin(originPatterns = {"*localhost*", "/"})
@RequestMapping("/api/v1")
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping("/getCustomers")
    public CustomerList getCustomers() throws StripeException {
        return customerService.getCustomers();
    }

    @PostMapping("/getCustomer")
    public Object getCustomer() {
        return customerService.getCustomer();
    }
}