package com.ecommerce.rush.controller;

import java.util.List;

import com.ecommerce.rush.service.Categoria;
import com.ecommerce.rush.service.Produto;

public record ProdutoComCategorias(
    int id,
    String nome,
    List<Categoria> categoria,
    String marca,
    double preco,
    int estoque

) 
{
    //Static permite usar o método sem ter instanciado o Objeto
    public static ProdutoComCategorias construir(Produto produto, List<Categoria> categorias){
        return new ProdutoComCategorias(
            produto.getId(),
            produto.getNome(),
            categorias,
            produto.getMarca(),
            produto.getPreco(),
            produto.getEstoque()

        );


    }

    
}
