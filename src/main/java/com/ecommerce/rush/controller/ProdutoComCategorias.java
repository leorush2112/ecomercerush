package com.ecommerce.rush.controller;

import java.util.List;

import com.ecommerce.rush.repository.Categoria;
import com.ecommerce.rush.repository.Produto;


//DTO data transfer Object
public record ProdutoComCategorias(
    int id,
    String nome,
    List<CategoriaSemProduto> categorias,
    String marca,
    double preco,
    int estoque

) 
{
    //Static permite usar o método sem ter instanciado o Objeto
    public static ProdutoComCategorias construir(Produto produto, List<CategoriaSemProduto> categorias){
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
