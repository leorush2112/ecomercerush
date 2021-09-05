package com.ecommerce.rush.controller;

import com.ecommerce.rush.service.Produto;

public record ProdutoSemCat(
    
    String nome,
    String marca,
    double preco,
    int estoque

)
{ 
    public static ProdutoSemCat construir(Produto produto){

    return new ProdutoSemCat(
        produto.getNome(),
        produto.getMarca(),
        produto.getPreco(),
        produto.getEstoque()

    );
    }
}
