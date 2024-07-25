package com.mycompany.poc.productapi.repository;

import com.mycompany.poc.productapi.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    ProductEntity findByUpcCode(String upcDoe);
}
