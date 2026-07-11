package br.com.leo.api_gestao_funcionarios.funcionario.application.api.response;

import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;

@Schema(description = "Resposta resumida com dados do funcionario")
public record FuncionarioResponse(

        @Schema(description = "Identificador unico do funcionario", example = "1")
        Long id,

        @Schema(description = "Nome do funcionario", example = "Leonardo Almeida")
        String nome,

        @Schema(description = "Cargo do funcionario", example = "Desenvolvedor Backend")
        String cargo,

        @Schema(description = "Salario do funcionario", example = "8500.00")
        BigDecimal salario
) {
}
