package com.mycompany.poc.productapi.service;

import com.mycompany.poc.productapi.dto.Product;
import com.mycompany.poc.productapi.entity.ProductEntity;
import com.mycompany.poc.productapi.exceptions.DuplicateProductException;
import com.mycompany.poc.productapi.exceptions.ProductNotFoundException;
import com.mycompany.poc.productapi.repository.ProductRepository;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;


    public List<Product> getProducts() {
        List<ProductEntity> productEntities = productRepository.findAll();
        return productEntities
                .stream()
                .map(pe -> modelMapper.map(pe, Product.class))
                .toList();
    }

    public Product getProduct(Long id) {
        ProductEntity productEntity = productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
        return modelMapper.map(productEntity, Product.class);
    }

    public Product addProduct(Product product) {
        ProductEntity productEntity = productRepository.findByUpcCode(product.getUpcCode());
        if (productEntity != null) {
            throw new DuplicateProductException(product.getUpcCode());
        }
        productEntity = modelMapper.map(product, ProductEntity.class);
        productEntity = productRepository.save(productEntity);
        return  modelMapper.map(productEntity, Product.class);
    }

    public Product updateProduct(Product product, Long id) {
        ProductEntity productEntity = productRepository.findByUpcCode(product.getUpcCode());
        if ((productEntity != null) && (!productEntity.getId().equals(id))) {
            throw new DuplicateProductException(product.getUpcCode());
        }
        productEntity = productRepository.findById(id).orElseThrow(() ->new ProductNotFoundException(id));
        productEntity.setName(product.getName());
        productEntity.setUpcCode(product.getUpcCode());
        productEntity.setPrice(product.getPrice());
        productRepository.save(productEntity);
        product.setId(id);
        return product;
    }

    public void deleteProduct(Long id) {
        ProductEntity productEntity = productRepository.findById(id).orElseThrow(() ->new ProductNotFoundException(id));
        productRepository.delete(productEntity);
    }

    public Product findProduct(Long id) {
        ProductEntity pe = productRepository.findById(id).orElseThrow(ProductNotFoundException::new);
        return modelMapper.map(pe, Product.class);
    }
}
