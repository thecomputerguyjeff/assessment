package com.example.server.controller;
import com.example.server.model.CustomerInfo;
import com.stripe.exception.StripeException;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin(originPatterns = {"*localhost*", "/"})
@RequestMapping("/api/v1")
public class CustomerController {
    private final CustomerInfo customerInfo;

    @GetMapping("/Customers")
    public List<Object> getCustomers() throws StripeException {
        return customerInfo.getCustomers();
    }
}