package br.com.leo.api_gestao_funcionarios.funcionario.application.api.request;

import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;

@Schema(description = "Dados para cadastro de funcionario")
public record CadastrarFuncionarioRequest(

        @Schema(description = "Identificador unico do funcionario", example = "1")
        Long id,

        @Schema(description = "Nome do funcionario", example = "Leonardo Almeida")
        String nome,

        @Schema(description = "Cargo do funcionario", example = "Desenvolvedor Backend")
        String cargo,

        @Schema(description = "Salario do funcionario", example = "8500.00")
        BigDecimal salario,

        @Schema(description = "Telefone do funcionario", example = "11999999999")
        String telefone,

        @Schema(description = "Endereco do funcionario", example = "Rua das Flores, 123")
        String endereco
) {
}
