package com.example.LoginSystem;

import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
        info = @Info(
                title="Login System API",
                version = "v1.0",
                description = "This API will accept email and password and authenticate users "
        ),
        servers = {@Server(
                url = "http://localhost:8080/LoginSystemAPI",
                description = "This API is deployed on following url"
        )
        }

)
@SpringBootApplication
public class LoginSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoginSystemApplication.class, args);

	}

}
