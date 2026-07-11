package br.com.leo.api_gestao_funcionarios.funcionario.application.api;

import br.com.leo.api_gestao_funcionarios.funcionario.application.api.request.AtualizarFuncionarioRequest;
import br.com.leo.api_gestao_funcionarios.funcionario.application.api.request.CadastrarFuncionarioRequest;
import br.com.leo.api_gestao_funcionarios.funcionario.application.api.response.FuncionarioCriadoResponse;
import br.com.leo.api_gestao_funcionarios.funcionario.application.api.response.FuncionarioDetalhadoResponse;
import br.com.leo.api_gestao_funcionarios.funcionario.application.api.response.FuncionarioResponse;
import br.com.leo.api_gestao_funcionarios.funcionario.application.service.FuncionarioService;
import br.com.leo.api_gestao_funcionarios.funcionario.domain.Funcionario;
import br.com.leo.api_gestao_funcionarios.funcionario.mapper.FuncionarioMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FuncionarioController implements FuncionarioAPI {

    private final FuncionarioService funcionarioService;
    private final FuncionarioMapper funcionarioMapper;

    public FuncionarioController(
            FuncionarioService funcionarioService,
            FuncionarioMapper funcionarioMapper
    ) {
        this.funcionarioService = funcionarioService;
        this.funcionarioMapper = funcionarioMapper;
    }

    @Override
    public ResponseEntity<FuncionarioCriadoResponse> cadastrar(CadastrarFuncionarioRequest request) {
        Funcionario funcionario = funcionarioMapper.paraFuncionario(request);
        Funcionario funcionarioCadastrado = funcionarioService.cadastrar(funcionario);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(funcionarioMapper.paraCriadoResponse(funcionarioCadastrado));
    }

    @Override
    public ResponseEntity<List<FuncionarioResponse>> listarTodos() {
        List<Funcionario> funcionarios = funcionarioService.listarTodos();
        return ResponseEntity.ok(funcionarioMapper.paraResponse(funcionarios));
    }

    @Override
    public ResponseEntity<FuncionarioDetalhadoResponse> buscarPorId(Long id) {
        Funcionario funcionario = funcionarioService.buscarPorId(id);
        return ResponseEntity.ok(funcionarioMapper.paraDetalhadoResponse(funcionario));
    }

    @Override
    public ResponseEntity<FuncionarioDetalhadoResponse> atualizar(Long id, AtualizarFuncionarioRequest request) {
        Funcionario funcionario = funcionarioMapper.paraFuncionario(id, request);
        Funcionario funcionarioAtualizado = funcionarioService.atualizar(funcionario);

        return ResponseEntity.ok(funcionarioMapper.paraDetalhadoResponse(funcionarioAtualizado));
    }

    @Override
    public ResponseEntity<Void> excluirPorId(Long id) {
        funcionarioService.excluirPorId(id);
        return ResponseEntity.noContent().build();
    }
}
