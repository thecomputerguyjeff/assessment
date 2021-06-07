package com.example.server.customer.service;

import com.example.server.customer.model.CustomerList;
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
    public CustomerList getCustomers() throws StripeException {

        Stripe.apiKey = "sk_test_51If5WfAvUyzs1dkX4OidydSPFFj4acLAx3zgZ3l2qKy08P0cHuGG5zuhuPL4rOv9mkZAnhgSyogqX2C8hHX5gZ4Q00dLcKGpqB";
        List<Customer> customerList = new ArrayList<>();
        int numberOfCustomers = 0;
        String currentRecord = null;
        boolean moreRecords = true;

        while (moreRecords) {

            CustomerListParams customerListParams = CustomerListParams
                    .builder()
                    .setLimit(20L)
                    .setStartingAfter(currentRecord)
                    .build();

            CustomerCollection customerCollection = Customer.list(customerListParams);
            customerList.addAll(customerCollection.getData());

            if (!customerCollection.getHasMore()) {
                moreRecords = false;
            } else {
                currentRecord = customerCollection.getData().get(19).getId();
            }
        }

        if (!customerList.isEmpty()) {
            numberOfCustomers = customerList.size();
        }

        return CustomerList
                .builder()
                .customerCount(numberOfCustomers)
                .customers(customerList)
                .build();
    }

    public Object getCustomer() {
        return null;
    }
}