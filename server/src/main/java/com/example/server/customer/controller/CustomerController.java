package com.example.server.customer.controller;

import com.example.server.customer.model.AllCustomers;
import com.example.server.customer.model.CustomerId;
import com.example.server.customer.model.CustomerResponse;
import com.example.server.customer.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@CrossOrigin(originPatterns = {"*localhost*", "/"})
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/getCustomers")
    public ResponseEntity<AllCustomers> getCustomers() {

        return ResponseEntity.ok(customerService.getCustomers());
    }

    @PostMapping("/getCustomer")
    public ResponseEntity<CustomerResponse> getCustomer(@RequestBody CustomerId customerId) {
        return customerService.getCustomer(customerId.getCustomerId());
    }
}
