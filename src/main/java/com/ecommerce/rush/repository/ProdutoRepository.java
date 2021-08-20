package com.ecommerce.rush.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.ecommerce.rush.service.Produto;

public class ProdutoRepository {

    private List<Produto> produtos = new ArrayList<>();

    // Para pegar o proximo ID da lista (Somar + 1 no ID)
    private int obterProximoID() {

        return produtos.size() + 1;
    }

    // insere produto
    public void inserirProduto(Produto produto) {
        int id = obterProximoID();
        produto.setId(id);
        produtos.add(produto);
    }

    // Optional verifica se está vazio ou se tem um objeto dentro
    public Optional<Produto> buscarProduto(int id) { // buscar produto por ID
        for (Produto produto : produtos) {
            if (produto.getId() == id) {
                return Optional.of(produto); // retorna produto
            }
        }
        return Optional.empty(); // retorna vazio

    }

}
