package br.com.leo.api_gestao_funcionarios.funcionario.application.service;

import br.com.leo.api_gestao_funcionarios.funcionario.domain.Funcionario;

import java.util.List;

public interface FuncionarioService {

    Funcionario cadastrar(Funcionario funcionario);

    Funcionario buscarPorId(Long id);

    List<Funcionario> listarTodos();

    Funcionario atualizar(Funcionario funcionario);

    void excluirPorId(Long id);
}
