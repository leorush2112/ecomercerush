package com.ecommerce.rush.repository;

public class CategoriaInexistenteException extends RuntimeException {

    public CategoriaInexistenteException (int id){
        super("Categoria Não Encontrada: " +id); 
    }
    
}
