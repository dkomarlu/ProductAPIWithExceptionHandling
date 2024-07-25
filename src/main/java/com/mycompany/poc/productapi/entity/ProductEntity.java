package com.mycompany.poc.productapi.entity;

import jakarta.persistence.*;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="product")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 50, message = "Name can not exeed 50 characters.")
    @Column(name="name")
    private String name;

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 50, message = "upcCode can not exeed 50 characters.")
    @Column(name="upc_code")
    private String upcCode;

    @NotNull
    @Range(min=1, max=10000, message = "Price shuld be between 1.00 to 10000.00")
    @Column(name="price")
    private BigDecimal price;

}
