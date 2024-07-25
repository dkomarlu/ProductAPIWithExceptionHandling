package com.mycompany.poc.productapi.exceptions;



public class DuplicateProductException extends RuntimeException{

    public DuplicateProductException() {}

    public DuplicateProductException(String upcCode) {
        super("Product already exist with upcCode : " + upcCode);
    }
}
