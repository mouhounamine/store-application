package com.backend.store.controllers;

import com.backend.store.services.models.GreetingRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/home")
public class HomeController {

    @PostMapping("/greeting")
    public ResponseEntity<String> greet(@RequestBody GreetingRequest greetingRequest) {
        String responseMessage = "Hello " + greetingRequest.name() + "! " + greetingRequest.message();
        return ResponseEntity.ok(responseMessage);
    }

    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        String responseMessage = "Hello ! ";
        return ResponseEntity.ok(responseMessage);
    }
}
