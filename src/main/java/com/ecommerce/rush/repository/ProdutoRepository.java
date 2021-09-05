package com.ecommerce.rush.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.ecommerce.rush.exception.CategoriaInexistenteException;
import com.ecommerce.rush.exception.ValidacaoProdutoException;
import com.ecommerce.rush.service.Categoria;
import com.ecommerce.rush.service.Produto;

import org.springframework.stereotype.Component;


@Component
public class ProdutoRepository {

    private List<Produto> produtos = new ArrayList<>();

    // Para pegar o proximo ID da lista (Somar + 1 no ID)
    private int obterProximoID() {

        return produtos.size() + 1;
    }

    // insere produto
    public void inserirProduto(Produto produto) {
        if (produto.getNome().isBlank()) {
            throw new ValidacaoProdutoException();
        }
        if (produto.getCategoriaIds().isEmpty()) {
            throw new ValidacaoProdutoException();
        }
        if (produto.getMarca().isBlank()) {
            throw new ValidacaoProdutoException();
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


    public List<Produto> buscarProdutosPorCategoria(Categoria categoria){
        List<Produto> produtosPorCategoria = new ArrayList<>();
        
        for(Produto produto : produtos ){
            for(int i = 0 ; i < produto.getCategoriaIds().size(); i++){
            
            if(produto.getCategoriaIds().get(i) == categoria.getId() ){                                

                produtosPorCategoria.add(produto);
            }            
        }           
        } return produtosPorCategoria;
    }

}
