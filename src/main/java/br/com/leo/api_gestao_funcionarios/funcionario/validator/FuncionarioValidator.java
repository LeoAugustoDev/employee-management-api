package br.com.leo.api_gestao_funcionarios.funcionario.validator;

import br.com.leo.api_gestao_funcionarios.funcionario.domain.Funcionario;
import br.com.leo.api_gestao_funcionarios.funcionario.exception.ValidacaoException;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class FuncionarioValidator {

    public void validarCadastro(Funcionario funcionario) {
        validarFuncionario(funcionario);
        validarId(funcionario.getId());
        validarCamposObrigatorios(funcionario);
    }

    public void validarAtualizacao(Funcionario funcionario) {
        validarFuncionario(funcionario);
        validarId(funcionario.getId());
        validarCamposObrigatorios(funcionario);
    }

    public void validarId(Long id) {
        if (id == null) {
            throw new ValidacaoException("Id obrigatorio.");
        }

        if (id <= 0) {
            throw new ValidacaoException("Id deve ser maior que zero.");
        }
    }

    private void validarFuncionario(Funcionario funcionario) {
        if (funcionario == null) {
            throw new ValidacaoException("Funcionario obrigatorio.");
        }
    }

    private void validarCamposObrigatorios(Funcionario funcionario) {
        validarTexto(funcionario.getNome(), "Nome obrigatorio.");
        validarTexto(funcionario.getCargo(), "Cargo obrigatorio.");
        validarSalario(funcionario.getSalario());
        validarTexto(funcionario.getTelefone(), "Telefone obrigatorio.");
        validarTexto(funcionario.getEndereco(), "Endereco obrigatorio.");
    }

    private void validarSalario(BigDecimal salario) {
        if (salario == null) {
            throw new ValidacaoException("Salario obrigatorio.");
        }

        if (salario.compareTo(BigDecimal.ZERO) <= 0) {
            throw new ValidacaoException("Salario deve ser maior que zero.");
        }
    }

    private void validarTexto(String valor, String mensagem) {
        if (valor == null || valor.isBlank()) {
            throw new ValidacaoException(mensagem);
        }
    }
}
