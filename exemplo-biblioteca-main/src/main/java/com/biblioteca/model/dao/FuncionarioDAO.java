package com.biblioteca.model.dao;

import com.biblioteca.model.entity.Funcionario;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO implements IDAO<Funcionario> {

    private final List<Funcionario> funcionarios;

    public FuncionarioDAO() {
        this.funcionarios = new ArrayList<>();
    }

    @Override
    public void cadastrar(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    @Override
    public void atualizar(Funcionario funcionario) {
        for (Funcionario f : funcionarios) {
            if (f.getId() == funcionario.getId()) {
                f.setNome(funcionario.getNome());
                f.setCargo(funcionario.getCargo());
                return;
            }
        }
        throw new IllegalArgumentException("Funcionário não encontrado para atualização");
    }

    @Override
    public void excluir(int id) {
        boolean removed = funcionarios.removeIf(funcionario -> funcionario.getId() == id);
        if (!removed) {
            throw new IllegalArgumentException("Funcionário não encontrado para exclusão");
        }
    }

    @Override
    public Funcionario buscar(int id) {
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getId() == id) {
                return funcionario;
            }
        }
        return null;
    }

    @Override
    public List<Funcionario> listar() {
        return new ArrayList<>(funcionarios); // Retorna uma cópia da lista para evitar modificações externas
    }

    @Override
    public List<Funcionario> buscarPorNome(String nome) {
        List<Funcionario> funcionariosPorNome = new ArrayList<>();
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getNome().equalsIgnoreCase(nome)) {
                funcionariosPorNome.add(funcionario);
            }
        }
        return funcionariosPorNome;
    }

    @Override
    public List<Funcionario> buscarPorTipo(String tipo) {
        throw new UnsupportedOperationException("Unimplemented method 'buscarPorTipo'");
    }
}
