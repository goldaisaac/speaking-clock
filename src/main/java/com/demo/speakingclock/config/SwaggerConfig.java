package com.demo.speakingclock.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    // Configuration bean that sets up Swagger documentation
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                // Specify the base package where controllers are located
                .apis(RequestHandlerSelectors.basePackage("com.demo.speakingclock"))
                // Specify the paths to include in the documentation using a regular expression
                .paths(PathSelectors.regex("/.*"))
                .build()
                // Set the API information using the apiInfo() method
                .apiInfo(apiInfo());
    }

    // Creates an ApiInfo object to provide API information for Swagger UI
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                // Set the title of the API documentation
                .title("Speaking Clock API Documentation")
                // Set a description for the API documentation
                .description("API documentation for the Speaking Clock application")
                // Set the version of the API
                .version("1.0.0")
                .build();
    }
}