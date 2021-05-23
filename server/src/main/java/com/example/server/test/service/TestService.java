package com.example.server.test.service;

import com.example.server.test.model.ResponseData;
import org.springframework.stereotype.Service;

@Service
public class TestService {
    public ResponseData getTestValue() {
        return ResponseData.builder()
                .value("value")
                .id("id")
                .build();
    }
}
