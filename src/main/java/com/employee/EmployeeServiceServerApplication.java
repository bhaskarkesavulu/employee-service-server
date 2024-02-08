package com.employee;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "Employee Service Server",
                version = "1.0.0",
                description = "It's an Employee service where we can store, get and delete employee details with update",
                termsOfService = "Java Technologies",
                contact = @Contact(
                        name = "Bhaskar K",
                        email = "bhaskar.kesavulu@gmail.com"
                ),
                license = @License(
                        name = "Kavya Bhaskar",
                        url = "http://localhost:2026/swagger-ui/index.html#/"
                )
        )
)
public class EmployeeServiceServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeServiceServerApplication.class, args);
    }

}
