package com.ecommerce.rush.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.ecommerce.rush.service.Categoria;

public class CategoriaRepository {

    private List<Categoria> categorias = new ArrayList<>();

    private int obterProximoID() {
        return categorias.size() + 1;
    }

    public void inserirCategoria(Categoria categoria) {
        int id = obterProximoID();
        categoria.setId(id);
        categorias.add(categoria);
    }

    public Optional<Categoria> buscarCategoria(int id) {
        for (Categoria categoria : categorias) {
            if (categoria.getId() == id) {
                return Optional.of(categoria);
            }
        }
        return Optional.empty();

    }

    public List<Categoria> buscarTodasCategorias() {
        return categorias;
    }

}
