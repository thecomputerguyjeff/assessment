package com.example.server.customer.service;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Customer;
import com.stripe.model.CustomerCollection;
import com.stripe.param.CustomerListParams;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {
    public List<Object> getCustomers() throws StripeException {


    List<Customer> customerList = new ArrayList<>();
        String current = null;
        Boolean more = true;

        Stripe.apiKey = "sk_test_51If5WfAvUyzs1dkX4OidydSPFFj4acLAx3zgZ3l2qKy08P0cHuGG5zuhuPL4rOv9mkZAnhgSyogqX2C8hHX5gZ4Q00dLcKGpqB";

        while (more){
            CustomerListParams customerListParams = CustomerListParams.builder()
                    .setLimit(5l)
                    .setStartingAfter(current)
                    .build();

            CustomerCollection customerCollection = Customer.list(customerListParams);

            customerList.addAll(customerCollection.getData());

            if(!customerCollection.getHasMore()){
                more = false;
            }
            else {
                current = customerCollection.getData().get(4).getId();
            }
        }

        List<Object> allCustomers = new ArrayList<Object>();
        allCustomers.add(customerList.size());
        allCustomers.add(customerList);
            return allCustomers;
        }
    }