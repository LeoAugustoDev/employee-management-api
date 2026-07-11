package br.com.leo.api_gestao_funcionarios.funcionario.application.api.response;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Resposta do cadastro de funcionario")
public record FuncionarioCriadoResponse(

        @Schema(description = "Identificador unico do funcionario criado", example = "1")
        Long id,

        @Schema(description = "Mensagem de confirmacao do cadastro", example = "Funcionario cadastrado com sucesso.")
        String mensagem
) {
}
