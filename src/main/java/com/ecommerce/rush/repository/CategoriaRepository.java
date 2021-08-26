package com.ecommerce.rush.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.ecommerce.rush.service.Categoria;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class CategoriaRepository {

    private List<Categoria> categorias = new ArrayList<>();

    private int obterProximoID() {
        return categorias.size() + 1;
    }

    public void inserirCategoria(Categoria categoria) {
        if (categoria.getNome().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY,
                    "É obrigatório informar um nome para a categoria.");
        }
        int id = obterProximoID();
        categoria.setId(id);
        categorias.add(categoria);
    }

    public List<Categoria> obterListaCategoriasPorIds(List<Integer> idsLista) {
        List<Categoria> categoriasLista = new ArrayList<>();

        for (int i = 0; i < idsLista.size(); i++) {
            int id = idsLista.get(i);
            Optional<Categoria> categoriaAchou = buscarCategoria(id);
            if (categoriaAchou.isPresent()) {
                categoriasLista.add(categoriaAchou.get());
            }else{
                throw new CategoriaInexistenteException(id);
            }
        }
        
        return categoriasLista;
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
