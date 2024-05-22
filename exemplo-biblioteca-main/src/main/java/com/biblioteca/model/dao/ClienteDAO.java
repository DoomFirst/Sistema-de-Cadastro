package com.biblioteca.model.dao;

import com.biblioteca.model.entity.Cliente;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO implements IDAO<Cliente> {

    private final List<Cliente> clientes;

    public ClienteDAO() {
        this.clientes = new ArrayList<>();
    }

    @Override
    public void cadastrar(Cliente cliente) {
        clientes.add(cliente);
    }

    @Override
    public void atualizar(Cliente cliente) {
        for (Cliente c : clientes) {
            if (c.getId() == cliente.getId()) {
                c.setNome(cliente.getNome());
                c.setEndereco(cliente.getEndereco());
                c.setTelefone(cliente.getTelefone());
                break;
            }
        }
    }

    @Override
    public void excluir(int id) {
        clientes.removeIf(cliente -> cliente.getId() == id);
    }

    @Override
    public Cliente buscar(int id) {
        for (Cliente cliente : clientes) {
            if (cliente.getId() == id) {
                return cliente;
            }
        }
        return null;
    }

    @Override
    public List<Cliente> listar() {
        return clientes;
    }

    @Override
    public List<Cliente> buscarPorNome(String nome) {
        List<Cliente> clientesPorNome = new ArrayList<>();
        for (Cliente cliente : clientes) {
            if (cliente.getNome().equalsIgnoreCase(nome)) {
                clientesPorNome.add(cliente);
            }
        }
        return clientesPorNome;
    }

    @Override
    public List<Cliente> buscarPorTipo(String tipo) {
        throw new UnsupportedOperationException("Unimplemented method 'buscarPorTipo'");
    }
}
