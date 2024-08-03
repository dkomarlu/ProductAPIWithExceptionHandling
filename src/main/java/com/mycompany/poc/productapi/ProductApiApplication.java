package com.mycompany.poc.productapi;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Product API",
				version = "1.0.0",
				description = "This microservice exposes CRUD opertaions for Product repository",
				termsOfService = "Terms of Service",
				contact = @Contact(
						name = "Dharani Komarlu",
						email = "dkomarlu@yahoo.com"
				),
				license = @License(
						name = "licence",
						url = "eInfonetSystems.com"
				)
		)
)
public class ProductApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductApiApplication.class, args);
	}

}
