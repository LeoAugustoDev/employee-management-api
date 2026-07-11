package br.com.leo.api_gestao_funcionarios.funcionario.domain;

import java.math.BigDecimal;
import java.util.Objects;

public class Funcionario {

    private final Long id;
    private final String nome;
    private final String cargo;
    private final BigDecimal salario;
    private final String telefone;
    private final String endereco;

    public Funcionario(
            Long id,
            String nome,
            String cargo,
            BigDecimal salario,
            String telefone,
            String endereco
    ) {
        this.id = id;
        this.nome = nome;
        this.cargo = cargo;
        this.salario = salario;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCargo() {
        return cargo;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    @Override
    public boolean equals(Object objeto) {
        if (this == objeto) {
            return true;
        }

        if (!(objeto instanceof Funcionario funcionario)) {
            return false;
        }

        return Objects.equals(id, funcionario.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
