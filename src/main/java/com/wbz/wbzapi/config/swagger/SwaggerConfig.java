package com.wbz.wbzapi.config.swagger;

import io.swagger.v3.core.util.Constants;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;

@Configuration
public class SwaggerConfig {
    @Value("${api.name}")
    String nameAPI;

    @Value("${api.version}")
    String versionAPI;


    private static final String API_AUTHORIZATION_KEY = "Authorization";

    @Bean
    public OpenAPI shopApi() {
        return new OpenAPI()
                .components(new Components().addSecuritySchemes("Authorization",apiTokenSecuritySchema()))
                .info(new Info()
                .title(nameAPI)
                .version(versionAPI))
                .security(Collections.singletonList(new SecurityRequirement().addList(API_AUTHORIZATION_KEY)));
    }

    public SecurityScheme apiTokenSecuritySchema(){
        return new SecurityScheme()
                .name("AUTHORISATION_TOKEN")
                .description("Description about the TOKEN")
                .in(SecurityScheme.In.HEADER)
                .type(SecurityScheme.Type.APIKEY);
    }
}
