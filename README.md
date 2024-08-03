# ProductAPIWithExceptionHandling

### **To Enable Swagger2 to generate API documentation**
1. Add following mvn dependencies
   <dependency>
       <groupId>org.springdoc</groupId>
       <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
       <version>2.0.2</version>
   </dependency>

2. Add the following annotation to main application
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

3. Access swagger API documentation by visiting url
      http://localhost:8080/swagger-ui/index.html