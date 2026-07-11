package br.com.leo.api_gestao_funcionarios.funcionario.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI apiGestaoFuncionariosOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API Gestao de Funcionarios")
                        .description("API REST para gerenciamento de funcionarios com persistencia em memoria")
                        .version("1.0.0"));
    }
}
