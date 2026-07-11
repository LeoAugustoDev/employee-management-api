package br.com.leo.api_gestao_funcionarios.funcionario.infra;

import br.com.leo.api_gestao_funcionarios.funcionario.application.repository.FuncionarioRepository;
import br.com.leo.api_gestao_funcionarios.funcionario.domain.Funcionario;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class FuncionarioMapRepository implements FuncionarioRepository {

    private final Map<Long, Funcionario> funcionarios = new HashMap<>();

    @Override
    public Funcionario salvar(Funcionario funcionario) {
        funcionarios.put(funcionario.getId(), funcionario);
        return funcionario;
    }

    @Override
    public Optional<Funcionario> buscarPorId(Long id) {
        return Optional.ofNullable(funcionarios.get(id));
    }

    @Override
    public List<Funcionario> listarTodos() {
        return new ArrayList<>(funcionarios.values());
    }

    @Override
    public boolean existePorId(Long id) {
        return funcionarios.containsKey(id);
    }

    @Override
    public void excluirPorId(Long id) {
        funcionarios.remove(id);
    }
}
