package com.ssg.sb02.config;

import io.swagger.v3.oas.models.OpenAPI;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi restAPI() {
        return GroupedOpenApi.builder()
                .pathsToMatch("/api/**")
                .group("REST API")
                .build();
    }

    @Bean
    public GroupedOpenApi commonAPI() {
        return GroupedOpenApi.builder()
                .pathsToMatch("/*")
                .group("Common API")
                .build();
    }

//    @Bean
//    public OpenAPI openAPI() {
//        return new OpenAPI().info(new Info().title("SpringDoc SwaggerUI example")
//                        .description("Test SwaggerUI application")
//                        .version("v1.1"));
//    }
}
