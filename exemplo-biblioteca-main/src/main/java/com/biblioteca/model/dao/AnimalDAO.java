package com.biblioteca.model.dao;

import com.biblioteca.model.entity.Animal;
import java.util.ArrayList;
import java.util.List;

public class AnimalDAO implements IDAO<Animal> {

    private final List <Animal> animais;

    public AnimalDAO() {
        this.animais = new ArrayList<>();
    }

    @Override
    public void cadastrar(Animal animal) {
        animais.add(animal);
    }

    @Override
    public void atualizar(Animal animal) {
        for (Animal a : animais) {
            if (a.getId() == animal.getId()) {
                a.setNome(animal.getNome());
                a.setRaca(animal.getRaca());
                a.setSexo(animal.getSexo());
                a.setTipo(animal.getTipo());
                a.setIdCliente(animal.getIdCliente());
                break;
            }
        }
    }

    @Override
    public void excluir(int id) {
        animais.removeIf(animal -> animal.getId() == id);
    }

    @Override
    public Animal buscar(int id) {
        for (Animal animal : animais) {
            if (animal.getId() == id) {
                return animal;
            }
        }
        return null;
    }

    @Override
    public List<Animal> listar() {
        return animais;
    }

    @Override
    public List<Animal> buscarPorNome(String nome) {
        List<Animal> animaisPorNome = new ArrayList<>();
        for (Animal animal : animais) {
            if (animal.getNome().equalsIgnoreCase(nome)) {
                animaisPorNome.add(animal);
            }
        }
        return animaisPorNome;
    }

    @Override
    public List<Animal> buscarPorTipo(String tipo) {
        List<Animal> animaisPorTipo = new ArrayList<>();
        for (Animal animal : animais) {
            if (animal.getTipo().equalsIgnoreCase(tipo)) {
                animaisPorTipo.add(animal);
            }
        }
        return animaisPorTipo;
    }
}
