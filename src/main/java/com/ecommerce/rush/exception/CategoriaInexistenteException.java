package com.ecommerce.rush.exception;

public class CategoriaInexistenteException extends RuntimeException {

    public CategoriaInexistenteException (int id){
        super("Categoria "+ id +" não Encontrada."); 
    }
    
}
