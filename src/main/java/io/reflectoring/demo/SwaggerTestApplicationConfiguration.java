package io.reflectoring.demo;

import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.List;

/**
 * Swagger dostępny jest pod adresem http://localhost:8080/swagger-ui/index.html
 * UWAGA: Notacja @EnableSwagger2 jest przestarzała i nie jest już używana.
 */

@Configuration
public class SwaggerTestApplicationConfiguration {
    @Bean
    public OpenAPI defineOpenApi() {
        Server server = new Server();
        server.setUrl("http://localhost:8080");
        server.setDescription("Serwer testujący API");

        Contact myContact = new Contact();
        myContact.setName("Michał Sobieraj");
        myContact.setEmail("michal.sobieraj@sopim.pl");

        Info information = new Info()
                .title("System API zarządzania studentami")
                .version("1.0")
                .description("To są operacje REST API dla zarządzania studentami")
                .license(new License().name("Apache 2.0").url("http://springdoc.org"))
                .termsOfService("http://swagger.io/terms/")
                .summary("API do zarządzania studentami")
                .contact(myContact);
        return new OpenAPI().info(information).servers(List.of(server));
    }
}
