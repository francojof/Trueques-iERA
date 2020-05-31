package com.taktika.iera.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

/**
 * Cristian Gómez, Brandon Sepulveda, Franco Jofré,
 * José Valenzuela, Luis San Martin, Alejandro Valencia,
 * Kevin Nuñez. (FORGE)
 * cristiang.contacto@gmail.com
 */

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.ant("/api/**"))
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "API iera",
                "Barter Service",
                "v1.0",
                "Terms of service",
                new Contact("Cristian Gómez","", "cristiang.contacto@gmail.com"),
                "License of API", "API license URL", Collections.emptyList());
    }
}


//  http://localhost:8090/swagger-ui.html
// https://vladmihalcea.com/a-beginners-guide-to-jpa-and-hibernate-cascade-types/
