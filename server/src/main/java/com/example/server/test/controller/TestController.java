package com.example.server.test.controller;

import com.example.server.stripe.StripeService;
import com.example.server.test.model.ResponseData;
import com.example.server.test.service.TestService;
import com.stripe.exception.StripeException;
import com.stripe.model.CustomerCollection;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@CrossOrigin(originPatterns = {"*localhost*", "/"})
public class TestController {

    private final StripeService stripeService;

    @GetMapping("/getCustomers")
    public ResponseEntity<Object> getCustomers() {
        return ResponseEntity.ok(stripeService.getCustomers());
    }

    @PostMapping("/getCustomer")
    public ResponseEntity<Object> getCustomer(@RequestBody String customerID) throws StripeException {
        return ResponseEntity.ok(stripeService.getCustomer(customerID));
    }
}
