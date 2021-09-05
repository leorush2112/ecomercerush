package com.ecommerce.rush.exception;

public class ValidacaoException extends RuntimeException{
    
    public ValidacaoException (){
        super("É obrigatório informar um nome para a categoria."); 
    }
    
}
