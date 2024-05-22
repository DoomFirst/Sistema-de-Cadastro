package com.biblioteca.model.dao;

import com.biblioteca.model.entity.Servico;
import java.util.ArrayList;
import java.util.List;

public class ServicosDAO implements IDAO<Servico> {

    private final List<Servico> servicos;

    public ServicosDAO() {
        this.servicos = new ArrayList<>();
    }

    @Override
    public void cadastrar(Servico servico) {
        if (buscar(servico.getId()) != null) {
            throw new IllegalArgumentException("ID do serviço já existe");
        }
        servicos.add(servico);
    }

    @Override
    public void atualizar(Servico servico) {
        for (Servico s : servicos) {
            if (s.getId() == servico.getId()) {
                s.setDescricao(servico.getDescricao());
                s.setPreco(servico.getPreco());
                return;
            }
        }
        throw new IllegalArgumentException("Serviço não encontrado para atualização");
    }

    @Override
    public void excluir(int id) {
        boolean removed = servicos.removeIf(servico -> servico.getId() == id);
        if (!removed) {
            throw new IllegalArgumentException("Serviço não encontrado para exclusão");
        }
    }

    @Override
    public Servico buscar(int id) {
        for (Servico servico : servicos) {
            if (servico.getId() == id) {
                return servico;
            }
        }
        return null;
    }

    @Override
    public List<Servico> listar() {
        return new ArrayList<>(servicos); // Retorna uma cópia da lista para evitar modificações externas
    }

    @Override
    public List<Servico> buscarPorNome(String nome) {
        List<Servico> servicosPorNome = new ArrayList<>();
        for (Servico servico : servicos) {
            if (servico.getDescricao().equalsIgnoreCase(nome)) {
                servicosPorNome.add(servico);
            }
        }
        return servicosPorNome;
    }

    @Override
    public List<Servico> buscarPorTipo(String tipo) {
        throw new UnsupportedOperationException("Unimplemented method 'buscarPorTipo'");
    }
}
