package com.backend.store.controllers;

import com.backend.store.services.models.Product;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    // Création du logger
    private static final Logger logger = LogManager.getLogger(ProductController.class);

    private final List<Product> products = new ArrayList<>();

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        logger.info("GET /api/products - Fetching all products");

        if (products.isEmpty()) {
            logger.info("No products found, adding sample products.");
            products.add(new Product("1", "T-shirt", 15.99));
            products.add(new Product("2", "Sneakers", 49.99));
            products.add(new Product("3", "Hat", 12.99));
        }

        logger.info("Returning list of products: {}", products);
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable String id) {
        logger.info("GET /api/products/{} - Fetching product by ID", id);

        Optional<Product> product = products.stream()
                .filter(p -> p.id().equals(id))
                .findFirst();

        if (product.isPresent()) {
            logger.info("Product found: {}", product.get());
            return ResponseEntity.ok(product.get());
        } else {
            logger.error("Product with ID {} not found", id);
            return ResponseEntity.status(404).body(null);
        }
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        logger.info("POST /api/products - Creating new product: {}", product);

        products.add(product);
        logger.info("Product created successfully: {}", product);
        return ResponseEntity.status(201).body(product);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable String id, @RequestBody Product product) {
        logger.info("PUT /api/products/{} - Updating product with ID {}", id, product);

        Optional<Product> existingProductOpt = products.stream()
                .filter(p -> p.id().equals(id))
                .findFirst();

        if (existingProductOpt.isPresent()) {
            Product existingProduct = existingProductOpt.get();
            existingProduct = new Product(existingProduct.id(), product.name(), product.price());
            products.remove(existingProductOpt.get());
            products.add(existingProduct);

            logger.info("Product updated successfully: {}", existingProduct);
            return ResponseEntity.ok(existingProduct);
        } else {
            logger.error("Product with ID {} not found for update", id);
            return ResponseEntity.status(404).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable String id) {
        logger.info("DELETE /api/products/{} - Deleting product with ID {}", id, id);

        Optional<Product> product = products.stream()
                .filter(p -> p.id().equals(id))
                .findFirst();

        if (product.isPresent()) {
            products.remove(product.get());
            logger.info("Product with ID {} deleted successfully", id);
            return ResponseEntity.ok("Product with ID " + id + " deleted successfully.");
        } else {
            logger.error("Product with ID {} not found for deletion", id);
            return ResponseEntity.status(404).body("Product not found");
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Product> partialUpdateProduct(@PathVariable String id, @RequestBody Product product) {
        logger.info("PATCH /api/products/{} - Partially updating product with ID {}", id, id);

        Optional<Product> existingProductOpt = products.stream()
                .filter(p -> p.id().equals(id))
                .findFirst();

        if (existingProductOpt.isPresent()) {
            Product existingProduct = existingProductOpt.get();

            // Mise à jour conditionnelle des champs
            existingProduct = new Product(existingProduct.id(),
                    product.name() != null ? product.name() : existingProduct.name(),
                    product.price() != 0 ? product.price() : existingProduct.price());

            products.remove(existingProductOpt.get());
            products.add(existingProduct);

            logger.info("Product partially updated successfully: {}", existingProduct);
            return ResponseEntity.ok(existingProduct);
        } else {
            logger.error("Product with ID {} not found for partial update", id);
            return ResponseEntity.status(404).body(null);
        }
    }
}
