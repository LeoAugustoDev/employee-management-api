package br.com.leo.api_gestao_funcionarios.funcionario.exception;

public class FuncionarioJaExisteException extends RuntimeException {

    public FuncionarioJaExisteException(Long id) {
        super("Funcionario com id " + id + " ja existe.");
    }
}
