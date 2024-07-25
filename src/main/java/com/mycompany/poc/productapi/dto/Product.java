package com.mycompany.poc.productapi.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.validator.constraints.Range;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private Long id;

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 50, message = "Name can not exceed 50 characters.")
    private String name;

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 50, message = "upcCode can not exceed 50 characters.")
    private String upcCode;

    @NotNull
    @Range(min=1, max=10000)
    private BigDecimal price;
}
