package com.store.msorder.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    private final Map<String, Map<String, Object>> orderStore = new HashMap<>();

    // Create an order
    @PostMapping
    public ResponseEntity<Map<String, Object>> createOrder(@RequestBody Map<String, Object> orderData) {
        String orderId = "order-" + (orderStore.size() + 1);
        orderData.put("id", orderId);
        orderStore.put(orderId, orderData);
        return ResponseEntity.status(HttpStatus.CREATED).body(orderData);
    }

    // Get an order by ID
    @GetMapping("/{orderId}")
    public ResponseEntity<Map<String, Object>> getOrder(@PathVariable String orderId) {
        Map<String, Object> order = orderStore.get(orderId);
        if (order == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("message", "Order not found"));
        }
        return ResponseEntity.ok(order);
    }

    // Update an order by ID
    @PutMapping("/{orderId}")
    public ResponseEntity<Map<String, Object>> updateOrder(@PathVariable String orderId, @RequestBody Map<String, Object> orderUpdates) {
        Map<String, Object> existingOrder = orderStore.get(orderId);
        if (existingOrder == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("message", "Order not found"));
        }
        existingOrder.putAll(orderUpdates);
        orderStore.put(orderId, existingOrder);
        return ResponseEntity.ok(existingOrder);
    }

    // Delete an order by ID
    @DeleteMapping("/{orderId}")
    public ResponseEntity<Map<String, String>> deleteOrder(@PathVariable String orderId) {
        Map<String, Object> removedOrder = orderStore.remove(orderId);
        if (removedOrder == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("message", "Order not found"));
        }
        return ResponseEntity.ok(Map.of("message", "Order deleted successfully"));
    }

    // Get all orders
    @GetMapping
    public ResponseEntity<Map<String, Object>> getAllOrders() {
        return ResponseEntity.ok(Map.of("orders", orderStore.values()));
    }
}