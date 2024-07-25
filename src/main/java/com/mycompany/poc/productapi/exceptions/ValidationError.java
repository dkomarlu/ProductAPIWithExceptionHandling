package com.mycompany.poc.productapi.exceptions;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ValidationError {
    private final String field;
    private final String message;
}
