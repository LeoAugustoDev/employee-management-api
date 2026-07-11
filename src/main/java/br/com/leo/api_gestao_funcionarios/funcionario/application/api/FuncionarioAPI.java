package br.com.leo.api_gestao_funcionarios.funcionario.application.api;

import br.com.leo.api_gestao_funcionarios.funcionario.application.api.request.AtualizarFuncionarioRequest;
import br.com.leo.api_gestao_funcionarios.funcionario.application.api.request.CadastrarFuncionarioRequest;
import br.com.leo.api_gestao_funcionarios.funcionario.application.api.response.FuncionarioCriadoResponse;
import br.com.leo.api_gestao_funcionarios.funcionario.application.api.response.FuncionarioDetalhadoResponse;
import br.com.leo.api_gestao_funcionarios.funcionario.application.api.response.FuncionarioResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Tag(name = "Funcionarios", description = "Endpoints para gerenciamento de funcionarios")
@RequestMapping("/funcionarios")
public interface FuncionarioAPI {

    @Operation(summary = "Cadastrar funcionario", description = "Cadastra um novo funcionario em memoria")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Funcionario cadastrado com sucesso",
                    content = @Content(schema = @Schema(implementation = FuncionarioCriadoResponse.class))
            ),
            @ApiResponse(responseCode = "400", description = "Dados invalidos", content = @Content),
            @ApiResponse(responseCode = "409", description = "Funcionario ja existe", content = @Content)
    })
    @PostMapping
    ResponseEntity<FuncionarioCriadoResponse> cadastrar(@RequestBody CadastrarFuncionarioRequest request);

    @Operation(summary = "Listar funcionarios", description = "Lista todos os funcionarios cadastrados em memoria")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Funcionarios listados com sucesso",
                    content = @Content(array = @ArraySchema(schema = @Schema(implementation = FuncionarioResponse.class)))
            )
    })
    @GetMapping
    ResponseEntity<List<FuncionarioResponse>> listarTodos();

    @Operation(summary = "Buscar funcionario por id", description = "Busca um funcionario cadastrado pelo identificador")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Funcionario encontrado com sucesso",
                    content = @Content(schema = @Schema(implementation = FuncionarioDetalhadoResponse.class))
            ),
            @ApiResponse(responseCode = "400", description = "Id invalido", content = @Content),
            @ApiResponse(responseCode = "404", description = "Funcionario nao encontrado", content = @Content)
    })
    @GetMapping("/{id}")
    ResponseEntity<FuncionarioDetalhadoResponse> buscarPorId(
            @Parameter(description = "Identificador unico do funcionario", example = "1")
            @PathVariable Long id
    );

    @Operation(summary = "Atualizar funcionario", description = "Atualiza os dados de um funcionario cadastrado")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Funcionario atualizado com sucesso",
                    content = @Content(schema = @Schema(implementation = FuncionarioDetalhadoResponse.class))
            ),
            @ApiResponse(responseCode = "400", description = "Dados invalidos", content = @Content),
            @ApiResponse(responseCode = "404", description = "Funcionario nao encontrado", content = @Content)
    })
    @PutMapping("/{id}")
    ResponseEntity<FuncionarioDetalhadoResponse> atualizar(
            @Parameter(description = "Identificador unico do funcionario", example = "1")
            @PathVariable Long id,
            @RequestBody AtualizarFuncionarioRequest request
    );

    @Operation(summary = "Excluir funcionario", description = "Remove um funcionario cadastrado pelo identificador")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Funcionario excluido com sucesso", content = @Content),
            @ApiResponse(responseCode = "400", description = "Id invalido", content = @Content),
            @ApiResponse(responseCode = "404", description = "Funcionario nao encontrado", content = @Content)
    })
    @DeleteMapping("/{id}")
    ResponseEntity<Void> excluirPorId(
            @Parameter(description = "Identificador unico do funcionario", example = "1")
            @PathVariable Long id
    );
}
