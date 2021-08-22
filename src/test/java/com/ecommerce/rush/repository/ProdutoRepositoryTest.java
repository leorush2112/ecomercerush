package com.ecommerce.rush.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.ecommerce.rush.service.Categoria;
import com.ecommerce.rush.service.Produto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProdutoRepositoryTest {

    // variavel de classe ou Atributo
    private ProdutoRepository produtoRepository;

    @BeforeEach
    public void preparar() {
        // instanciar ProdutoRepository
        produtoRepository = new ProdutoRepository();
        List<Categoria> categorias = new ArrayList<>();
    }

    private Categoria criarCaregoria(List<Categoria> categorias) {

        Categoria categoria = new Categoria();
        categoria.setId(1);
        categoria.setNome("Celulares");
        categorias.add(categoria);

        return categoria;
    }

    private Produto criarProduto() {

        List<Integer> categoriaIds = new ArrayList<>(); // criar lista de IDs e adicionar 1
        categoriaIds.add(1);

        Produto produto = new Produto();
        produto.setNome("Favora");
        produto.setCategoriaIds(categoriaIds);
        produto.setEstoque(15);
        produto.setEstaAtivo(true);
        produto.setPreco(500.00);
        produto.setMarca("Tabajara");

        return produto;
    }

    @Test
    public void deveInserirProduto() {
        // 1 (Given) montar cenário na memória
        // 2 Preciso do produto e do repositório
        Produto produto = criarProduto();
        // WHEN
        produtoRepository.inserirProduto(produto);
        // THEN ( Fazer o buscar produto)
        Optional<Produto> produtoOptional = produtoRepository.buscarProduto(1);
        // Verificar se o Optional tem alguma coisa sentro
        Assertions.assertTrue(produtoOptional.isPresent());

    }
    // Colocar 10 produtos e verificar se os produtos estão com IDs corretos
    // (sóbuscar por ID)
    // Só deve retornar produtos ativos.

}
