package com.ecommerce.rush.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.ecommerce.rush.service.Produto;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class ProdutoRepository {

    private List<Produto> produtos = new ArrayList<>();

    // Para pegar o proximo ID da lista (Somar + 1 no ID)
    private int obterProximoID() {

        return produtos.size() + 1;
    }

    // insere produto
    public void inserirProduto(Produto produto) {
        if (produto.getNome().isBlank()) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY,
                    "Obrigatório informar o nome do produto");
        }
        if (produto.getCategoriaIds().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY,
                    "Obrigatório informar a categoria do produto");
        }
        if (produto.getMarca().isBlank()) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY,
                    "Obrigatório informar a marca do produto");
        }

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

    public List<Produto> buscarTodosProdutos() {
        return produtos;
    }
}
