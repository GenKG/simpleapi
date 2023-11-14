package ru.myproject.simpleapi.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(servers = {@Server(url = "/", description = "Manage boards games")})
public class SwaggerConfig {
    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("board")
                .pathsToMatch("/api/v1/**")
                .build();
    }

    @Bean
    public OpenAPI sferaTasksOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Boards API")
                        .description("Simple api for management board games")
                        .version("v.1.0"));
    }
}
