package br.com.amauri.ControleContatosAPI.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
            .components(
                new Components().addSecuritySchemes("basicScheme",
                    new SecurityScheme().type(SecurityScheme.Type.HTTP)
                    .scheme("basic")
                )
            )
            .info(
                new Info()
                .title("App para gerenciar um sistema de cadastro de Pessoas e seus respectivos Contatos")
                .description("Este app faz o controle de cadastro de pessoas bem como o cadastro e controle "
                    + "de seus respectivos contatos.")
                .contact(new Contact()
                    .name("amauri")
                    .email("amaurijuniorcomercial@gmail.com")
                    .url("http://localhost:8080")
                )
                .version("Versão 0.0.1-SNAPSHOT")
            );
    }
}


	