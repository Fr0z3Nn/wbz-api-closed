package com.wbz.wbzapi.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Value("${api.name}")
    String nameAPI;

    @Value("${api.version}")
    String versionAPI;

    @Bean
    public OpenAPI shopApi() {
        return new OpenAPI().info(new Info()
                .title(nameAPI)
                .version(versionAPI));
    }
}
