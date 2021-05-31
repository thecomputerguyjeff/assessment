package com.example.server.controller;

import com.example.server.model.CustomerInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RequiredArgsConstructor
@RestController
public class CustomerController {
    @RequestMapping("/api/v1")
    @GetMapping("/CustomerName")
    public String getCustomerName(@RequestBody CustomerInfo userInfo) {
        return "CustomerName";
    }
    @GetMapping("/CustomerId")
    public Object getCustomerId() {
        return "CustomerId";
    }
}
