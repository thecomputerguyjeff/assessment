//package com.example.server.stripe.service;
//
//import com.stripe.Stripe;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//
//import javax.annotation.PostConstruct;
//import java.util.List;
//
//@Service
//public class StripeService {
//
//    @Value("${stripe.secret}")
//    private String secretKey;
//
//    @PostConstruct
//    public void init() {
//        Stripe.apiKey = secretKey;
//    }
//
//    //TODO
//    //change Object to a proper java model and remove null
//    public ResponseEntity<Object> getCustomers() {
//        return customerRepository.getCustomersByOrderLastName();
//    }
//
//    //TODO
//    //change Object to a proper java model and remove null
//    public Object getCustomer(String customer) {
//        return null;
//    }
//}
//
