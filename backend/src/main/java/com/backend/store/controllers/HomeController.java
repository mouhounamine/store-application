package com.backend.store.controllers;

import com.backend.store.services.models.GreetingRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeController {

    @PostMapping("/greet")
    public ResponseEntity<String> greet(@RequestBody GreetingRequest greetingRequest) {
        String responseMessage = "Hello " + greetingRequest.name() + "! " + greetingRequest.message();
        return ResponseEntity.ok(responseMessage);
    }
}
