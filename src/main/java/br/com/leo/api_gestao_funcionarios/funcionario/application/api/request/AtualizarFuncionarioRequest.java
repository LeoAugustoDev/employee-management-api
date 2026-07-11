package br.com.leo.api_gestao_funcionarios.funcionario.application.api.request;

import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;

@Schema(description = "Dados para atualizacao de funcionario")
public record AtualizarFuncionarioRequest(

        @Schema(description = "Nome do funcionario", example = "Leonardo Almeida")
        String nome,

        @Schema(description = "Cargo do funcionario", example = "Arquiteto de Software")
        String cargo,

        @Schema(description = "Salario do funcionario", example = "12000.00")
        BigDecimal salario,

        @Schema(description = "Telefone do funcionario", example = "11988888888")
        String telefone,

        @Schema(description = "Endereco do funcionario", example = "Avenida Paulista, 1000")
        String endereco
) {
}
