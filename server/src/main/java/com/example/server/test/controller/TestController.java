package com.example.server.test.controller;

import com.example.server.test.model.ResponseData;
import com.example.server.test.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
@RequiredArgsConstructor
@CrossOrigin(originPatterns = {"*localhost*", "/"})
public class TestController {

    private final TestService testService;

    @GetMapping()
    public ResponseEntity<ResponseData> getTestValue() {
        return ResponseEntity.ok(testService.getTestValue());
    }
}
