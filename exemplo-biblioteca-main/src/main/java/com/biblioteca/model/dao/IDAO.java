package com.biblioteca.model.dao;

import com.biblioteca.model.entity.AbstractEntity;
import java.util.List;

public interface IDAO<T extends AbstractEntity> {

    void cadastrar(T entidade);

    void atualizar(T entidade);

    void excluir(int id);

    T buscar(int id);

    List<T> listar();

    List<T> buscarPorNome(String nome);

    List<T> buscarPorTipo(String tipo);
}
