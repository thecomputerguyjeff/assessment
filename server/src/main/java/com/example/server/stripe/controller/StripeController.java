//package com.example.server.stripe.controller;
//
//import com.example.server.stripe.service.StripeService;
//import com.example.server.test.model.ResponseData;
//import com.example.server.test.service.TestService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/api/v1")
//@RequiredArgsConstructor
//@CrossOrigin(originPatterns = {"*localhost*", "/"})
//public class StripeController {
//
//    private final StripeService stripeService;
//
//    @GetMapping("getCustomers")
//    public ResponseEntity<ResponseData> getCustomer() {
//        return ResponseEntity.ok(stripeService.getCustomer());
//    }
//}
//
