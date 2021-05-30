package com.example.server.stripe.service;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.BalanceTransaction;
import com.stripe.model.BalanceTransactionCollection;
import com.stripe.model.Customer;
import com.stripe.model.CustomerCollection;
import com.stripe.param.BalanceTransactionListParams;
import com.stripe.param.CustomerListParams;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static javax.security.auth.callback.ConfirmationCallback.OK;
@Service
@RequiredArgsConstructor
public class StripeService {

    @Value("${stripe.secret}")
    private String secretKey;

    @PostConstruct
    public void init() {
        Stripe.apiKey = secretKey;
    }

    //TODO
    //change Object to a proper java model and remove null
    public List<Customer> getCustomers() throws StripeException{
        List<Customer> customerList = new ArrayList<>();
        String current = null;
        boolean more = true;
        while(more){
            CustomerListParams customerListParams = CustomerListParams.builder()
                    .setLimit(5L)
                    .setStartingAfter(current)
                    .build();
            CustomerCollection customers = Customer.list(customerListParams);
            customerList.addAll(customers.getData());
            if(!customers.getHasMore()){
                more = false;

            }else {
                current = customers.getData().get(4).getId();

            }


        }
        return customerList;



    }


    //TODO
    //change Object to a proper java model and remove null
    public Object getCustomer(String customer) {
        return null;
    }
}

