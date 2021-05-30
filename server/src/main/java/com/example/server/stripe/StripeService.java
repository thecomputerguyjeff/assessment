package com.example.server.stripe;

import com.example.server.test.model.ResponseData;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Customer;
import com.stripe.model.CustomerCollection;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
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
    //still have to get the count
//    public List<ResponseData> getCustomers() {
    public Object getCustomers() {
        try {
        Map<String, Object> params = new HashMap<>();
        //params.put("limit", 100);
            CustomerCollection customers = Customer.list(params);
            return customers.toJson();
        } catch (StripeException e) {
            e.printStackTrace();
        }
        return null;
//        // deserialization
//        Customer customer = APIResource.GSON.fromJson(json, Customer.class);
//
//// serialization
//        String serialized = customer.toJson();
    }

    //TODO
    //change Object to a proper java model and remove null
    //works when the body is just the id without quotes
    public ResponseEntity getCustomer(String customerID) throws StripeException {
        ResponseEntity responseEntity;
        try {
            Customer customer = Customer.retrieve(customerID);
            responseEntity = new ResponseEntity(customer.toJson(), HttpStatus.OK);
        }
        catch (Exception e) {
            responseEntity = new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }
}

