package com.example.server.customer.controller;

import com.example.server.customer.service.CustomerService;
import com.stripe.exception.StripeException;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin(originPatterns = {"*localhost*", "/"})
@RequestMapping("/api/v1")
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping("/getCustomers")
    public List<Object> getCustomers() throws StripeException {
        return customerService.getCustomers();
    }
}
