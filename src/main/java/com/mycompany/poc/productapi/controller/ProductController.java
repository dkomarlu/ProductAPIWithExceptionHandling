package com.mycompany.poc.productapi.controller;


import com.mycompany.poc.productapi.dto.Product;
import com.mycompany.poc.productapi.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    //Get all Products
    @GetMapping
    public ResponseEntity<List<Product>> getProducts() {
        List<Product> products = productService.getProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
    //Get a Product
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable Long id) {
        Product product = productService.getProduct(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    //Insert a product
    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody  Product product)  {
        Product newProduct = productService.addProduct(product);
        return new ResponseEntity<>(newProduct, HttpStatus.ACCEPTED);
    }

    //Update a Product
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@Valid @RequestBody  Product product, @PathVariable Long id)  {
        Product newProduct = productService.updateProduct(product, id);
        return new ResponseEntity<>(newProduct, HttpStatus.ACCEPTED);
    }

    //Delete a Product
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>("Product is delete.", HttpStatus.OK);
    }
}
