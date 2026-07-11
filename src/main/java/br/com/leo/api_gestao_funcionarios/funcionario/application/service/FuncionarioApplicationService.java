package br.com.leo.api_gestao_funcionarios.funcionario.application.service;

import br.com.leo.api_gestao_funcionarios.funcionario.application.repository.FuncionarioRepository;
import br.com.leo.api_gestao_funcionarios.funcionario.domain.Funcionario;
import br.com.leo.api_gestao_funcionarios.funcionario.exception.FuncionarioJaExisteException;
import br.com.leo.api_gestao_funcionarios.funcionario.exception.FuncionarioNaoEncontradoException;
import br.com.leo.api_gestao_funcionarios.funcionario.validator.FuncionarioValidator;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioApplicationService implements FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;
    private final FuncionarioValidator funcionarioValidator;

    public FuncionarioApplicationService(
            FuncionarioRepository funcionarioRepository,
            FuncionarioValidator funcionarioValidator
    ) {
        this.funcionarioRepository = funcionarioRepository;
        this.funcionarioValidator = funcionarioValidator;
    }

    @Override
    public Funcionario cadastrar(Funcionario funcionario) {
        funcionarioValidator.validarCadastro(funcionario);

        if (funcionarioRepository.existePorId(funcionario.getId())) {
            throw new FuncionarioJaExisteException(funcionario.getId());
        }

        return funcionarioRepository.salvar(funcionario);
    }

    @Override
    public Funcionario buscarPorId(Long id) {
        funcionarioValidator.validarId(id);
        return buscarFuncionarioPorId(id);
    }

    @Override
    public List<Funcionario> listarTodos() {
        return funcionarioRepository.listarTodos();
    }

    @Override
    public Funcionario atualizar(Funcionario funcionario) {
        funcionarioValidator.validarAtualizacao(funcionario);
        buscarFuncionarioPorId(funcionario.getId());

        return funcionarioRepository.salvar(funcionario);
    }

    @Override
    public void excluirPorId(Long id) {
        funcionarioValidator.validarId(id);
        buscarFuncionarioPorId(id);

        funcionarioRepository.excluirPorId(id);
    }

    private Funcionario buscarFuncionarioPorId(Long id) {
        return funcionarioRepository.buscarPorId(id)
                .orElseThrow(() -> new FuncionarioNaoEncontradoException(id));
    }
}
