package com.kairos.midelware.config;

import com.kairos.midelware.constants.ApiValues;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;

@Configuration
@RequiredArgsConstructor
public class SwaggerConfig {

    private final ApiValues apiValues;
    @Bean
    public OpenAPI springShopOpenAPI() {
        final String securitySchemeName = "Authorization";
        return new OpenAPI()
                .addSecurityItem(new SecurityRequirement().addList(securitySchemeName))
                .components(
                        new Components()
                                .addSecuritySchemes(securitySchemeName,
                                        new SecurityScheme()
                                                .name(securitySchemeName)
                                                .type(SecurityScheme.Type.HTTP)
                                                .scheme("bearer")
                                                .bearerFormat("JWT")))
                .info(new Info().title(apiValues.getTitle())
                        .description(apiValues.getDescription())
                        .version(apiValues.getVersion())
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")))
                .addServersItem(server());
    }

    private Server server(){
        return new Server()
                .description("Generated server url")
                .url(apiValues.getUrlServer());
    }
}
