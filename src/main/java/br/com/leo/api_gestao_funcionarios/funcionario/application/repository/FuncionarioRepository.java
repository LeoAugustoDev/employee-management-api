package br.com.leo.api_gestao_funcionarios.funcionario.application.repository;

import br.com.leo.api_gestao_funcionarios.funcionario.domain.Funcionario;

import java.util.List;
import java.util.Optional;

public interface FuncionarioRepository {

    Funcionario salvar(Funcionario funcionario);

    Optional<Funcionario> buscarPorId(Long id);

    List<Funcionario> listarTodos();

    boolean existePorId(Long id);

    void excluirPorId(Long id);
}
