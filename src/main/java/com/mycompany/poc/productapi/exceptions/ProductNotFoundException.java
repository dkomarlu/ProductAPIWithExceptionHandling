package com.mycompany.poc.productapi.exceptions;



public class ProductNotFoundException extends RuntimeException{

    public ProductNotFoundException() {}

    public ProductNotFoundException(Long productId) {
        super("Product not found with Id: " + productId);
    }
}
