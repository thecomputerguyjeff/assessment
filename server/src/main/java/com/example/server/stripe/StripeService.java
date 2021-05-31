package com.example.server.stripe;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Customer;
import com.stripe.model.CustomerCollection;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

@Service
public class StripeService {

    @Value("${stripe.secret}")
    private String secretKey;

    @PostConstruct
    public void init() {
        Stripe.apiKey = secretKey;
    }



    //TODO
    //change Object to a proper java model and remove null
    public Object getCustomer() {
        try{
            Map<String, Object> params = new HashMap<>();
            CustomerCollection customers = customer().list(params);
            return customers.toJson();
        }catch (StripeException e){
            e.printStackTrace();
        }
        return null;
    }

    private Component customer() {
        return null;
    }

    public ResponseEntity getCustomer(String customerId) throws StripeException{
    ResponseEntity responseEntity;
    try {
        Customer customer = Customer.retrieve(customerId);
        responseEntity = new ResponseEntity(customer.toJson(), HttpStatus.OK);
    }
    catch (Exception e){
        responseEntity = new ResponseEntity(HttpStatus.NOT_FOUND);
    }
    return responseEntity;
   }
}

