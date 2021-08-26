package com.ecommerce.rush.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.ecommerce.rush.service.Categoria;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class CategoriaRepositoryTest {

    private CategoriaRepository categoriaRepository;

    @BeforeEach
    public void preparar() {
        // Instanciar Repository Categoria
        categoriaRepository = new CategoriaRepository();
    }

    private Categoria criarCategoria() {

        List<Categoria> categorias = new ArrayList<>();

        Categoria categoria = new Categoria();
        categoria.setId(1);
        categoria.setNome("Celulares");
        categorias.add(categoria);

        return categoria;
    }

    @Test
    public void deveInserirCategoria() {
        // Given
        // Dado que Preciso inserir uma categoria em um repositório

        Categoria categoria = criarCategoria();
        // When adiciono um produto
        categoriaRepository.inserirCategoria(categoria);
        // Then (Fazer o "buscar Categoria")
        Optional<Categoria> categoriaOptional = categoriaRepository.buscarCategoria(1);
        Assertions.assertTrue(categoriaOptional.isPresent());
        System.out.println(categoria.getId() + ":" + categoria.getNome());

    }

}
