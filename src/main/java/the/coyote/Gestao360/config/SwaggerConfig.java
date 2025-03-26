package the.coyote.Gestao360.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Gestão 360 API")
                        .version("1.0.0")
                        .description("Sistema de gestão completo para empresas e lojas.")
                        .license(new License().name("Apache 2.0").url("https://springdoc.org")));
    }
}