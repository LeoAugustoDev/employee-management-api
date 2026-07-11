package br.com.leo.api_gestao_funcionarios.funcionario.mapper;

import br.com.leo.api_gestao_funcionarios.funcionario.application.api.request.AtualizarFuncionarioRequest;
import br.com.leo.api_gestao_funcionarios.funcionario.application.api.request.CadastrarFuncionarioRequest;
import br.com.leo.api_gestao_funcionarios.funcionario.application.api.response.FuncionarioCriadoResponse;
import br.com.leo.api_gestao_funcionarios.funcionario.application.api.response.FuncionarioDetalhadoResponse;
import br.com.leo.api_gestao_funcionarios.funcionario.application.api.response.FuncionarioResponse;
import br.com.leo.api_gestao_funcionarios.funcionario.domain.Funcionario;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FuncionarioMapper {

    public Funcionario paraFuncionario(CadastrarFuncionarioRequest request) {
        return new Funcionario(
                request.id(),
                request.nome(),
                request.cargo(),
                request.salario(),
                request.telefone(),
                request.endereco()
        );
    }

    public Funcionario paraFuncionario(Long id, AtualizarFuncionarioRequest request) {
        return new Funcionario(
                id,
                request.nome(),
                request.cargo(),
                request.salario(),
                request.telefone(),
                request.endereco()
        );
    }

    public FuncionarioResponse paraResponse(Funcionario funcionario) {
        return new FuncionarioResponse(
                funcionario.getId(),
                funcionario.getNome(),
                funcionario.getCargo(),
                funcionario.getSalario()
        );
    }

    public List<FuncionarioResponse> paraResponse(List<Funcionario> funcionarios) {
        return funcionarios.stream()
                .map(this::paraResponse)
                .toList();
    }

    public FuncionarioDetalhadoResponse paraDetalhadoResponse(Funcionario funcionario) {
        return new FuncionarioDetalhadoResponse(
                funcionario.getId(),
                funcionario.getNome(),
                funcionario.getCargo(),
                funcionario.getSalario(),
                funcionario.getTelefone(),
                funcionario.getEndereco()
        );
    }

    public FuncionarioCriadoResponse paraCriadoResponse(Funcionario funcionario) {
        return new FuncionarioCriadoResponse(
                funcionario.getId(),
                "Funcionario cadastrado com sucesso."
        );
    }
}
