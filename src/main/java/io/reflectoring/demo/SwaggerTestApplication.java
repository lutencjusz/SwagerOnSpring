package io.reflectoring.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Swagger dostępny jest pod adresem http://localhost:8080/swagger-ui/index.html
 * UWAGA: Notacja @EnableSwagger2 jest przestarzała i nie jest już używana.
 */
@SpringBootApplication
public class SwaggerTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SwaggerTestApplication.class, args);
	}

}
