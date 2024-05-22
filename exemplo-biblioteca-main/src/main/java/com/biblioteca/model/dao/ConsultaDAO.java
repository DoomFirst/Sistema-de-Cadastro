package com.biblioteca.model.dao;

import java.util.ArrayList;
import java.util.List;

import com.biblioteca.model.entity.Consulta;

public class ConsultaDAO implements IDAO<Consulta> {

    private final List<Consulta> consultas;

    public ConsultaDAO() {
        this.consultas = new ArrayList<>();
    }

    @Override
    public void cadastrar(Consulta consulta) {
        consultas.add(consulta);
    }

    @Override
    public void atualizar(Consulta consulta) {
        for (Consulta c : consultas) {
            if (c.getId() == consulta.getId()) {
                c.setDataConsulta(consulta.getDataConsulta());
                c.setIdAnimal(consulta.getIdAnimal());
                c.setIdFuncionario(consulta.getIdFuncionario());
                c.setIdServico(consulta.getIdServico());
                break;
            }
        }
    }

    @Override
    public void excluir(int id) {
        consultas.removeIf(consulta -> consulta.getId() == id);
    }

    @Override
    public Consulta buscar(int id) {
        for (Consulta consulta : consultas) {
            if (consulta.getId() == id) {
                return consulta;
            }
        }
        return null;
    }

    @Override
    public List<Consulta> listar() {
        return consultas;
    }
}
