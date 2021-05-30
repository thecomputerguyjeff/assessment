package com.example.server.stripe.controller;

import com.example.server.stripe.service.StripeService;
import com.stripe.exception.StripeException;
import com.stripe.model.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(originPatterns = {"*localhost*", "/"})
@RequestMapping("api/v1")
public class StripeController
{
    private final StripeService stripeService;

    @GetMapping("/getCustomers")
    public Object getCustomers() throws StripeException {
        return stripeService.getCustomers();
    }
}