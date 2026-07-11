package br.com.leo.api_gestao_funcionarios.funcionario.exception;

public class FuncionarioNaoEncontradoException extends RuntimeException {

    public FuncionarioNaoEncontradoException(Long id) {
        super("Funcionario com id " + id + " nao encontrado.");
    }
}
