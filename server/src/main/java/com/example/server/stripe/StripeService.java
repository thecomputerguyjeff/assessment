package com.example.server.stripe;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Customer;
import com.stripe.model.CustomerCollection;
import com.stripe.param.CustomerListParams;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

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
    public List<Customer> getCustomers() {

        String startingAfter = null;
        boolean more = true;
        List<Customer> customerList = new ArrayList<>();

        try {
            while(more) {
                CustomerListParams params = CustomerListParams.builder()
                        .setLimit(100L)
                        .setStartingAfter(startingAfter)
                        .build();
                CustomerCollection customers = Customer.list(params);
                customerList.addAll(customers.getData());
                more = customers.getHasMore();
                if (more) {
                    startingAfter = customers.getData().get(99).getId();
                }


            }
        } catch (Exception e) {
            //do nothing
        }
        return customerList;

    }

    public Customer getCustomer(String customer) throws StripeException {
        return Customer.retrieve(customer);
    }
}

