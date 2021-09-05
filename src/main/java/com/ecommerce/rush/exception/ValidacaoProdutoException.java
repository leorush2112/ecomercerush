package com.ecommerce.rush.exception;

public class ValidacaoProdutoException extends RuntimeException {

    public ValidacaoProdutoException(){
        super("É obrigatório informar os seguintes campos para um produto: nome, categorias, marca, preço e estoque.");
    }
    
}


