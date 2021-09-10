package com.ecommerce.rush.controller;

import com.ecommerce.rush.repository.Categoria;

public record CategoriaSemProduto (
    int id,
    String nome    
)
{
    public static CategoriaSemProduto construir(Categoria categoria) {      
        return new CategoriaSemProduto(            
            categoria.getId(),
            categoria.getNome()
        );
    }
    
}
