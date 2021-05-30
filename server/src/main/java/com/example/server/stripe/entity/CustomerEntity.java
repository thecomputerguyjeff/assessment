package com.example.server.stripe.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerEntity {
    private String username;
    private String firstName;
    private String lastName;
    private String password;
}
