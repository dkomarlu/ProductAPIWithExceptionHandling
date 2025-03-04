#  Stage 1:  Build Stage
FROM maven:3.8.4-openjdk-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean install

#Stage 2:  Run the application
FROM maven:3.8.4-openjdk-17
WORKDIR /app
COPY --from=build /app/target/ProductAPI-0.0.1-SNAPSHOT.jar ./productAPI-aws.jar
EXPOSE 8080
CMD ["java", "-jar", "productAPI-aws.jar"]