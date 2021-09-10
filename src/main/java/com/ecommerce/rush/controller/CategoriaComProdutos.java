package com.ecommerce.rush.controller;

import java.util.List;

import com.ecommerce.rush.repository.Categoria;

public record CategoriaComProdutos(
    int id,
    String nome,
    List<ProdutoSemCat> produtos

)
{
    public static CategoriaComProdutos construir(Categoria categoria, List<ProdutoSemCat> produtos){

        return new CategoriaComProdutos(
            categoria.getId(),
            categoria.getNome(),
            produtos
         
        );
    }
    
    
}
